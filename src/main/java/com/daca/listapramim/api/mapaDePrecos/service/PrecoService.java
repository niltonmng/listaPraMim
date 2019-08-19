package com.daca.listapramim.api.mapaDePrecos.service;

import com.daca.listapramim.api.mapaDePrecos.model.MapaDePreco;
import com.daca.listapramim.api.mapaDePrecos.repository.MapaDePrecoRepository;
import com.daca.listapramim.api.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrecoService extends GenericService<Long, MapaDePreco, MapaDePrecoRepository> {

    @Autowired
    private MapaDePrecoRepository precoRepository;

    public void create(MapaDePreco preco) {
        try {
            this.precoRepository.save(preco);
        }catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
