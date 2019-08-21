package com.daca.listapramim.api.listaDeCompras.controller;

import com.daca.listapramim.api.item.DTO.ItemIO;
import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.service.ItemService;
import com.daca.listapramim.api.listaDeCompras.DTO.ListaIO;
import com.daca.listapramim.api.listaDeCompras.DTO.ListaInput;
import com.daca.listapramim.api.listaDeCompras.DTO.ListaOutput;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import com.daca.listapramim.api.listaDeCompras.service.ListaService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lista")
@Api(tags = "Lista de Compra")
@CrossOrigin
public class ListaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListaController.class.getSimpleName());

    @Autowired
    private ListaIO listaIO;
    @Autowired
    private ListaService listaService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemIO itemIO;

    @PostMapping({"/",""})
    @ApiOperation(value = "Create Lista De Compras")
    public ResponseEntity create(@Valid @RequestBody ListaInput listaInput){
        LOGGER.info("Criando Lista de Compras");
        ListaDeCompra listaDeCompra = this.listaIO.mapTo(listaInput);
        List<Long> ids = listaInput.getItens();
        List<Item> itens = new ArrayList<Item>();
        for (Long id: ids) {
            itens.add(this.itemService.show(id));
        }
        listaDeCompra.setItens(itens);
        listaDeCompra.setCreatedAt(LocalDateTime.now());
        this.listaService.create(listaDeCompra);
        LOGGER.info("Lista de Compras criada");
        return ResponseEntity.ok().build();
    }

    @GetMapping({"/{id}/itens/","{id}/itens"})
    @ApiOperation(value = "Get Itens From Lista de Compras")
    public List<ItemOutput> getItensLista(@Min(value = 1) @PathVariable("id") Long id){
        ListaDeCompra lista = this.listaService.show(id);
        Type type = new TypeToken<List<ItemOutput>>() {}.getType();
        LOGGER.info("Get itens da lista de compras com id "+ id);
        return this.itemIO.toList(lista.getItens(), type);
    }

    @GetMapping({"/{id}/","/{id}"})
    @ApiOperation(value = "Get A Listas De Compras")
    public ListaOutput show(@Min(value = 1) @PathVariable("id") Long id){
        ListaDeCompra lista = this.listaService.show(id);
        LOGGER.info("Show Lista de compras com id "+ id);
        return this.listaIO.mapTo(lista);
    }

    @GetMapping({"/",""})
    @ApiOperation(value = "Get All Listas De Compras")
    public List<ListaOutput> index(){
        List<ListaDeCompra> listas = this.listaService.index();
        Type type = new TypeToken<List<ListaOutput>>() {}.getType();
        LOGGER.info("Index Lista de compras");
        return this.listaIO.toList(listas, type);
    }

    @ApiOperation(value = "Update Lista De Compras")
    @PutMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> update(@Min(value = 1) @PathVariable("id") Long id,
                                    @Valid @RequestBody ListaInput listaInput){
        ListaDeCompra lista = this.listaIO.mapTo(listaInput);
        LOGGER.info("Atualizando Lista de compras");
        List<Long> ids = listaInput.getItens();
        List<Item> itens = new ArrayList<Item>();
        for (Long idItem: ids) {
            itens.add(this.itemService.show(idItem));
        }
        lista.setItens(itens);
        lista.setUpdatedAt(LocalDateTime.now());
        this.listaService.update(id, lista);
        LOGGER.info("Lista de compras com id "+id+" Atualizado");
        return ResponseEntity.noContent().build();
    }


    @ApiOperation(value = "Delete Lista De Compras")
    @DeleteMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        LOGGER.info("Excluindo lista de compras com id "+id);
        this.listaService.delete(id);
        LOGGER.info("Lista de compras com id "+id+" excluído");
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "add Item in Lista De Compras")
    @PutMapping({"/{id}/itens/{itemId}/","/{id}/itens/{itemId}"})
    public ResponseEntity<?> addItem(@Min(value = 1) @PathVariable("id") Long id,
                                     @Min(value = 1) @PathVariable("itemId") Long itemId){
        ListaDeCompra listaDeCompra = this.listaService.show(id);
        Item item = this.itemService.show(itemId);
        if(listaDeCompra.getItens().contains(item)){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        listaDeCompra.getItens().add(item);
        listaDeCompra.setUpdatedAt(LocalDateTime.now());
        this.listaService.update(id, listaDeCompra);
        LOGGER.info("Item com id "+id+" adicionado a Lista de compras com id "+id);
        return ResponseEntity.noContent().build();
    }


}
