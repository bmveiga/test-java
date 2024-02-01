package br.com.blz.testjava.dto;

import br.com.blz.testjava.entity.Inventory;
import br.com.blz.testjava.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductDto {

    @NotNull
    private Integer sku;
    @NotNull
    private String name;
    private Inventory inventory;

    public Product convertToProduct() {
        return Product.builder()
            .sku(this.sku)
            .name(this.name)
            .inventory(this.inventory)
            .build();
    }
}
