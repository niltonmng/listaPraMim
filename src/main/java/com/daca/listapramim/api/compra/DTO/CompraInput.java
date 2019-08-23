package com.daca.listapramim.api.compra.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "compraInput")
public class CompraInput {

    @ApiModelProperty(example = "1")
    private Long itemId;

    @ApiModelProperty(example = "1")
    private Long listaId;

    @ApiModelProperty(example = "11")
    private Double qtd;

    public CompraInput() {
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getListaId() {
        return listaId;
    }

    public void setListaId(Long listaId) {
        this.listaId = listaId;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }
}
