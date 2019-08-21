package com.daca.listapramim.api.precos.service;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.repository.ItemRepository;
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

    public MapaDePreco show(Long id){
        if(!this.precoRepository.existsById(id)){
            throw new RuntimeException("Id não associado a nenhum preco");
        }else{
            try {
                MapaDePreco preco = this.precoRepository.findById(id).orElseThrow(RuntimeException:: new);
                return preco;
            }catch (RuntimeException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }


    public MapaDePreco update(Long id, MapaDePreco preco){
        if(!this.precoRepository.existsById(id)){
            throw new RuntimeException("Id não associado a nenhum preco");
        }else{
            preco.setId(id);
            return this.precoRepository.save(preco);
        }
    }

    public void delete(Long id){
        if(!this.precoRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhum preco");
        }
        this.precoRepository.deleteById(id);
    }
}
