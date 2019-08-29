package com.daca.listapramim.api.precos;

import com.daca.listapramim.api.precos.MapaDePreco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapaDePrecoRepository extends JpaRepository<MapaDePreco,Long> {

    Page<MapaDePreco> findByItemId(Long itemId, Pageable pageable);
    Optional<MapaDePreco> findByIdAndItemId(Long id, Long ItemId);
    List<MapaDePreco> findByItemId(Long id);
}
