package produtos;

import java.util.HashMap;
import java.util.Map;

public abstract class ItemCompravel {
 
	private int id;
	private String nome;
	private Categoria categoria;
	private Map<String, Double> mapaPrecos;

	
	public ItemCompravel(String nome, String categoria) {
		this.id = 0;
		this.nome = nome;
		this.categoria = this.defineCategoriaCat(categoria);
		this.mapaPrecos = new HashMap<String, Double>();
	}
	
	public String imprimePrecos() {
		String saida = "<";
		for (String s : this.mapaPrecos.keySet()) {
			String preco = String.format("%.2f", this.mapaPrecos.get(s));
			saida += s + ", " + "R$ " + preco + "; ";
		}
		saida = saida.trim();
		saida = saida.substring(0, saida.length()-1);
		saida += ">";
		return saida;
	}
	
	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " + this.defineCategoriaStr(this.categoria) + ", ";
	}
	
	private String defineCategoriaStr(Categoria cat) {
		if (cat.equals(Categoria.ALIMENTOS_INDUSTRIALZADOS)) return "alimentos industrializados";
		else if (cat.equals(Categoria.ALIMENTOS_NAO_INDUSTRIALIZADOS)) return "alimentos nao industrializados";
		else if (cat.equals(Categoria.HIGIENE_PESSOAL)) return "higiene pessoal";
		else return "limpeza";
	}
	
	private Categoria defineCategoriaCat(String cat) {
		String input = cat.trim().toLowerCase();
		if (input.equals("alimentos industrializados")) return Categoria.ALIMENTOS_INDUSTRIALZADOS;
		else if (input.equals("alimentos nao industrializados")) return Categoria.ALIMENTOS_NAO_INDUSTRIALIZADOS;
		else if (input.equals("higiene pessoal")) return Categoria.HIGIENE_PESSOAL;
		else return Categoria.LIMPEZA;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCompravel other = (ItemCompravel) obj;
		if (categoria != other.categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Map<String, Double> getMapaPrecos() {
		return mapaPrecos;
	}

	public void setMapaPrecos(Map<String, Double> mapaPrecos) {
		this.mapaPrecos = mapaPrecos;
	}
	
}
