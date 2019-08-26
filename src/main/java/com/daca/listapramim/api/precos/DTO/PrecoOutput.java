package com.daca.listapramim.api.precos.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@ApiModel(value = "precoOutput")
public class PrecoOutput {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Supermercado BaratoD+", required = true)
    @NotEmpty
    private String local;

    @ApiModelProperty(example = "2.33")
    @NotEmpty
    private Double preco;

    @ApiModelProperty(example = "1")
    @NotEmpty
    private Long itemId;


    public PrecoOutput() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
