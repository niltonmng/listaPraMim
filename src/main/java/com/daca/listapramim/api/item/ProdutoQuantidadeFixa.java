package com.daca.listapramim.api.item;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ProdutoQuantidadeFixa extends Item {

	public ProdutoQuantidadeFixa(String nome, Categoria categoria) {
		super(nome, categoria);
	}

	public ProdutoQuantidadeFixa(){}

	@Override
	public String toString() {
		return "Quantidade fixa";
	}
}
