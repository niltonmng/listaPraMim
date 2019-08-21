package com.daca.listapramim.api.listaDeCompras.repository;


import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<ListaDeCompra, Long> {

}
