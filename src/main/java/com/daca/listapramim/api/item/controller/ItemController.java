package com.daca.listapramim.api.item.controller;

import com.daca.listapramim.api.item.DTO.ItemIO;
import com.daca.listapramim.api.item.DTO.ItemInput;
import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/item")
@Api(tags = "Item")
@CrossOrigin
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class.getSimpleName());

    private ItemIO itemIO;
    private ItemService itemService;

    @Autowired
    public ItemController(ItemIO itemIO, ItemService itemService) {
        this.itemIO = itemIO;
        this.itemService = itemService;
    }

    @PostMapping({"/",""})
    @ApiOperation(value = "Create Item")
    public ResponseEntity create(@Valid @RequestBody ItemInput itemInput){
        LOGGER.info("Criando Item");
        Item item = this.itemIO.mapTo(itemInput);
        this.itemService.create(item);
        LOGGER.info("Item criado");
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @ApiOperation(value =  "Get a Item")
    @GetMapping({"/{id}/", "/{id}"})
    public ItemOutput show(@PathVariable("id") Long id){
        LOGGER.info("Show item by id " +id);
        return this.itemIO.mapTo(this.itemService.show(id));
    }
    
    
}
