package br.com.blz.testjava.entity;

import br.com.blz.testjava.constant.WarehouseType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Warehouse {

    @NotNull
    @NotEmpty
    private String locality;
    @NotNull
    @NotEmpty
    private Integer quantity;
    @NotNull
    @NotEmpty
    private WarehouseType type;
}
