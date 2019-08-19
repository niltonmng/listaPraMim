package com.daca.listapramim.api.mapaDePrecos.DTO;

import com.daca.listapramim.api.item.model.Item;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@ApiModel(value = "precoInput")
public class PrecoInput {


    @ApiModelProperty(example = "Supermercado BaratoD+", required = true)
    @NotEmpty
    private String local;

    @ApiModelProperty(example = "2.33")
    @NotEmpty
    private BigDecimal preco;

    @ApiModelProperty(example = "1")
    @NotEmpty
    private Long itemId;

    public PrecoInput() {
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
