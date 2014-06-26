package com.prodcod.service;

import org.apache.log4j.Logger;

import com.prodcod.domain.Book;
import com.prodcod.domain.MusicCD;
import com.prodcod.domain.OrderItem;
import com.prodcod.domain.Software;

/**
 * Performs routing based on item type.
 * Will redirect 
 * 				to bookItemsChannel if the item is of type book
 * 				to musicItemsChannel if the item is of type musicCD
 * 				to softwareItemsChannel if the item is of type software
 * 
 * @author BruceWayne
 *
 */
public class OrderItemRouter {

	private static final Logger log = Logger.getLogger(OrderItemRouter.class);

	public String routeOrder(OrderItem orderItem) {
		
		log.debug("*** [OrderItemRouter] ****");

		String channel = "";
		if(isBook(orderItem)) {
			channel = "bookItemsChannel";
		}
		else if(isMusic(orderItem)) {
			channel = "musicItemsChannel";
		}
		else if(isSoftware(orderItem)) {
			channel = "softwareItemsChannel";
		}

		log.debug("*** [OrderItemRouter] sending item : " + orderItem.getItem().getTitle() + " to "+ channel +  " ****");

		return channel;
   }
	
	private Boolean isBook(OrderItem orderItem) {
		return orderItem.getItem() instanceof Book;			
	}
	private Boolean isMusic(OrderItem orderItem) {
		return orderItem.getItem() instanceof MusicCD;			
	}
	private Boolean isSoftware(OrderItem orderItem) {
		return orderItem.getItem() instanceof Software;			
	}
}
