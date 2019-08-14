package produtos;

public class ProdutoQuantidadeFixa extends ItemCompravel {

	public ProdutoQuantidadeFixa(String nome, String categoria) {
		super(nome, categoria);
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "300" + " gramas, Preco: " + super.imprimePrecos();
	} // MUDAR O VALOR FIXADO DE 300	

}
