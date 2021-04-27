package com.ecommerce.onlineshopping.service;

import com.ecommerce.onlineshopping.model.Address;

public interface AddressService {

	boolean saveAddress(Address address);
	Address findAddressByBilling(boolean billing);

}
