package com.pos.system.point_of_sell.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateNameSalaryNicRequestDTO {
    private String customerName;
    private double customer_salary;
    private String nic;

}
