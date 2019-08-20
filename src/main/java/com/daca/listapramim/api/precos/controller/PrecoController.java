package com.daca.listapramim.api.precos.controller;

import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.precos.DTO.PrecoIO;
import com.daca.listapramim.api.precos.DTO.PrecoInput;
import com.daca.listapramim.api.precos.DTO.PrecoOutput;
import com.daca.listapramim.api.precos.model.MapaDePreco;
import com.daca.listapramim.api.precos.service.PrecoService;
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
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/item/{itemId}/preco")
@Api(tags = "Preco")
@CrossOrigin
public class PrecoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrecoController.class.getSimpleName());

    private PrecoIO precoIO;
    private PrecoService precoService;

    @Autowired
    public PrecoController( PrecoIO precoIO, PrecoService precoService) {
        this.precoIO = precoIO;
        this.precoService = precoService;
    }

    @PostMapping({"/",""})
    @ApiOperation(value = "Create Preco")
    public ResponseEntity create(@Valid @RequestBody PrecoInput itemInput){
        LOGGER.info("Criando Preco");
        MapaDePreco item = this.precoIO.mapTo(itemInput);
        this.precoService.create(item);
        LOGGER.info("Preco criado");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value =  "Get all Precos")
    @GetMapping({"/{id}/", "/{id}"})
    public List<PrecoOutput> index(@PathVariable("id") Long id){
        LOGGER.info("Index Preco");
        Type type = new TypeToken<List<PrecoOutput>>() {}.getType();
        return this.precoIO.toList(this.precoService.getByItemId(id), type);
    }
}
