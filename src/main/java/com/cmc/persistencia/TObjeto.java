package com.cmc.persistencia;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "primaria")
public class TObjeto {
	
	@Column(name = "ip", nullable = false)
	private String ip;
	@Id
	@Column(name = "id", nullable = false)
	private String id; 
	@Column(name = "tagname", nullable = false)
	private String tagName; 
	@Column(name = "idvalor", nullable = false)
	private String idValor; 

	
	//Constructores
	public TObjeto() {

		
	}

	
	
	public TObjeto(String ip, String id, String tagName, String idValor) {
		super();
		this.ip = ip;
		this.id = id;
		this.tagName = tagName;
		this.idValor = idValor;
	}



	//Accesores
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getIdValor() {
		return idValor;
	}

	public void setIdValor(String idValor) {
		this.idValor = idValor;
	}



	@Override
	public String toString() {
		return "TObjeto [ip=" + ip + ", id=" + id + ", tagName=" + tagName + ", idValor=" + idValor + "]";
	}
	

}
