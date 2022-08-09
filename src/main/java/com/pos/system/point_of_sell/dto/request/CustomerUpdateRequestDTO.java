package com.pos.system.point_of_sell.dto.request;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Data         //uda 3 ma wenuwata data kinana ek adanna puluwan
public class CustomerUpdateRequestDTO {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private double customer_salary;
    private ArrayList contactNumbers;
    private boolean activeState;

}
