package com.ecommerce.onlineshopping.service;

import com.ecommerce.onlineshopping.model.Cart;

public interface CartService {
	
	boolean saveCart(Cart cart);
	boolean updateCart(Cart cart);
	
	Cart findCart();

}
