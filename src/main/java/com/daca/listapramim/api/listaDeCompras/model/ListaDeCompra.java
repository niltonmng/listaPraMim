package com.daca.listapramim.api.listaDeCompras.model;

import com.daca.listapramim.api.item.model.Item;
import com.daca.listapramim.api.utils.AuditModel;
import com.daca.listapramim.api.utils.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "tb_lista",
        uniqueConstraints = @UniqueConstraint(columnNames={"descricao"}))
public class ListaDeCompra extends AuditModel implements Model<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "lista_itens",
            joinColumns = @JoinColumn(name = "listadecompra_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> itens;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
