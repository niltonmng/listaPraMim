package com.daca.listapramim.api.item.service;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.item.repository.ItemRepository;
import com.daca.listapramim.api.utils.GenericService;

public class ItemService extends GenericService<Long, Item, ItemRepository> {
		
	private ItemRepository itemRepository;
	
	public ItemService(
			ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
