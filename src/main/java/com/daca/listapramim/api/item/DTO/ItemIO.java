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

import java.lang.reflect.Type;
import java.util.List;

@Component("itemIO")
public class ItemIO {

	private ModelMapper modelMapper;

	final Converter<ProdutoUnidade, ItemOutput> itemOutputConverter = new Converter<ProdutoUnidade, ItemOutput>() {

		@Override
		public ItemOutput convert(MappingContext<ProdutoUnidade, ItemOutput> context){
			Item item = context.getSource();

			return toItemOutput(item);
		}
	};

    final Converter<ProdutoQuantidadeFixa, ItemOutput> itemOutputConverter2 = new Converter<ProdutoQuantidadeFixa, ItemOutput>() {

        @Override
        public ItemOutput convert(MappingContext<ProdutoQuantidadeFixa, ItemOutput> context){
            Item item = context.getSource();

            return toItemOutput(item);
        }
    };

    final Converter<ProdutoNaoIndustrializado, ItemOutput> itemOutputConverter3 = new Converter<ProdutoNaoIndustrializado, ItemOutput>() {

        @Override
        public ItemOutput convert(MappingContext<ProdutoNaoIndustrializado, ItemOutput> context){
            Item item = context.getSource();

            return toItemOutput(item);
        }
    };


	final Converter<ItemInput, Item> itemInputConverter = new Converter<ItemInput, Item>() {

		@Override
		public Item convert(MappingContext<ItemInput, Item> context) {

			ItemInput input = context.getSource();

			Item item = null;
			if (input.getTipo().equalsIgnoreCase("unidade")) {
				item = new ProdutoUnidade(input.getNome(), Categoria.fromName(input.getCategoria()));
			} else if (input.getTipo().equalsIgnoreCase("nao-industrializado")) {
				item = new ProdutoNaoIndustrializado(input.getNome(), Categoria.fromName(input.getCategoria()));
			} else if (input.getTipo().equalsIgnoreCase("quantidade-fixa")) {
				item = new ProdutoQuantidadeFixa(input.getNome(), Categoria.fromName(input.getCategoria()));
			} else if (item == null) {
				throw new MappingException("Erro ao converter item, verifique o tipo");
			}

			return item;
		}

	};

	public ItemIO() {
		this.modelMapper = new ModelMapper();
		this.modelMapper.addConverter(itemInputConverter);
		this.modelMapper.addConverter(itemOutputConverter);
        this.modelMapper.addConverter(itemOutputConverter2);
        this.modelMapper.addConverter(itemOutputConverter3);
	}

	private ItemOutput toItemOutput(Item item){
		ItemOutput itemOutput = new ItemOutput();
		itemOutput.setCategoria(item.getCategoria().getName());
		itemOutput.setId(item.getId());
		itemOutput.setNome(item.getNome());
		itemOutput.setTipo(item.toString());
		return itemOutput;
	}
	public Item mapTo(ItemInput itemInput){
		return this.modelMapper.map(itemInput, Item.class);
	}

	public ItemOutput mapTo(Item item){
		return modelMapper.map(item, ItemOutput.class);
	}

	public List<ItemOutput> toList(List<Item> itens, Type type){
		return this.modelMapper.map(itens, type);
	}


}
