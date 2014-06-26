package com.prodcod.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Item implements Serializable{

	private static final long serialVersionUID = -429708360254033010L;

	protected String title;

	protected String publisher;

	protected BigDecimal price;

	protected int yearPublished;

	/**
	 * no arg constructor
	 */
	public Item(){

	}

	public Item(final String title, final String publisher, final BigDecimal price, final int yearPublished) {
		this.title = title;
		this.publisher = publisher;
		this.price = round(price);
		this.yearPublished = yearPublished;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	/**
	 * Round for currency values
	 * @param value
	 * @return
	 */
	private BigDecimal round(final BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + yearPublished;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (yearPublished != other.yearPublished)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [title=" + title + ", publisher=" + publisher + ", price="
				+ price + ", yearPublished=" + yearPublished + "]";
	}



}
