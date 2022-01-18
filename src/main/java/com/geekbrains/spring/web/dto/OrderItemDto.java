package com.geekbrains.spring.web.dto;

import com.geekbrains.spring.web.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int pricePerProduct;
    private int price;

    public OrderItemDto(ProductEntity productEntity) {
        this.productId = productEntity.getId();
        this.productTitle = productEntity.getTitle();
        this.quantity = 1;
        this.pricePerProduct = productEntity.getPrice();
        this.price = productEntity.getPrice();
    }

    public void changeQuantity(int delta) {
        this.quantity += delta;
        this.price = this.quantity * this.pricePerProduct;
    }
}
