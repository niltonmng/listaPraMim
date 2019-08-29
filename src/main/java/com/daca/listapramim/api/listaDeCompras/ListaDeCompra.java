package com.daca.listapramim.api.listaDeCompras;

import com.daca.listapramim.api.compra.Compra;
import com.daca.listapramim.api.utils.AuditModel;
import com.daca.listapramim.api.utils.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_lista",
        uniqueConstraints = @UniqueConstraint(columnNames={"descricao"}))
public class ListaDeCompra extends AuditModel implements Serializable, Model<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "listadecompra_id")
    private List<Compra> compras;

    public ListaDeCompra(Long id) {
        this.id = id;
    }

    public ListaDeCompra() {

    }

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

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}
