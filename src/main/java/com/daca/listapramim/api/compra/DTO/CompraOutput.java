package com.daca.listapramim.api.compra.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "compraOutput")
public class CompraOutput {

    @ApiModelProperty(example = "1")
    public Long itemId;

    @ApiModelProperty(example = "1")
    public Long listaId;

    @ApiModelProperty(example = "11")
    public Double qtd;

    public CompraOutput() {
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
