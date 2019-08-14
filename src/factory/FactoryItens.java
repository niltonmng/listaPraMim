package factory;

import produtos.*;

public class FactoryItens {
	
	private int contador;
	
	public FactoryItens() {
		this.contador = 0;
	}
	
	public ItemCompravel criaItem(String nome, String categoria, String tipo) {
		String input = this.trataTipo(tipo);
		if (input.equals("produto nao industrializado")) return this.criaProdutoNaoIndustrializado(nome, categoria);
		if (input.equals("produto quantidade fixa")) return this.criaProdutoQuantidadeFixa(nome, categoria);
		else return this.criaProdutoUnidade(nome, categoria);
	}
	
	public String trataTipo(String tipo) {
		return tipo.trim().toLowerCase();
	}
	
	private int defineId() {
		return this.contador++;
	}
	
	private ItemCompravel criaProdutoNaoIndustrializado(String nome, String categoria) {
		ItemCompravel ic = new ProdutoNaoIndustrializado(nome, categoria);
		ic.setId(this.defineId());
		return ic;
	}
	
	private ItemCompravel criaProdutoQuantidadeFixa(String nome, String categoria) {
		ItemCompravel ic = new ProdutoQuantidadeFixa(nome, categoria);
		ic.setId(this.defineId());
		return ic;
	}
	
	private ItemCompravel criaProdutoUnidade(String nome, String categoria) {
		ItemCompravel ic = new ProdutoUnidade(nome, categoria);
		ic.setId(this.defineId());
		return ic;
	}

}
