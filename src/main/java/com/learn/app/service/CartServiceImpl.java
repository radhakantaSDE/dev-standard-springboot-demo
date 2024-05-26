package com.learn.app.service;

import com.learn.app.model.CartDto;
import com.learn.app.model.response.CartResponse;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Data
@Slf4j
@Service
@RequestScope
public class CartServiceImpl implements CartService {

  private String cartId = "-";
  private static Map<String, CartDto> cartDtoMap = new ConcurrentHashMap<>();

  @Override
  public CartResponse getCartDetails(String userId) {
    if (userId != null) this.cartId = userId;

    log.info("Fetching log info : {} {}", cartId, MDC.get("tracking-id"));
    return CartResponse.builder()
        .cartDto(CartDto.builder().uuid("fasdf-hgdhsd-hf78gt-sdurg4").build())
        .build();
  }

  @Override
  public CartResponse createCart(CartDto cartDto) {

    String uuid = UUID.randomUUID().toString();
    cartDto.setUuid(uuid);
    cartDtoMap.put(uuid, cartDto);

    return CartResponse.builder().cartDto(cartDto).build();
  }
}
