package com.daca.listapramim.api.item.controller;

import com.daca.listapramim.api.item.DTO.ItemIO;
import com.daca.listapramim.api.item.DTO.ItemInput;
import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.item.model.Categoria;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.model.ProdutoUnidade;
import com.daca.listapramim.api.item.service.ItemService;
import com.daca.listapramim.api.precos.DTO.PrecoIO;
import com.daca.listapramim.api.precos.DTO.PrecoOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class ItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class.getSimpleName());

    private ItemIO itemIO;
    private PrecoIO precoIO;
    private ItemService itemService;

    @Autowired
    public ItemController(ItemIO itemIO, ItemService itemService, PrecoIO precoIO) {
        this.itemIO = itemIO;
        this.itemService = itemService;
        this.precoIO = precoIO;
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
        Item item = this.itemService.show(id);
        ItemOutput output =this.itemIO.mapTo(item);
        return output;
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


    //Endpoints da ordenação

    @ApiOperation(value = "Get Order items by name")
    @GetMapping({"/order/name/","/order/name"})
    public List<ItemOutput> indexOrderByName(){
        LOGGER.info("Index Order Itens");
        Type type = new TypeToken<List<ItemOutput>>() {}.getType();
        return this.itemIO.toList(this.itemService.indexByOrderName(), type);
    }

    @ApiOperation(value = "Get Order items by category")
    @GetMapping({"/order/categoria/{categoria}/","/order/categoria/{categoria}"})
    public List<ItemOutput> indexOrderByCategoria(@PathVariable("categoria") String categoria){
        LOGGER.info("Index Order Itens");
        Type type = new TypeToken<List<ItemOutput>>() {}.getType();
        return this.itemIO.toList(this.itemService.indexByOrderCategory(categoria), type);
    }

    @ApiOperation(value="Get filter Items by name")
    @GetMapping({"/order/filter/{nome}/","/order/filter/{nome}"})
    public List<ItemOutput> indexFilterItemsByName(@PathVariable("nome") String nome){
        LOGGER.info("Index Filtered items by name");
        Type type = new TypeToken<List<ItemOutput>>() {}.getType();
        return this.itemIO.toList(this.itemService.indexFilterByName(nome), type);
    }


}