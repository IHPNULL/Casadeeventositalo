package com.gft.casadeeventos.model;

import java.math.BigDecimal;
import java.util.Date;

import java.lang.Integer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("deprecation") 
@Entity
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotEmpty(message="Insira o nome do Evento")
	@NotNull
	private String Nome;
	
	private String descr;
	
	private String talento;
	
	private String organizador;
	

	@NotEmpty(message="insira o local")
	private String local;
	
	private BigDecimal preco;

	@NotNull(message="insira o limite de ingressos")
	private Integer ingressos;
	
	@NotNull(message="Insira a data no formato: dia/mes/ano")
	@DateTimeFormat(pattern = "dd/MM/yyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getTalento() {
		return talento;
	}

	public void setTalento(String talento) {
		this.talento = talento;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	
	public int getIngressos() {
		return ingressos;
	}

	public void setIngressos(int ingressos) {
		this.ingressos = ingressos;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Evento other = (Evento) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
}
