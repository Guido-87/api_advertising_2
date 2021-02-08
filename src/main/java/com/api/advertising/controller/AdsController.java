package com.api.advertising.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.advertising.model.Ad;
import com.api.advertising.repository.AdsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/ads")
public class AdsController {

	private static final Double TWENTY_FIVE_PERCENT = 0.25;
	private static final Integer SEVENTY_FIVE_PERCENT = 75;
	private static final Integer ONE_HUNDRED_PERCENT = 100;
	private static final Integer THREE = 3;
	private final AdsRepository adsRepository;
	private static final Random random = new Random();

	@Autowired
	public AdsController(final AdsRepository adsRepository) {
		this.adsRepository = adsRepository;
	}

	@PostMapping()
	public ResponseEntity<String> create(@Validated @RequestBody Ad ad, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Binding error.");
		}
		if (ad.getId() != null && adsRepository.existsById(ad.getId())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id already exists.");
		}
		Ad createdAd = adsRepository.save(ad);
		if (createdAd != null) {
			return new ResponseEntity<>("Ad created succesfully.", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error creating ad.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Only registered users, 25% most expensive ads have 75% chance of appearing
	@GetMapping(value = "/getThreeRandomAds")
	public String getThreeRandomAds() throws JsonProcessingException {
		List<Ad> expensiveAds = new ArrayList<Ad>();
		adsRepository.findAll(AdsRepository.isRegistered().and(AdsRepository.isNotEndDate()))
				.forEach(expensiveAds::add);
		if (expensiveAds.isEmpty() || expensiveAds.size() < THREE) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No ads from registered users found.");
		}
		expensiveAds.sort(Comparator.comparing(Ad::getPrintingCost).reversed());
		Double topElements = expensiveAds.size() * TWENTY_FIVE_PERCENT;
		List<Ad> threeRandomAds = new ArrayList<Ad>();
		for (int i = 0; i < THREE; i++) {
			int index = random.nextInt(ONE_HUNDRED_PERCENT) < SEVENTY_FIVE_PERCENT
					? random.nextInt((int) Math.round(topElements))
					: random.nextInt(expensiveAds.size());
			threeRandomAds.add(expensiveAds.get(index));
			expensiveAds.remove(index);
		}
		return new ObjectMapper().writeValueAsString(threeRandomAds);
	}

	@GetMapping()
	public String getAll() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(adsRepository.findAll());
	}
}