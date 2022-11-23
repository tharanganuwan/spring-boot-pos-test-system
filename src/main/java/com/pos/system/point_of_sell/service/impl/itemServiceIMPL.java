package com.pos.system.point_of_sell.service.impl;


import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.ItemDTO;
import com.pos.system.point_of_sell.dto.request.ItemSaveRequestDTO;
import com.pos.system.point_of_sell.entity.Customer;
import com.pos.system.point_of_sell.entity.Item;
import com.pos.system.point_of_sell.repositary.ItemRepo;
import com.pos.system.point_of_sell.service.ItemService;
import com.pos.system.point_of_sell.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addItem(ItemSaveRequestDTO itemSaveRequestDTO) throws Exception {
        Item item= itemMapper.RequestDtoToEntity(itemSaveRequestDTO);
       // Item item=modelMapper.map(itemSaveRequestDTO,Item.class);
                item.setActiveState(true);

        if(!itemRepo.existsById(item.getItemId())){
           return  itemRepo.save(item).getItemName();
        }else{
            throw new Exception("Already in database");
           // throw new EntryDuplicateException("Already in database");
        }

    }

    @Override
    public List<ItemDTO> getAllCustomers() {
        List<Item> getItem = itemRepo.findAll();

        List<ItemDTO> itemDTOS = modelMapper.
                map(getItem, new TypeToken<List<ItemDTO>>() {
                }.getType());

        return itemDTOS;
    }

    @Override
    public List<ItemDTO> getAllCustomersByStateType(boolean status) {

        List<Item> getItem = itemRepo.findAllByActiveStateEquals(status);

        List<ItemDTO> itemDTOS = modelMapper.
                map(getItem, new TypeToken<List<ItemDTO>>() {
                }.getType());

        return itemDTOS;
    }
}
