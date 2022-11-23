package com.pos.system.point_of_sell.dto.request;

import com.pos.system.point_of_sell.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemSaveRequestDTO {
    private String itemName;
    private String measuringUnite;
    private double balanceQty;
    private double supplierPrice;
    private double SellingPrice;
}
