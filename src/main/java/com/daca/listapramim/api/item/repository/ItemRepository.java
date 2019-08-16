package com.daca.listapramim.api.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daca.listapramim.api.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
