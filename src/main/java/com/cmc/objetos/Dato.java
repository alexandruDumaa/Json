package com.cmc.objetos;



public class Dato {

	private String valor;
	private String id;

	// Constructores
	public Dato() {
	
	}

	public Dato(String valor, String id) {
		this.valor = valor;
		this.id = id;
	}


	//Accesores
	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Dato [valor=" + valor + ", identificador=" + id + "]";
	}

	

}
