package com.daca.listapramim.api.precos.model;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.utils.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_preco")
public class MapaDePreco implements Serializable, Model<Long> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "local")
    private String local;

    @NotNull
    @Column(name = "preco")
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;


    public MapaDePreco(@NotEmpty String local, @NotEmpty BigDecimal preco) {
        this.local = local;
        this.preco = preco;
    }

    public MapaDePreco() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long aLong) {
         this.id = aLong;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
