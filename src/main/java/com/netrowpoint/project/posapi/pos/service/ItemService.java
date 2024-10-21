package com.netrowpoint.project.posapi.pos.service;

import com.netrowpoint.project.posapi.pos.dto.paginated.PaginatedResponseDTO;
import com.netrowpoint.project.posapi.pos.dto.request.SaveItemDTO;
import com.netrowpoint.project.posapi.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    public String saveItem(SaveItemDTO saveItemDTO);

    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    public List<ItemGetResponseDTO> getAllItemAndStatus();

    public PaginatedResponseDTO getAllItems(int page,int size);
}
