package com.learn.app.controller;

import com.learn.app.model.response.CartResponse;
import com.learn.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cart-service/v1/")
public class CartController {

  @Autowired private CartService cartService;

  @GetMapping("cart/{user-id}")
  public ResponseEntity<CartResponse> cartDetails(@PathVariable("user-id") String userId) {

    return ResponseEntity.ok(cartService.getCartDetails(userId));
  }
}
