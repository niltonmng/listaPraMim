package com.daca.listapramim.api.listaDeCompras.DTO;

import com.daca.listapramim.api.item.DTO.ItemIO;
import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("listaIO")
public class ListaIO {


    private ModelMapper modelMapper;

    @Autowired
    private ItemIO itemIO;


    public ListaIO() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(listaInputListaConverter);
        this.modelMapper.addConverter(listaOutputConverter);
    }

    final Converter<ListaInput, ListaDeCompra> listaInputListaConverter = new Converter<ListaInput, ListaDeCompra>() {
        @Override
        public ListaDeCompra convert(MappingContext<ListaInput, ListaDeCompra> context) {

            ListaInput listaInput = context.getSource();
            ListaDeCompra listaDeCompra = new ListaDeCompra();
            listaDeCompra.setDescricao(listaInput.getDescricao());
            return listaDeCompra;
        }
    };

    final Converter<ListaDeCompra, ListaOutput> listaOutputConverter = new Converter<ListaDeCompra, ListaOutput>() {
        @Override
        public ListaOutput convert(MappingContext<ListaDeCompra, ListaOutput> context) {
            ListaDeCompra lista = context.getSource();
            ListaOutput output = new ListaOutput();

            output.setDescricao(lista.getDescricao());
            output.setId(lista.getId());
            Type type = new TypeToken<List<ItemOutput>>() {
            }.getType();
            output.setItens(itemIO.toList(lista.getItens(), type));
            output.setCreatedAt(lista.getCreatedAt());
            output.setUpdatedAt(lista.getUpdatedAt());
            return output;
        }
    };

    public ListaDeCompra mapTo(ListaInput listaInput) {
        return this.modelMapper.map(listaInput, ListaDeCompra.class);
    }

    public ListaOutput mapTo(ListaDeCompra listaDeCompra) {
        return this.modelMapper.map(listaDeCompra, ListaOutput.class);
    }

    public List<ListaOutput> toList(List<ListaDeCompra> lista, Type type) {
        return this.modelMapper.map(lista, type);
    }
}
