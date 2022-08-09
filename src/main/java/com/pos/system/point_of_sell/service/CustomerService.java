package com.pos.system.point_of_sell.service;

import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.request.CustomerSaveRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateQueryRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateRequestDTO;
import com.pos.system.point_of_sell.dto.responce.ResponseActiveCustomerDTO;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService {

    String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO);

    String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO);

    CustomerDTO getCustomerById(int customerId);

    List<CustomerDTO> getAllCustomers();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException;

    List<CustomerDTO> getCustomerByActiveState() throws NotFoundException;

    List<ResponseActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException;

    String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id);
}
