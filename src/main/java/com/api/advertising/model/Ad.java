package com.api.advertising.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
@Table(name = "Ads")
@JsonInclude(Include.NON_NULL)
public class Ad implements Serializable {

	private static final long serialVersionUID = 6260916742725562864L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("printing_cost")
	private Double printingCost;
	@JsonProperty("max_printing_cost")
	private Double maxPrintingCost;
	@JsonProperty("end_date")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	private Boolean registered;
	@OneToOne(cascade = { CascadeType.ALL })
	private Segmentation segmentation;
	private String title;
	private String description;

	public Ad() {
	}

	public Ad(Long id, Double printingCost, Double maxPrintingCost, LocalDate endDate, Boolean registered,
			Segmentation segmentation, String title, String description) {
		this.id = id;
		this.printingCost = printingCost;
		this.maxPrintingCost = maxPrintingCost;
		this.endDate = endDate;
		this.registered = registered;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrintingCost() {
		return printingCost;
	}

	public void setPrintingCost(Double printingCost) {
		this.printingCost = printingCost;
	}

	public Double getMaxPrintingCost() {
		return maxPrintingCost;
	}

	public void setMaxPrintingCost(Double maxPrintingCost) {
		this.maxPrintingCost = maxPrintingCost;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Boolean isRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public Segmentation getSegmentation() {
		return segmentation;
	}

	public void setSegmentation(Segmentation segmentation) {
		if (Boolean.TRUE.equals(this.registered)) {
			this.segmentation = segmentation;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
