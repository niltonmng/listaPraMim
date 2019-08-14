package produtos;

public class ProdutoUnidade extends ItemCompravel{

	public ProdutoUnidade(String nome, String categoria) {
		super(nome, categoria);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Preco: " + this.imprimePrecos();
	}

}
