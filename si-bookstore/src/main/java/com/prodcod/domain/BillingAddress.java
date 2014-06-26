package com.prodcod.domain;

import java.io.Serializable;

/**
 * Class to represent billing address
 * @author BruceWayne
 *
 */
public class BillingAddress extends Address implements Serializable{

	private static final long serialVersionUID = -3977964168622401031L;

	public BillingAddress() {		
		type = AddressType.BILLING_ADDRESS;
	}

	public BillingAddress(final String firstLineOfAddress, final String city, final String postCode) {		
		super(firstLineOfAddress, city, postCode);
		type = AddressType.BILLING_ADDRESS;
	}

}
