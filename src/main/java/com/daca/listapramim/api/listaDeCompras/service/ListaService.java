package com.daca.listapramim.api.listaDeCompras.service;

import com.daca.listapramim.api.compra.model.Compra;
import com.daca.listapramim.api.compra.service.CompraService;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.repository.ItemRepository;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import com.daca.listapramim.api.listaDeCompras.repository.ListaRepository;
import com.daca.listapramim.api.precos.model.MapaDePreco;
import com.daca.listapramim.api.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListaService extends GenericService<Long, ListaDeCompra, ListaRepository> {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private CompraService compraService;

    public List<ListaDeCompra> index(){
        return this.listaRepository.findAll();
    }

    public void create(ListaDeCompra listaDeCompra) {
        try {
            this.listaRepository.save(listaDeCompra);
        }catch (ConstraintViolationException e){
            throw new RuntimeException("Lista já existente"+ e.getMessage());
        }
    }


    @ReadOnlyProperty
    public ListaDeCompra show(Long id){
        if(!this.listaRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma lista");
        }
        try{
            ListaDeCompra lista = this.listaRepository.findById(id).orElseThrow(RuntimeException::new);
            return lista;
        }catch (IllegalArgumentException iae){
            throw new RuntimeException("");
        }
    }

    public ListaDeCompra update(Long id, ListaDeCompra lista){
        if(!this.listaRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma lista");
        }
        lista.setId(id);
        return this.listaRepository.save(lista);
    }

    public void delete(Long id){
        if(!this.listaRepository.existsById(id)){
            throw new RuntimeException("ID não relacionado a nenhuma lista");
        }
        this.listaRepository.deleteById(id);
    }

    //Pesquisas da lista de compras
    public List<ListaDeCompra> indexFilterByDescricao(String descricao){
        return this.listaRepository.findAllByDescricaoContainingIgnoreCase(descricao);
    }

    public List<Item> getAllItemsByLista(ListaDeCompra lista){
        List<Item> itens = new ArrayList<Item>();
        for (Compra compra: lista.getCompras()) {
            itens.add(compra.getItem());
        }

        return itens;
    }

    public ListaDeCompra getByDescricao(String descricao){
        return this.listaRepository.findByDescricao(descricao);
    }



    public void estrategia(Long estrategia, ListaDeCompra lista, Long itemId){
        ListaDeCompra oldLista = null;
        if(estrategia == 1){
            oldLista = this.listaRepository.ultimaLista();
        }else if(estrategia == 2){
            List<Compra> compras = this.compraService.getByItemId(itemId);
            oldLista = compras.get(compras.size()-1).getListaDeCompra();
        }

        List<Compra> compras = new ArrayList<Compra>();
        for (Compra compra: oldLista.getCompras()) {
            compras.add(new Compra(compra.getItem(), lista, compra.getQtd()));
        }
        lista.setCompras(compras);
        this.create(lista);
    }


    public List<Compra> getItemByLocal(List<Compra> compras, String local){
        List<Compra> comprasSaida = new ArrayList<>();
        for (Compra compra: compras) {
            for (MapaDePreco preco: compra.getItem().getPrecos()) {
                if(preco.getLocal().equalsIgnoreCase(local)){
                    comprasSaida.add(compra);
                }
            }
        }
        return comprasSaida;
    }

}
