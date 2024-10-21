package com.netrowpoint.project.posapi.pos.controller;


import com.netrowpoint.project.posapi.pos.dto.paginated.PaginatedResponseDTO;
import com.netrowpoint.project.posapi.pos.dto.request.SaveItemDTO;
import com.netrowpoint.project.posapi.pos.dto.response.ItemGetResponseDTO;
import com.netrowpoint.project.posapi.pos.service.ItemService;
import com.netrowpoint.project.posapi.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired(required = true)
    private ItemService itemService;


    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody SaveItemDTO saveItemDTO){
        itemService.saveItem(saveItemDTO);
        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<>(
                new StandardResponse(), HttpStatus.CREATED
        );
        return responseEntity;
    }

    @GetMapping(path = "/get-by-name",params = "name")
    public ResponseEntity<StandardResponse> getItemByNameAndStatus(@RequestParam(value = "name") String itemName){
        List<ItemGetResponseDTO> itemGetResponseDTOS = itemService.getItemByNameAndStatus(itemName);
        return new ResponseEntity<>(new StandardResponse(201,"sucess",itemGetResponseDTOS),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-items")
    public ResponseEntity<StandardResponse> getAllItems(){
     List<ItemGetResponseDTO> itemGetResponseDTOS =   itemService.getAllItemAndStatus();
     return new ResponseEntity<>(new StandardResponse(201,"sucess",itemGetResponseDTOS),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all-items",params = {"page","size"})
    public  ResponseEntity<StandardResponse> getAllItemsByPage(@RequestParam(value = "page")int page,@RequestParam(value = "size")int size){
        PaginatedResponseDTO paginatedResponseDTO = itemService.getAllItems(page,size);

        return  new ResponseEntity<>(new StandardResponse(201,"sucess",paginatedResponseDTO),HttpStatus.OK);
    }
}
