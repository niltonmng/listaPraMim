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
import javax.validation.constraints.Min;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("/api/preco")
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

    @ApiOperation(value =  "Get all Precos By Item")
    @GetMapping({"/item/{itemId}/", "/item/{itemId}"})
    public List<PrecoOutput> indexByItemId(@PathVariable("itemId") Long itemId){
        LOGGER.info("Index Preco");
        Type type = new TypeToken<List<PrecoOutput>>() {}.getType();
        return this.precoIO.toList(this.precoService.getByItemId(itemId), type);
    }

    @ApiOperation(value = "Get a Preco")
    @GetMapping({"/{id}/","/{id}"})
    public PrecoOutput show(@PathVariable("id") Long id){
        LOGGER.info("Show Preco");
        return this.precoIO.mapTo(this.precoService.show(id));
    }

    @ApiOperation(value = "Update Preco")
    @PutMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> update(@Min(value = 1) @PathVariable("id") Long id,
                                    @Valid @RequestBody PrecoInput precoInput){
        MapaDePreco preco = this.precoIO.mapTo(precoInput);
        LOGGER.info("Atualizando preco");
        this.precoService.update(id, preco);
        LOGGER.info("Preco com id "+id+" Atualizado");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Delete Preco")
    @DeleteMapping({"/{id}/","/{id}"})
    public ResponseEntity<?> delete(@Min(value = 1) @PathVariable("id") Long id){
        LOGGER.info("Deletando preco");
        this.precoService.delete(id);
        LOGGER.info("Preco com id "+id+" Deletado");
        return ResponseEntity.status(HttpStatus.OK).build();
    }





}
