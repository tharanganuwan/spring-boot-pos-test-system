package com.pos.system.point_of_sell.service.impl;

import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.request.CustomerSaveRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateQueryRequestDTO;
import com.pos.system.point_of_sell.dto.request.CustomerUpdateRequestDTO;
import com.pos.system.point_of_sell.dto.responce.ResponseActiveCustomerDTO;
import com.pos.system.point_of_sell.entity.Customer;
import com.pos.system.point_of_sell.repositary.CustomerRepo;
import com.pos.system.point_of_sell.service.CustomerService;
import com.pos.system.point_of_sell.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    //@Autowired
    private CustomerMapper customerMapper;



    @Override
    public String addCustomer(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer = new Customer(
                5,
                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomer_salary(),
                customerSaveRequestDTO.getContactNumbers(),
                customerSaveRequestDTO.getNic(),
                false
        );

        if (!customerRepo.existsById(customer.getCustomerId())) {
            customerRepo.save(customer);
            return customer.getCustomerName() + "saved";
        } else {
            System.out.println("customer id already exits");
            return "customer id already exits";
        }
    }

    @Override
    public String updateCustomer(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        if (customerRepo.existsById(customerUpdateRequestDTO.getCustomerId())) {
            Customer customer = customerRepo.getById(customerUpdateRequestDTO.getCustomerId());
            customer.setCustomerName(customerUpdateRequestDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateRequestDTO.getCustomerAddress());
            customer.setCustomer_salary(customerUpdateRequestDTO.getCustomer_salary());
            customer.setContactNumbers(customerUpdateRequestDTO.getContactNumbers());
            customer.setActiveState(customerUpdateRequestDTO.isActiveState());

            return customerRepo.save(customer).getCustomerName() + "updated";
        } else {
            return "this customer id not in database";
        }

    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {

        Optional<Customer> customer = customerRepo.findById(customerId);
        if (customer.isPresent()) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.get().getCustomerId(),
//                    customer.get().getCustomerName(),
//                    customer.get().getCustomerAddress(),
//                    customer.get().getCustomer_salary(),
//                    customer.get().getContactNumbers(),
//                    customer.get().getNic(),
//                    customer.get().isActiveState()
//            );
            //or use model mapper
         //   CustomerDTO customerDTO = modelMapper.map(customer.get(), CustomerDTO.class); // uda okkoma tika me widiata lesiyen map karagatha heki
       //  or use mapstruct
        CustomerDTO customerDTO = customerMapper.entityToDto(customer.get());

            return customerDTO;

        } else {
            return null;
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getCustomer = customerRepo.findAll();

//        List<CustomerDTO> customerDTOList = new ArrayList<>();
//        for (Customer c : getCustomer) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    c.getCustomerId(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getCustomer_salary(),
//                    c.getContactNumbers(),
//                    c.getNic(),
//                    c.isActiveState()
//
//            );
//            customerDTOList.add(customerDTO);
//        }

        //use this way essialy dont want to you foreach
        List<CustomerDTO> customerDTOS = modelMapper.
                map(getCustomer, new TypeToken<List<CustomerDTO>>() {
                }.getType());

        return customerDTOS;
    }

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new NotFoundException("not found customer for this id");
        }
        return true;
    }

    @Override
    public List<CustomerDTO> getCustomerByName(String customerName) throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByCustomerNameEquals(customerName);
        if (customers.size()!=0){
            List<CustomerDTO> customerDTOS = modelMapper.
                    map(customers, new TypeToken<List<CustomerDTO>>() {
                    }.getType());

            return  customerDTOS;
        }else {
            throw new NotFoundException("no results");
        }
    }

    @Override
    public List<CustomerDTO> getCustomerByActiveState() throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if (customers.size()!=0){
            List<CustomerDTO> customerDTOS = customerMapper.entityListToDtoList(customers);
            return  customerDTOS;
        }else{
            throw new NotFoundException("no active customer found found");
        }
    }

    @Override
    public List<ResponseActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException {
        List<Customer> customers = customerRepo.findAllByActiveStateEquals(true);
        if (customers.size()!=0){
            List<ResponseActiveCustomerDTO> customerDTOS = customerMapper.entityListToDtoListOnlyName(customers);
            return  customerDTOS;
        }else{
            throw new NotFoundException("no active customer found found");
        }
    }

    @Override
    public String updateCustomerByQuery(CustomerUpdateQueryRequestDTO customerUpdateQueryRequestDTO, int id) {
        if(customerRepo.existsById(id)){
           customerRepo.updateCustomerByQuery(customerUpdateQueryRequestDTO.getCustomerName(),customerUpdateQueryRequestDTO.getNic(),id);
            return "Update successful id :"+id;
        }else{
            return "Update not successful id :"+id;
        }
    }
}
