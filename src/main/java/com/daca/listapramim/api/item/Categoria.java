package com.daca.listapramim.api.item;

public enum Categoria {

	ALIMENTOS_INDUSTRIALIZADOS("ALIMENTOS_INDUSTRIALIZADOS", "Alimentos industrializados"),
	ALIMENTOS_NAO_INDUSTRIALIZADOS("ALIMENTOS_NAO_INDUSTRIALIZADOS", "Alimentos não industrializados"),
	LIMPEZA("LIMPEZA", "Limpeza"), 
	HIGIENE_PESSOAL("HIGIENE_PESSOAL", "Higiene pessoal");

	private String key;
	private String name;

	Categoria(String key, String name) {
		this.key = key;
		this.name = name;
	}

	public static Categoria fromName(String name) {
		for (Categoria categoria : Categoria.values()) {
			if (categoria.name.equalsIgnoreCase(name))
				return categoria;
		}

		throw new RuntimeException("Categoria " + name + " não existe");
	}

	public static Categoria fromKey(String key) {
		for (Categoria categoria : Categoria.values()) {
			if (categoria.key.equalsIgnoreCase(key))
				return categoria;
		}
		throw new RuntimeException("Categoria " + key + " não existe");
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
