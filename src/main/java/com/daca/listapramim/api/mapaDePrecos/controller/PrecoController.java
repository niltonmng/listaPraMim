package com.daca.listapramim.api.mapaDePrecos.controller;


import com.daca.listapramim.api.mapaDePrecos.DTO.PrecoIO;
import com.daca.listapramim.api.mapaDePrecos.DTO.PrecoInput;
import com.daca.listapramim.api.mapaDePrecos.model.MapaDePreco;
import com.daca.listapramim.api.mapaDePrecos.service.PrecoService;
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
@RequestMapping("/api/item/{ItemId}/preco")
@Api(tags = "Preco")
@CrossOrigin
public abstract class PrecoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrecoController.class.getSimpleName());


    private PrecoIO precoIO;
    private PrecoService precoService;

    @Autowired
    public PrecoController(PrecoIO precoIO, PrecoService precoService) {
        this.precoIO = precoIO;
        this.precoService = precoService;
    }

    @PostMapping({"/",""})
    @ApiOperation(value = "Create preco")
    public ResponseEntity create(@Valid @RequestBody PrecoInput precoInput){
        LOGGER.info("Criando Preco");
        MapaDePreco preco = this.precoIO.mapTo(precoInput);
        this.precoService.create(preco);
        LOGGER.info("Preco criado");
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
