package com.learn.app.model.response;

import com.learn.app.model.CartDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartResponse {

  private CartDto cartDto;
  private String dispatchAddress;
}
