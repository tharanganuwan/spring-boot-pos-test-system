package com.pos.system.point_of_sell.dto.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCustomerSalaryAddressDTO {
    private int customerId;
    private String customerAddress;
    private double customer_salary;
}
