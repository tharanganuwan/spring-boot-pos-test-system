package com.pos.system.point_of_sell.dto;

import com.pos.system.point_of_sell.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnite;
    private double balanceQty;
    private double supplierPrice;
    private double SellingPrice;
    private boolean activeState;
}
