package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GrupoProduto", schema = "dbo")
public class GrupoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdGrupoProduto")
	private String idGrupoProduto;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "NmGrupoProduto")
	private String nmGrupoProduto;

	public GrupoProduto(String idGrupoProduto, String cdChamada, String nmGrupoProduto) {
		super();
		this.idGrupoProduto = idGrupoProduto;
		this.cdChamada = cdChamada;
		this.nmGrupoProduto = nmGrupoProduto;
	}

	public GrupoProduto() {
		super();
	}

	public String getIdGrupoProduto() {
		return idGrupoProduto;
	}

	public void setIdGrupoProduto(String idGrupoProduto) {
		this.idGrupoProduto = idGrupoProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmGrupoProduto() {
		return nmGrupoProduto;
	}

	public void setNmGrupoProduto(String nmGrupoProduto) {
		this.nmGrupoProduto = nmGrupoProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGrupoProduto == null) ? 0 : idGrupoProduto.hashCode());
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
		GrupoProduto other = (GrupoProduto) obj;
		if (idGrupoProduto == null) {
			if (other.idGrupoProduto != null)
				return false;
		} else if (!idGrupoProduto.equals(other.idGrupoProduto))
			return false;
		return true;
	}

}
