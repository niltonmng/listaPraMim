package com.daca.listapramim.api.compra.DTO;

import com.daca.listapramim.api.compra.model.Compra;
import com.daca.listapramim.api.item.service.ItemService;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import com.daca.listapramim.api.listaDeCompras.service.ListaService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("compraIO")
public class CompraIO {

    private ModelMapper modelMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaService listaService;

    public CompraIO(){
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(compraInputConverter);
        this.modelMapper.addConverter(compraOutputConverter);
    }

    final Converter<CompraInput, Compra> compraInputConverter = new Converter<CompraInput, Compra>() {
        @Override
        public Compra convert(MappingContext<CompraInput, Compra> context) {
            CompraInput input = context.getSource();
            Compra compra = new Compra();
            compra.setListaDeCompra(listaService.show(input.getListaId()));
            compra.setQtd(input.getQtd());
            compra.setItem(itemService.show(input.getItemId()));

            return compra;
        }
    };

    final Converter<Compra, CompraOutput> compraOutputConverter = new Converter<Compra, CompraOutput>() {
        @Override
        public CompraOutput convert(MappingContext<Compra, CompraOutput> context) {
            Compra compra = context.getSource();
            CompraOutput output = new CompraOutput();

            output.setItemId(compra.getItem().getId());
            output.setListaId(compra.getListaDeCompra().getId());
            output.setQtd(compra.getQtd());

            return output;
        }
    };

    public Compra mapTo(CompraInput input){
        return this.modelMapper.map(input, Compra.class);
    }

    public CompraOutput mapTo(Compra compra){
        return this.modelMapper.map(compra, CompraOutput.class);
    }

    public List<CompraOutput> toList(List<Compra> compras, Type type){
        return this.modelMapper.map(compras, type);
    }

}
