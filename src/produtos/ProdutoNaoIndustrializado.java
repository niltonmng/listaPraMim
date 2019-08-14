package produtos;

public class ProdutoNaoIndustrializado extends ItemCompravel{

	public ProdutoNaoIndustrializado(String nome, String categoria) {
		super(nome, categoria);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "Preco por quilo: " + this.imprimePrecos();
	}
	
}
