package produtos;

public class ProdutoQuantidadeFixa extends ItemCompravel {
	
	private int quantidade;

	public ProdutoQuantidadeFixa(String nome, String categoria) {
		super(nome, categoria);
		this.quantidade = 0; // mudar
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.quantidade + " gramas, Preco: " + super.imprimePrecos();
	}

}
