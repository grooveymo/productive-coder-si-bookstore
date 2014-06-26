package com.prodcod.domain;

import java.math.BigDecimal;


public class Book extends Item{

	private static final long serialVersionUID = 3299079753642372160L;

	private String author;
	
	public Book(){
		super();
	}
	
	public Book(final String title, final String publisher, final BigDecimal price, final int yearPublished, final String author) {
		super(title, publisher, price, yearPublished);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " Book [author=" + author + "]";
	}
	
	
}
