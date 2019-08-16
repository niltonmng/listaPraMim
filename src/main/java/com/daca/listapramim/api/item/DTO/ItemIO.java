package com.daca.listapramim.api.item.DTO;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.daca.listapramim.api.item.model.Item;

@Component("itemIO")
public class ItemIO {
	
	private ModelMapper modelMapper;

	final Converter<ItemInput, Item> itemInputConverter = new Converter<ItemInput, Item>() {
		
		public Item convert(MappingContext<ItemInput, Item> context) {
			ItemInput input = context.getSource();
			// TODO Fazer quando fizer as classes de subtipo
			return null;
		}
	
	};
	
}
