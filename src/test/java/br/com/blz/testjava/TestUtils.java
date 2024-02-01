package br.com.blz.testjava;

import br.com.blz.testjava.constant.WarehouseType;
import br.com.blz.testjava.dto.ProductDto;
import br.com.blz.testjava.entity.Inventory;
import br.com.blz.testjava.entity.Product;
import br.com.blz.testjava.entity.Warehouse;

import java.util.List;

public class TestUtils {

    public static final int SKU = 1234;
    public static final int DIFFERENT_SKU = 111;

    public static Product getProduct() {
        return getProductDto().convertToProduct();
    }

    public static ProductDto getProductDto() {
        return ProductDto.builder()
            .sku(SKU)
            .name("Mock Company")
            .inventory(getInventory())
            .build();
    }

    public static ProductDto getNewProductDto() {
        return ProductDto.builder()
            .sku(DIFFERENT_SKU)
            .name("New Product")
            .inventory(getInventory())
            .build();
    }

    public static Inventory getInventory() {
        return Inventory.builder()
            .warehouses(List.of(getWarehouse()))
            .build();
    }

    public static Warehouse getWarehouse() {
        return Warehouse.builder()
            .locality("SP")
            .quantity(2)
            .type(WarehouseType.ECOMMERCE)
            .build();
    }
}
