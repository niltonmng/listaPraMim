package com.daca.listapramim.api.listaDeCompras.DTO;

import com.daca.listapramim.api.compra.DTO.CompraOutput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "carrinhoOutput")
public class CarrinhoOutput {

    @ApiModelProperty(example = "Baratão")
    private String local;

    @ApiModelProperty(example = "110.84")
    private double total;

    @ApiModelProperty(example = "[]")
    private List<CompraOutput> lista;

    public CarrinhoOutput() {
        this.total = 0.0;
        this.lista = new ArrayList<>();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<CompraOutput> getLista() {
        return lista;
    }

    public void setLista(List<CompraOutput> lista) {
        this.lista = lista;
    }
}
