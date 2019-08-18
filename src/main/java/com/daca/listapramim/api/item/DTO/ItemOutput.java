package com.daca.listapramim.api.item.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

@ApiModel(value = "itemOutput")
public class ItemOutput {

    @ApiModelProperty(example = "1")
    private Long id;

    @ApiModelProperty(example = "Queijo minas Dali")
    private String nome;

    @ApiModelProperty(example = "Alimentos industrializados")
    private String categoria;

    @ApiModelProperty(example = "unidade")
    private String tipo;

    public ItemOutput() {
    }

    public ItemOutput(Long id, String nome, String categoria, String tipo) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
