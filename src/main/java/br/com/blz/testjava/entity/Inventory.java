package br.com.blz.testjava.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Inventory {

    private Integer quantity;
    private List<Warehouse> warehouses;

    public Integer getQuantity() {
        return warehouses.stream().mapToInt(Warehouse::getQuantity).sum();
    }
}
