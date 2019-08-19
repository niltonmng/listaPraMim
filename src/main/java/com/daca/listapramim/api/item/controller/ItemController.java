package com.daca.listapramim.api.item.controller;

import com.daca.listapramim.api.item.DTO.ItemIO;
import com.daca.listapramim.api.item.DTO.ItemInput;
import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.lang.reflect.Type;
import java.util.List;


@RestController
@RequestMapping("/api/item")
@Api(tags = "Item")
@CrossOrigin
public abstract class ItemController {

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
        return ResponseEntity.noContent().build();

    }

    @ApiOperation(value = "Get a Item")
    @GetMapping({"/{id}/", "/{id}"})
    public ItemOutput show(@PathVariable("id") Long id){
        LOGGER.info("Show item by id " +id);
        Item item = this.itemService.show(id);
        return this.itemIO.mapTo(item);
    }

    @ApiOperation(value =  "Get all Item")
    @GetMapping({"/", ""})
    public List<ItemOutput> index(){
        LOGGER.info("Index Itens");
        Type type = new TypeToken<List<ItemOutput>>() {}.getType();
        return this.itemIO.toList(this.itemService.index(), type);
    }

    @ApiOperation(value = "Update Item")
    @PutMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> update(@Min(value = 1) @PathVariable("id") Long id,
                                    @Valid @RequestBody ItemInput itemInput){
        Item item = this.itemIO.mapTo(itemInput);
        LOGGER.info("Atualizando item");
        this.itemService.update(id, item);
        LOGGER.info("Item com id "+id+" Atualizado");
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete Item")
    @DeleteMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        LOGGER.info("Excluindo Item com id "+id);
        this.itemService.delete(id);
        LOGGER.info("Item com id "+id+" excluído");
        return ResponseEntity.ok().build();
    }
    
    
}
