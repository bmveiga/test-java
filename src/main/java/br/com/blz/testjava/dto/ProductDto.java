package br.com.blz.testjava.dto;

import br.com.blz.testjava.entity.Inventory;
import br.com.blz.testjava.entity.Product;

public record ProductDto(Integer sku,
                         String name,
                         Inventory inventory) {

    public Product convertToProduct() {
        return Product.builder()
            .sku(this.sku)
            .name(this.name)
            .inventory(this.inventory)
            .build();
    }
}
