package com.daca.listapramim.api.compra;

import com.daca.listapramim.api.compra.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> getAllByItem_Id(Long id);
}
