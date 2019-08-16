package com.daca.listapramim.api.item.DTO;

import org.hibernate.MappingException;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import com.daca.listapramim.api.item.model.Categoria;
import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.model.ProdutoNaoIndustrializado;
import com.daca.listapramim.api.item.model.ProdutoQuantidadeFixa;
import com.daca.listapramim.api.item.model.ProdutoUnidade;

@Component("itemIO")
public class ItemIO {
	
	private ModelMapper modelMapper;

	final Converter<ItemInput, Item> itemInputConverter = new Converter<ItemInput, Item>() {
		
		public Item convert(MappingContext<ItemInput, Item> context) {
			
			ItemInput input = context.getSource();
			
			Item item = null;
			if(input.getTipo().equalsIgnoreCase("unidade")) {
				item = new ProdutoUnidade(input.getNome(), Categoria.fromName(input.getCategoria()));
			}else if(input.getTipo().equalsIgnoreCase("nao-industrializado")) {
				item = new ProdutoNaoIndustrializado(input.getNome(), Categoria.fromName(input.getCategoria()));
			}else if(input.getTipo().equalsIgnoreCase("quantidade-fixa")) {
				item =  new ProdutoQuantidadeFixa(input.getNome(), Categoria.fromName(input.getCategoria()));
			}else if(item == null) {
				throw new MappingException("Erro ao converter item, verifique o tipo");
			}
			
			return item;
		}
	
	};
	
}
