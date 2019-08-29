package com.daca.listapramim.api.item;

import com.daca.listapramim.api.item.Categoria;
import com.daca.listapramim.api.item.Item;
import com.daca.listapramim.api.item.ItemRepository;
import com.daca.listapramim.api.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;

@Service
public class ItemService extends GenericService<Long, Item, ItemRepository> {

	@Autowired
	private ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> index(){
		return this.itemRepository.findAll();
	}

	public List<Item> indexByOrderName(){
	    return this.itemRepository.findAllByOrderByNome();
    }

    public List<Item> indexByOrderCategory(String categoria){
		Categoria cat = Categoria.fromName(categoria);
		Sort sort = new Sort(Sort.Direction.ASC, "nome");
		List<Item> itens = this.itemRepository.findAllByCategoria(cat, sort);
	    return itens;
    }

    public List<Item> indexByNomeAndCategoria(String nome, String categoria){
		Categoria cat = Categoria.fromName(categoria);
		return this.itemRepository.findAllByNomeAndAndCategoria(nome, cat);
	}

    public List<Item> indexFilterByName(String nome){
		return this.itemRepository.findAllByNomeContainingIgnoreCase(nome);
	}

	public void create(Item item) {
		try {
			this.itemRepository.save(item);
		}catch (ConstraintViolationException e){
			throw new RuntimeException("Item já existente"+ e.getMessage());
		}
	}

	@ReadOnlyProperty
	public Item show(Long id){
		if(!this.itemRepository.existsById(id)){
			throw new RuntimeException("ID não relacionado a nenhum item");
		}
		try{
			Item item = this.itemRepository.findById(id).orElseThrow(RuntimeException::new);
			return item;
		}catch (IllegalArgumentException iae){
			throw new RuntimeException("");
		}
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
