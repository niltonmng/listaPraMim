package factory;

import produtos.*;

public class Main {


	public static void main(String[] args) {
		
		FactoryItens f = new FactoryItens();
		

		ItemCompravel pq = f.criaItem("Algodao Cremer", "  higiene Pessoal ", "produto quantidade fixa");		
		ItemCompravel pni = f.criaItem("produto1", "alimentos industrializados", "produto nao industrializado");
		ItemCompravel pu = f.criaItem("produto1", "alimentos industrializados", "produto unidade");

		pni.getMapaPrecos().put("preco1", 1.0);
		pni.getMapaPrecos().put("preco2", 1.0);

		pq.getMapaPrecos().put("preco1", 1.0);

		pu.getMapaPrecos().put("preco1", 1.0);
		pu.getMapaPrecos().put("preco2", 1.0);

		System.out.println(pq.toString());
		System.out.println(pni.toString());
		System.out.println(pu.toString());

	}

}
