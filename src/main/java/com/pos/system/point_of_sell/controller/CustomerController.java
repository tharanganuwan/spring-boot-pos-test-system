package com.pos.system.point_of_sell.controller;
import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.request.CustomerSaveRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateNameSalaryNicRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateQueryRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateRequestDTO;
import com.pos.system.point_of_sell.dto.responce.ResponseActiveCustomerDTO;
import com.pos.system.point_of_sell.dto.responce.ResponseCustomerSalaryAddressDTO;
import com.pos.system.point_of_sell.service.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
        String id = customerService.addCustomer(customerSaveRequestDTO);
        return id;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String updated = customerService.updateCustomer(customerUpdateRequestDTO);
        return updated;
    }

    @GetMapping(path = "/get-by-id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {

        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/get-all-customers")
    public List<CustomerDTO> customerDTO() {

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(
            path = {"/delete-customer/{id}"}
    )
    public String deleteCustomer(@PathVariable(value = "id") int id) throws NotFoundException {
        boolean deletedCustomer = customerService.deleteCustomer(id);
        return "deleted";
    }

    @GetMapping(
            path = {"/get-by-name"},
            params = {"name"}
    )
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name") String customerName) throws NotFoundException {
        List<CustomerDTO> getCustomer = customerService.getCustomerByName(customerName);
        return getCustomer;
    }

    @GetMapping(
            path = {"/get-by-active-state"}
    )
    public List<CustomerDTO> getCustomerByActiveState() throws NotFoundException {
        List<CustomerDTO> getCustomers = customerService.getAllCustomerByActiveState();
        return getCustomers;
    }

    @GetMapping(
            path = {"/get-by-active-state-only-name"}
    )
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException {
        List<ResponseActiveCustomerDTO> getCustomers = customerService.getCustomerByActiveStateOnlyName();
        return getCustomers;
    }

    @PutMapping(path = "/update-query/{id}")
    public String updateCustomerByQuery(
            @RequestBody CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO,
            @PathVariable(value = "id") int id) {
        String updated = customerService.updateCustomerByQuery(customerUpdateQueryRequestDTO,id);
        return updated;
    }
    @GetMapping(
            path = {"/get-all-customers-by-nic/{nic}"}
    )
    public CustomerDTO getCustomerByNic(@PathVariable(value = "nic")String nic) throws NotFoundException {
        CustomerDTO customer = customerService.getCustomerByNic(nic);
        return  customer;
    }

    @GetMapping(
            path = {"/get-salary-address-by-id"},
            params = {"id"}
    )
    public ResponseCustomerSalaryAddressDTO getCustomerSalaryAddressById(@RequestParam(value = "id") int id) throws NotFoundException {
        ResponseCustomerSalaryAddressDTO responseCustomerSalaryAddressDTO = customerService.getCustomerSalaryAddressById(id);
        return responseCustomerSalaryAddressDTO;
    }
    @PutMapping(
            path = {"/update-by-id-name-salary-nic/{id}"}
    )
    public String updateCustomerByRequestDto(
            @PathVariable(value = "id")int id,
            @RequestBody CustomerUpdateNameSalaryNicRequestDTO customerUpdateNameSalaryNicRequestDTO
    ){
        String update = customerService.updateCustomerByRequestDto(id,customerUpdateNameSalaryNicRequestDTO);
        return  update;
    }

}
