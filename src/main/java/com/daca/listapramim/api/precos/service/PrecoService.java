package com.daca.listapramim.api.precos.service;

import com.daca.listapramim.api.precos.model.MapaDePreco;
import com.daca.listapramim.api.precos.repository.MapaDePrecoRepository;
import com.daca.listapramim.api.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public List<MapaDePreco> getByItemId(Long id){
        return this.precoRepository.findByItemId(id);
    }
}
