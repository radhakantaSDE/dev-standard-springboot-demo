package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartDto {

  private String uuid;
  private String userUuid;
  private List<ProductDto> cartProducts;
  private String offerId;
}
