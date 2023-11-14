package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

  private String uuid;
  private String
      specifications; // This should be a separate info class but, for quick impl added as string
  private Integer quantity;
}
