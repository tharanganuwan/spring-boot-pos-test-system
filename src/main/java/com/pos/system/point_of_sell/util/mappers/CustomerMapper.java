package com.pos.system.point_of_sell.util.mappers;

import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.responce.ResponseActiveCustomerDTO;
import com.pos.system.point_of_sell.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(Customer customer);
    List<CustomerDTO> entityListToDtoList(List<Customer> customers);
    List<ResponseActiveCustomerDTO> entityListToDtoListOnlyName (List<Customer> customers);
}
