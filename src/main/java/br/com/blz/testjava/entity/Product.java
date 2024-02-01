package br.com.blz.testjava.entity;

import br.com.blz.testjava.dto.ProductDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Product {

    private Integer sku;
    private String name;
    private Inventory inventory;
    private boolean isMarketable;

    public boolean getIsMarketable() {
        return this.inventory.getQuantity() > 0;
    }

    public void editProduct(ProductDto productDto) {
        this.name = productDto.name();
        this.inventory = productDto.inventory();
    }
}