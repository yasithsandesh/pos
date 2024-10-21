package com.netrowpoint.project.posapi.pos.dto.paginated;

import com.netrowpoint.project.posapi.pos.dto.response.ItemGetResponseDTO;

import java.util.List;

public class PaginatedResponseDTO {

  private   List<ItemGetResponseDTO> itemList;
  private int dataCount;

    public PaginatedResponseDTO() {
    }

    public PaginatedResponseDTO(List<ItemGetResponseDTO> itemList, int dataCount) {
        this.itemList = itemList;
        this.dataCount = dataCount;
    }

    public List<ItemGetResponseDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemGetResponseDTO> itemList) {
        this.itemList = itemList;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }
}
