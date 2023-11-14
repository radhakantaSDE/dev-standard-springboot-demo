package com.learn.app.service;

import com.learn.app.model.response.CartResponse;

public interface CartService {

  CartResponse getCartDetails(String userId);
}
