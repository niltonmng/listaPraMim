package factory;

import produtos.*;

public class FactoryItens {
	
	public FactoryItens() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemCompravel criaItem(String nome, String categoria, String tipo) {
		if (tipo.equals("produto nao industrializado")) return this.criaProdutoNaoIndustrializado(nome, categoria);
		if (tipo.equals("produto quantidade fixa")) return this.criaProdutoQuantidadeFixa(nome, categoria);
		else return this.criaProdutoUnidade(nome, categoria);
	}
	
	private ItemCompravel criaProdutoNaoIndustrializado(String nome, String categoria) {
		return new ProdutoNaoIndustrializado(nome, categoria);
	}
	
	private ItemCompravel criaProdutoQuantidadeFixa(String nome, String categoria) {
		return new ProdutoQuantidadeFixa(nome, categoria);
	}
	
	private ItemCompravel criaProdutoUnidade(String nome, String categoria) {
		return new ProdutoUnidade(nome, categoria);
	}

}
