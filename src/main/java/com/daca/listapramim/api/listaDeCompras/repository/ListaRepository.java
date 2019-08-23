package com.daca.listapramim.api.listaDeCompras.repository;


import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<ListaDeCompra, Long> {

    List<ListaDeCompra> findAllByDescricaoContainingIgnoreCase(String descricao);
    ListaDeCompra findByDescricao(String descricao);



}
