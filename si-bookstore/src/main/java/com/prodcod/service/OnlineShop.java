package com.prodcod.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prodcod.domain.Book;
import com.prodcod.domain.MusicCD;
import com.prodcod.domain.Order;
import com.prodcod.domain.OrderItem;
import com.prodcod.domain.Software;

/**
 * Main class to invoke 
 * @author BruceWayne
 *
 */
public class OnlineShop {

	private static final Logger log = Logger.getLogger(OnlineShop.class);
	
	public static void main(String[] args) {

		//Get hold of spring context
		AbstractApplicationContext context =
			new ClassPathXmlApplicationContext("/META-INF/com/prodcod/shop.xml", OnlineShop.class);

		//Inject in Shop instance (Gateway)
		Shop shop = (Shop) context.getBean("shop");
		
		final Order order = createOrder();
		
		
		log.debug("*** [OnlineShop] ****");
		shop.placeOrder(order);
		
		context.close();
	}

	/*
	 * Create a dummy order
	 */
	private static Order createOrder() {
		Book book = new Book("Of Mice & Men", "Bluebird", new BigDecimal("100"), 1988, "John Steinbeck");
		MusicCD cd = new MusicCD("Off the Wall", "publisher", new BigDecimal("100"), 1975, "Michael Jackson");
		Software macos = new Software("Mavericks", "publisher", new BigDecimal("100"), 2014, "10.9.3");
		
		OrderItem bookItems = new OrderItem(book);
//		bookItems.incrementQuantity();
		
		OrderItem cdItems = new OrderItem(cd);
//		cdItems.incrementQuantity();
//		cdItems.incrementQuantity();
		
		OrderItem swItems = new OrderItem(macos);
		
		final List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItems.add(bookItems);
		orderItems.add(cdItems);
		orderItems.add(swItems);
		
		Order order = new Order();
		order.setOrderItems(orderItems);
		log.debug("Order: " + order);
//		log.debug("Total : "+ order.getTotalCost());

		return order;
	}
}


