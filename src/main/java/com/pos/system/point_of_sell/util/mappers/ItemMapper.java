package com.pos.system.point_of_sell.util.mappers;


import com.pos.system.point_of_sell.dto.request.ItemSaveRequestDTO;
import com.pos.system.point_of_sell.entity.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item RequestDtoToEntity(ItemSaveRequestDTO itemSaveRequestDTO);
}
