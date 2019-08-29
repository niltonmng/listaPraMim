package com.daca.listapramim.api.item;

import com.daca.listapramim.api.item.Categoria;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daca.listapramim.api.item.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

    List<Item> findAllByOrderByNome();

    List<Item> findAllByCategoria(Categoria categoria, Sort sort);

    List<Item> findAllByNomeContainingIgnoreCase(String nome);
    List<Item> findAllByNomeAndAndCategoria(String nome, Categoria categoria);
}
