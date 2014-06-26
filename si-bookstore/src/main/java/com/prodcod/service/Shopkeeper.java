package com.prodcod.service;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.prodcod.domain.Book;
import com.prodcod.domain.MusicCD;
import com.prodcod.domain.OrderItem;
import com.prodcod.domain.Software;

/**
 * Class invoked by ServiceActivator
 * Performs the price reductions for all item types.
 * @author BruceWayne
 *
 */
public class Shopkeeper {

	private static final Logger log = Logger.getLogger(Shopkeeper.class);

	private static final BigDecimal BOOK_DISCOUNT = new BigDecimal(0.05);
	private static final BigDecimal MUSIC_DISCOUNT = new BigDecimal(0.10);
	private static final BigDecimal SOFTWARE_DISCOUNT = new BigDecimal(0.15);

	/**
	 * Performs discount on books
	 * @param bookOrderItem OrderItem comprising of a book item
	 * @return OrderItem with discount price newly calculated
	 */
	public OrderItem processBooks(OrderItem bookOrderItem){		
		log.debug("*** [Shopkeeper] processing book : "+ bookOrderItem.getItem().getTitle() +" ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(bookOrderItem, BOOK_DISCOUNT);
				
		bookOrderItem.setDiscountedPrice(finalPrice);

		return bookOrderItem;
	}
	
	/**
	 * Performs discount on music
	 * @param musicOrderItem OrderItem comprising of a music item
	 * @return OrderItem with discount price newly calculated
	 */
	public  OrderItem processMusic(OrderItem musicOrderItem){		
		log.debug("*** [Shopkeeper] processing music : "+ musicOrderItem.getItem().getTitle() +" ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(musicOrderItem, MUSIC_DISCOUNT);

		musicOrderItem.setDiscountedPrice(finalPrice);
			
		return musicOrderItem;
	}

	/**
	 * Performs discount on software
	 * @param softwareOrderItem OrderItem comprising of a book item
	 * @return OrderItem with discount price newly calculated
	 */
	public  OrderItem processSoftware(OrderItem softwareOrderItem){		
		log.debug("*** [Shopkeeper] processing software : "+ softwareOrderItem.getItem().getTitle() +" ****");

		final BigDecimal finalPrice = calculateDiscountedPrice(softwareOrderItem, SOFTWARE_DISCOUNT);
		
		softwareOrderItem.setDiscountedPrice(finalPrice);
		
		return softwareOrderItem;
	}

	/*
	 * Computes the new discounted price for an item
	 * @param orderItem the item of interest
	 * @param discount The amount to be discounted.
	 */
	private BigDecimal calculateDiscountedPrice(final OrderItem orderItem, final BigDecimal discount) {

		final BigDecimal discountedPrice =round(orderItem.getTotalPrice().multiply(discount));
		final BigDecimal finalPrice = round(orderItem.getTotalPrice().subtract(discountedPrice));

		log.debug("item (" + getItemType(orderItem) + ") " +  
				"item price: " + orderItem.getItem().getPrice() +
				" discount: " + discountedPrice +
				" final price: " + finalPrice);

		return finalPrice;
	}

	private String getItemType(final OrderItem orderItem) {

		String type = "";
		
		if(orderItem.getItem() instanceof Book) {
			type = "Book: " + orderItem.getItem().getTitle(); 
		}
		else if(orderItem.getItem() instanceof MusicCD) {
			type = "MusicCD: " + orderItem.getItem().getTitle(); 			
		}
		else if(orderItem.getItem() instanceof Software) {
			type = "Software: " + orderItem.getItem().getTitle(); 			
		}

		return type;
	}
	
	/**
	 * Round for currency values
	 * @param value
	 * @return
	 */
	private BigDecimal round(final BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

}
