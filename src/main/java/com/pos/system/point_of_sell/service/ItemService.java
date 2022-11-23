package com.pos.system.point_of_sell.service;

import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.ItemDTO;
import com.pos.system.point_of_sell.dto.request.ItemSaveRequestDTO;

import java.util.List;

public interface ItemService {

    String addItem(ItemSaveRequestDTO itemSaveRequestDTO) throws Exception;


    List<ItemDTO> getAllCustomers();

    List<ItemDTO> getAllCustomersByStateType(boolean status);
}
