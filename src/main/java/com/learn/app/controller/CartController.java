package com.learn.app.controller;

import com.learn.app.model.CartDto;
import com.learn.app.model.response.CartResponse;
import com.learn.app.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cart-service/v1/")
public class CartController {

  private final CartService cartService;

  @Operation(summary = "Get cart details by user-id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Found the cart",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = CartResponse.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid user-id supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Cart not found", content = @Content)
      })
  @GetMapping("cart/{user-id}")
  public ResponseEntity<CartResponse> cartDetails(
      @RequestHeader("tracking-id") String trackId, @PathVariable("user-id") String userId) {

    return ResponseEntity.ok(cartService.getCartDetails(userId));
  }

  @Operation(summary = "Create cart details by user-id")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Created the card"),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid cart request"),
        @ApiResponse(responseCode = "404", description = "Cart not found")
      })
  @PostMapping("cart")
  public ResponseEntity<CartResponse> createCart(
      @RequestHeader("tracking-id") String trackId, @RequestBody CartDto cartDto) {

    return ResponseEntity.ok(cartService.createCart(cartDto));
  }
}
