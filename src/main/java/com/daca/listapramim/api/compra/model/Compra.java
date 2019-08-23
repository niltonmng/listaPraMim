package com.daca.listapramim.api.compra.model;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.listaDeCompras.model.ListaDeCompra;
import com.daca.listapramim.api.utils.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_compra")
public class Compra implements Serializable, Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listadecompra_id")
    private ListaDeCompra listaDeCompra;

    @Column(name = "qtd")
    private Double qtd;

    public Compra() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public ListaDeCompra getListaDeCompra() {
        return listaDeCompra;
    }

    public void setListaDeCompra(ListaDeCompra listaDeCompra) {
        this.listaDeCompra = listaDeCompra;
    }
}
