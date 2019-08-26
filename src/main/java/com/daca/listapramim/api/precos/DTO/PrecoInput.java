package com.daca.listapramim.api.precos.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@ApiModel(value = "precoInput")
public class PrecoInput {


    @ApiModelProperty(example = "Supermercado BaratoD+", required = true)
    @NotEmpty
    private String local;

    @ApiModelProperty(example = "2.33")
    @NotNull
    private Double preco;

    @ApiModelProperty(example = "1")
    @NotNull
    private Long itemId;

    public PrecoInput() {
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
