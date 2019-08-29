package com.daca.listapramim.api.listaDeCompras;


import com.daca.listapramim.api.listaDeCompras.ListaDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaRepository extends JpaRepository<ListaDeCompra, Long> {

    List<ListaDeCompra> findAllByDescricaoContainingIgnoreCase(String descricao);
    List<ListaDeCompra> findAllByDescricao(String descricao);

    @Query(value = "SELECT *FROM tb_lista WHERE id = (SELECT MAX( id ) FROM tb_lista)", nativeQuery = true)
    ListaDeCompra ultimaLista();

}
