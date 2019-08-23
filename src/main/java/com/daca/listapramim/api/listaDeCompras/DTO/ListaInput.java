package com.daca.listapramim.api.listaDeCompras.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@ApiModel(value = "listaInput")
public class ListaInput {

    @ApiModelProperty(example = "feira 23/05/2017", required = true)
    @NotEmpty
    private String descricao;

    public ListaInput() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
