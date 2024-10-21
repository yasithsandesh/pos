package com.netrowpoint.project.posapi.pos.service.impl;

import com.netrowpoint.project.posapi.pos.dto.paginated.PaginatedResponseDTO;
import com.netrowpoint.project.posapi.pos.dto.request.SaveItemDTO;
import com.netrowpoint.project.posapi.pos.dto.response.ItemGetResponseDTO;
import com.netrowpoint.project.posapi.pos.entity.Item;
import com.netrowpoint.project.posapi.pos.repo.ItemRepo;
import com.netrowpoint.project.posapi.pos.service.ItemService;
import com.netrowpoint.project.posapi.pos.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;



    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String saveItem(SaveItemDTO saveItemDTO) {


//        Item item = new Item(
//                1,
//                saveItemDTO.getItemName(),
//                saveItemDTO.getMeasuringUnitType(),
//                saveItemDTO.getQty(),
//                saveItemDTO.getSupplierPrice(),
//                saveItemDTO.getSellingPrice(),
//                true
//
//        );
//
//        itemRepo.save(item);

//        Item item = itemMapper.saveItemDtoToItemDto(saveItemDTO);
//        itemRepo.save(item);

        Item item = modelMapper.map(saveItemDTO,Item.class);
        itemRepo.save(item);

        return null;
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        Boolean status = true;

        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStatusEquals(itemName,status);

        if(items.size()>0){

            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

            return itemGetResponseDTOS;

        }else {
            throw new RuntimeException("Item is not active");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getAllItemAndStatus() {

        List<Item> items = itemRepo.findAllByActiveStatusEquals(true);
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);

        return itemGetResponseDTOS;
    }

    @Override
    public PaginatedResponseDTO getAllItems(int page,int size) {
     Page<Item> items =  itemRepo.findAllByActiveStatusEquals(true,PageRequest.of(page,size));
     int count = itemRepo.countAllByActiveStatusEquals(true);

     if(items.getSize()<1){
         throw new RuntimeException("Item is not active");
     }

     PaginatedResponseDTO paginatedResponseDTO = new PaginatedResponseDTO(itemMapper.pageToListResponseDto(items),count);

     return paginatedResponseDTO;

    }

//    @Override
//    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
//
//        Boolean status = true;
//
//        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStatusEquals(itemName,status);
//
//        if(items.size()>0){
//
//            List<ItemGetResponseDTO> itemGetResponseDTOList = new ArrayList<>();
//            for(Item item : items){
//                ItemGetResponseDTO itemGetResponseDTO = new ItemGetResponseDTO(
//                        item.getItemId(),
//                        item.getItemName(),
//                        item.getMeasuringUnitType(),
//                        item.getQty(),
//                        item.getSupplierPrice(),
//                        item.getSellingPrice(),
//                        item.isActiveStatus()
//
//                );
//
//                itemGetResponseDTOList.add(itemGetResponseDTO);
//            }
//
//            return itemGetResponseDTOList;
//
//        }else {
//            throw new RuntimeException("Item is not active");
//        }
//
//
//    }
}
