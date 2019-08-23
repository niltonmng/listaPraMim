package com.daca.listapramim.api.listaDeCompras.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "estrategiaInput")
public class  EstrategiaInput {

    @ApiModelProperty(example = "1", required = true)
    private Long estrategiaId;

    @ApiModelProperty(example = "Supermercado BaratoD+", required = true)
    private String descricao;

    @ApiModelProperty(example = "1")
    private Long itemId;

    public EstrategiaInput() {
    }

    public Long getEstrategiaId() {
        return estrategiaId;
    }

    public void setEstrategiaId(Long estrategiaId) {
        this.estrategiaId = estrategiaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
