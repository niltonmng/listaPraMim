package com.daca.listapramim.api.item.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class ProdutoUnidade extends Item {

	public ProdutoUnidade(String nome, Categoria categoria) {
		super(nome, categoria);
	}
}
