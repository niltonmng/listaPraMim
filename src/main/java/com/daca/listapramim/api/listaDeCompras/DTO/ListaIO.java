package com.daca.listapramim.api.listaDeCompras.DTO;

import com.daca.listapramim.api.compra.DTO.CompraIO;
import com.daca.listapramim.api.compra.DTO.CompraOutput;
import com.daca.listapramim.api.listaDeCompras.ListaDeCompra;
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
    private CompraIO compraIO;


    public ListaIO() {
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(listaInputListaConverter);
        this.modelMapper.addConverter(listaOutputConverter);
        this.modelMapper.addConverter(estrategiaListaConverter);
    }

    final Converter<EstrategiaInput, ListaDeCompra> estrategiaListaConverter = new Converter<EstrategiaInput, ListaDeCompra>() {
        @Override
        public ListaDeCompra convert(MappingContext<EstrategiaInput, ListaDeCompra> context) {

            EstrategiaInput estrategiaInput = context.getSource();
            ListaDeCompra listaDeCompra = new ListaDeCompra();
            listaDeCompra.setDescricao(estrategiaInput.getDescricao());
            return listaDeCompra;
        }
    };

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
            Type type = new TypeToken<List<CompraOutput>>() {}.getType();
            output.setCompras(compraIO.toList(lista.getCompras(), type));
            output.setCreatedAt(lista.getCreatedAt());
            output.setUpdatedAt(lista.getUpdatedAt());
            return output;
        }
    };

    public ListaDeCompra mapTo(ListaInput listaInput){
        return this.modelMapper.map(listaInput, ListaDeCompra.class);
    }

    public ListaOutput mapTo(ListaDeCompra listaDeCompra){
        return this.modelMapper.map(listaDeCompra, ListaOutput.class);
    }

    public ListaDeCompra mapTo(EstrategiaInput estrategiaInput){
        return this.modelMapper.map(estrategiaInput, ListaDeCompra.class);
    }


    public List<ListaOutput> toList(List<ListaDeCompra> lista, Type type){
        return this.modelMapper.map(lista, type);
    }


}
