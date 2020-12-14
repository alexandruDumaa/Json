package com.cmc.persistencia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "secundaria")
public class TResultado {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private long id;
	@Column(name = "fecha", nullable = false)
	private Timestamp fecha; 
	@Column(name = "valor", nullable = false)
	private Float valor;
	@Column(name = "tagname", nullable = false)
	private String tagName; 


	
	// Constructores
	public TResultado() {
	}
	
	public TResultado(long id, Timestamp fecha, Float valor, String tagName) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.valor = valor;
		this.tagName = tagName;
	}

	
	// Accesores
	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TResultado [id=" + id + ", fecha=" + fecha + ", valor=" + valor + ", tagName=" + tagName + "]";
	}

	
	
}
