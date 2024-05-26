package com.learn.app.service;

import com.learn.app.model.CartDto;
import com.learn.app.model.response.CartResponse;

public interface CartService {

  CartResponse getCartDetails(String userId);

  CartResponse createCart(CartDto cartDto);
}
