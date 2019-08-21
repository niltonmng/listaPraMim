package com.daca.listapramim.api.item.repository;

import com.daca.listapramim.api.item.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daca.listapramim.api.item.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findAllByOrderByNome();

    List<Item> findAllByCategoria(Categoria categoria, Sort sort);

    List<Item> findAllByNomeContainingIgnoreCase(String nome);
}
