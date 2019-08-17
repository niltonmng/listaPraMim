package com.daca.listapramim.api.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daca.listapramim.api.item.model.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

}
