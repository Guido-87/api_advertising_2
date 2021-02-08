package com.api.advertising.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.api.advertising.model.Ad;

public interface AdsRepository extends CrudRepository<Ad, Long>, JpaSpecificationExecutor<Ad> {

	final static String REGISTERED = "registered";
	final static String END_DATE = "endDate";
	final static LocalDate today = LocalDate.now();

	static Specification<Ad> isRegistered() {
		return (ad, cq, cb) -> cb.equal(ad.get(REGISTERED), Boolean.TRUE);
	}

	static Specification<Ad> isNotEndDate() {
		return (ad, cq, cb) -> cb.lessThan(ad.get(END_DATE), today);
	}
}