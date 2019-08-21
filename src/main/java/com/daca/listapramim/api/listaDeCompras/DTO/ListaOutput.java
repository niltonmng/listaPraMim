package com.daca.listapramim.api.listaDeCompras.DTO;

import com.daca.listapramim.api.item.DTO.ItemOutput;
import com.daca.listapramim.api.utils.AuditModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "listaOutput")
public class ListaOutput extends AuditModel {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "feira 23/05/2017")
    private String descricao;

    private List<ItemOutput> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ItemOutput> getItens() {
        return itens;
    }

    public void setItens(List<ItemOutput> itens) {
        this.itens = itens;
    }
}
