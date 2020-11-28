package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Produto_Setor", schema = "dbo")
public class Produto_Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Produto_SetorPK id;

	@MapsId(value = "IdSetor")
	@ManyToOne
	@JoinColumn(name = "IdSetor", referencedColumnName = "IdSetor")
	private Setor setor;

	@Column(name = "DsLocalizacao")
	private String dsLocalizacao;

	public Produto_Setor(Produto_SetorPK id, String dsLocalizacao) {
		super();
		this.id = id;
		this.dsLocalizacao = dsLocalizacao;
	}

	public Produto_Setor() {
		super();
	}

//	public Produto getProduto() {
//		return produto;
//	}
//
//	public void setProduto(Produto produto) {
//		this.produto = produto;
//	}

	public Produto_SetorPK getId() {
		return id;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public void setId(Produto_SetorPK id) {
		this.id = id;
	}

	public String getDsLocalizacao() {
		return dsLocalizacao;
	}

	public void setDsLocalizacao(String dsLocalizacao) {
		this.dsLocalizacao = dsLocalizacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsLocalizacao == null) ? 0 : dsLocalizacao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Produto_Setor other = (Produto_Setor) obj;
		if (dsLocalizacao == null) {
			if (other.dsLocalizacao != null)
				return false;
		} else if (!dsLocalizacao.equals(other.dsLocalizacao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
