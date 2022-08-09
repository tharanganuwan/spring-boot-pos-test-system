package com.pos.system.point_of_sell.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateQueryRequestDTO {
    private String nic;
    private String customerName;
}
