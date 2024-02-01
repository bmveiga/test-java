package br.com.blz.testjava.entity;

import br.com.blz.testjava.constant.WarehouseType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Warehouse {

    private String locality;
    private Integer quantity;
    private WarehouseType type;
}
