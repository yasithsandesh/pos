package com.netrowpoint.project.posapi.pos.util.mappers;

import com.netrowpoint.project.posapi.pos.dto.request.SaveItemDTO;
import com.netrowpoint.project.posapi.pos.dto.response.ItemGetResponseDTO;
import com.netrowpoint.project.posapi.pos.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

  List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);

   Item saveItemDtoToItemDto(SaveItemDTO saveItemDTO);

   List<ItemGetResponseDTO> pageToListResponseDto(Page<Item> items);

}
