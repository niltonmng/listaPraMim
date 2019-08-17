package com.daca.listapramim.api.item.service;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.repository.ItemRepository;
import com.daca.listapramim.api.utils.GenericService;
import javassist.NotFoundException;

import java.util.List;

public class ItemService extends GenericService<Long, Item, ItemRepository> {

	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> index(){
		return this.itemRepository.findAll();
	}

	public void create(Item item) {
		this.itemRepository.save(item);
	}

	public Item show(Long id){
		if(!this.itemRepository.existsById(id)){
			throw new RuntimeException("ID não relacionado a nenhum item");
		}
		return this.itemRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public Item update(Long id, Item item){
		if(!this.itemRepository.existsById(id)){
			throw new RuntimeException("ID não relacionado a nenhum item");
		}
		item.setId(id);
		return this.itemRepository.save(item);
	}

	public void delete(Long id){
		if(!this.itemRepository.existsById(id)){
			throw new RuntimeException("ID não relacionado a nenhum item");
		}
		this.itemRepository.deleteById(id);
	}
}
