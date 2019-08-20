package com.daca.listapramim.api.precos.DTO;

import com.daca.listapramim.api.item.service.ItemService;
import com.daca.listapramim.api.precos.model.MapaDePreco;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component("precoIO")
public class PrecoIO {

    private ModelMapper modelMapper;
    private ItemService itemService;

    @Autowired
    public PrecoIO(ItemService itemService) {
        this.modelMapper = new ModelMapper();
        this.modelMapper.addConverter(precoInputConverter);
        this.modelMapper.addConverter(precoOutputConverter);
        this.itemService = itemService;
    }

    final Converter<PrecoInput, MapaDePreco> precoInputConverter = new Converter<PrecoInput, MapaDePreco>() {
        @Override
        public MapaDePreco convert(MappingContext<PrecoInput, MapaDePreco> context) {
            PrecoInput precoInput = context.getSource();
            MapaDePreco preco = new MapaDePreco();

            preco.setItem(itemService.show(precoInput.getItemId()));
            preco.setLocal(precoInput.getLocal());
            preco.setPreco(precoInput.getPreco());
            return preco;
        }
    };

    final Converter<MapaDePreco, PrecoOutput> precoOutputConverter = new Converter<MapaDePreco, PrecoOutput>() {
        @Override
        public PrecoOutput convert(MappingContext<MapaDePreco, PrecoOutput> context) {
            MapaDePreco preco = context.getSource();

            PrecoOutput precoOutput = new PrecoOutput();

            precoOutput.setLocal(preco.getLocal());
            precoOutput.setItemId(preco.getItem().getId());
            precoOutput.setPreco(preco.getPreco());
            return precoOutput;
        }
    };

    public MapaDePreco mapTo(PrecoInput precoInput){
        return this.modelMapper.map(precoInput, MapaDePreco.class);
    }

    public PrecoOutput mapTo(MapaDePreco preco){
        return this.modelMapper.map(preco, PrecoOutput.class);
    }

    public List<PrecoOutput> toList(List<MapaDePreco> precos, Type type){
        return this.modelMapper.map(precos, type);
    }
}
