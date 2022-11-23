package com.pos.system.point_of_sell.controller;
import com.pos.system.point_of_sell.dto.CustomerDTO;
import com.pos.system.point_of_sell.dto.ItemDTO;
import com.pos.system.point_of_sell.dto.request.ItemSaveRequestDTO;
import com.pos.system.point_of_sell.service.ItemService;
import com.pos.system.point_of_sell.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemSaveRequestDTO itemSaveRequestDTO) throws Exception {
        String id = itemService.addItem(itemSaveRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id+"Item Successfully save",id),
                HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-all-items")
    public ResponseEntity<StandardResponse> getAllItems() {

        List<ItemDTO> allItems = itemService.getAllCustomers();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully",allItems),
                HttpStatus.OK
        );
    }

    @GetMapping(path = {"/get-all-items-by-state"},
    params = {"state"})
    public ResponseEntity<StandardResponse> getAllItemByActiveState(@RequestParam(value = "state") String sate) {
        if(sate.equalsIgnoreCase("active")|sate.equalsIgnoreCase("inactive")){
//            boolean status=false;
//            if(sate.equalsIgnoreCase("active")){
//                status=true;
//            }
            boolean status=sate.equalsIgnoreCase("active")?true:false; //if condition use in one line
            List<ItemDTO> allItems = itemService.getAllCustomersByStateType(status);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"Successfully",allItems),
                    HttpStatus.OK
            );

        }else{
            List<ItemDTO> allItems = itemService.getAllCustomers();
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(200,"Successfully",allItems),
                    HttpStatus.OK
            );

        }
    }
}
