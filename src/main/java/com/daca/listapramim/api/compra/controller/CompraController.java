package com.daca.listapramim.api.compra.controller;

import com.daca.listapramim.api.compra.DTO.CompraIO;
import com.daca.listapramim.api.compra.DTO.CompraInput;
import com.daca.listapramim.api.compra.DTO.CompraOutput;
import com.daca.listapramim.api.compra.model.Compra;
import com.daca.listapramim.api.compra.service.CompraService;
import com.daca.listapramim.api.item.service.ItemService;
import com.daca.listapramim.api.listaDeCompras.service.ListaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/compra")
@Api(tags = "Compra")
@CrossOrigin
public class CompraController {

    @Autowired
    private CompraIO compraIO;

    @Autowired
    private CompraService compraService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaService listaService;

    @ApiOperation(value = "Create Compra")
    @PostMapping({"/",""})
    public void create(@Valid @RequestBody CompraInput compraInput){
            this.listaService.show(compraInput.getListaId());
            Compra compra = this.compraIO.mapTo(compraInput);
            this.compraService.create(compra);
    }

    @ApiOperation(value = "Show A Compra")
    @GetMapping({"/{id}/","/{id}"})
    public CompraOutput show(@Min(value = 1) @PathVariable("id") Long id){
        Compra compra = this.compraService.show(id);
        return this.compraIO.mapTo(compra);
    }

    public ResponseEntity delete(@Min(value = 1) @PathVariable("id") Long id){
        this.compraService.delete(id);
        return ResponseEntity.ok().build();
    }
}
