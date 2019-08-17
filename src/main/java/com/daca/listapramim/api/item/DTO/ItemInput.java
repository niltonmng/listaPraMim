package com.daca.listapramim.api.item.DTO;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;

public class ItemInput {
	
	
	@ApiModelProperty(example = "Queijo minas Dali", required = true)
	@NotEmpty
	private String nome;

	@ApiModelProperty(example = "Alimentos industrializados", required = true)
	@NotEmpty
	private String categoria;
	
	@ApiModelProperty(example = "unidade", required = true)
	@NotEmpty
	private String tipo;
	
	public ItemInput() {
		
	}
	
	public ItemInput(String nome, String categoria, String tipo) {
		this.nome = nome;
		this.categoria = categoria;
		this.tipo = tipo;
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
