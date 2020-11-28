package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FamiliaProduto", schema = "dbo")
public class FamiliaProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdFamiliaProduto")
	private String idFamiliaProduto;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "NmFamiliaProduto")
	private String nmFamiliaProduto;

	public FamiliaProduto(String idFamiliaProduto, String cdChamada, String nmFamiliaProduto) {
		super();
		this.idFamiliaProduto = idFamiliaProduto;
		this.cdChamada = cdChamada;
		this.nmFamiliaProduto = nmFamiliaProduto;
	}

	public FamiliaProduto() {
		super();
	}

	public String getIdFamiliaProduto() {
		return idFamiliaProduto;
	}

	public void setIdFamiliaProduto(String idFamiliaProduto) {
		this.idFamiliaProduto = idFamiliaProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmFamiliaProduto() {
		return nmFamiliaProduto;
	}

	public void setNmFamiliaProduto(String nmFamiliaProduto) {
		this.nmFamiliaProduto = nmFamiliaProduto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdChamada == null) ? 0 : cdChamada.hashCode());
		result = prime * result + ((idFamiliaProduto == null) ? 0 : idFamiliaProduto.hashCode());
		result = prime * result + ((nmFamiliaProduto == null) ? 0 : nmFamiliaProduto.hashCode());
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
		FamiliaProduto other = (FamiliaProduto) obj;
		if (cdChamada == null) {
			if (other.cdChamada != null)
				return false;
		} else if (!cdChamada.equals(other.cdChamada))
			return false;
		if (idFamiliaProduto == null) {
			if (other.idFamiliaProduto != null)
				return false;
		} else if (!idFamiliaProduto.equals(other.idFamiliaProduto))
			return false;
		if (nmFamiliaProduto == null) {
			if (other.nmFamiliaProduto != null)
				return false;
		} else if (!nmFamiliaProduto.equals(other.nmFamiliaProduto))
			return false;
		return true;
	}

}
