package com.learn.app.service;

import com.learn.app.model.response.CartResponse;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Data
@Service
@RequestScope
public class CartServiceImpl implements CartService {

  private String cartId = "-";

  @Override
  public CartResponse getCartDetails(String userId) {
    if (userId != null) this.cartId = userId;
    System.out.println(cartId);
    return CartResponse.builder().build();
  }
}
