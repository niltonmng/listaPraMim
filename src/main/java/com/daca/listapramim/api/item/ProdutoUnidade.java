package com.daca.listapramim.api.item;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ProdutoUnidade extends Item {

	public ProdutoUnidade(String nome, Categoria categoria) {
		super(nome, categoria);
	}

	public ProdutoUnidade(){

	}

	@Override
	public String toString() {
		return "Unidade";
	}
}
