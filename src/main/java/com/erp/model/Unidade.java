package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Unidade", schema = "dbo")
public class Unidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdUnidade")
	private String idUnidade;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "NmUnidade")
	private String nmUnidade;

	@Column(name = "CdSigla")
	private String cdSigla;

	public Unidade(String idUnidade, String cdChamada, String nmUnidade, String cdSigla) {
		super();
		this.idUnidade = idUnidade;
		this.cdChamada = cdChamada;
		this.nmUnidade = nmUnidade;
		this.cdSigla = cdSigla;
	}

	public Unidade() {
		super();
	}

	public String getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(String idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmUnidade() {
		return nmUnidade;
	}

	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}

	public String getCdSigla() {
		return cdSigla;
	}

	public void setCdSigla(String cdSigla) {
		this.cdSigla = cdSigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdChamada == null) ? 0 : cdChamada.hashCode());
		result = prime * result + ((cdSigla == null) ? 0 : cdSigla.hashCode());
		result = prime * result + ((idUnidade == null) ? 0 : idUnidade.hashCode());
		result = prime * result + ((nmUnidade == null) ? 0 : nmUnidade.hashCode());
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
		Unidade other = (Unidade) obj;
		if (cdChamada == null) {
			if (other.cdChamada != null)
				return false;
		} else if (!cdChamada.equals(other.cdChamada))
			return false;
		if (cdSigla == null) {
			if (other.cdSigla != null)
				return false;
		} else if (!cdSigla.equals(other.cdSigla))
			return false;
		if (idUnidade == null) {
			if (other.idUnidade != null)
				return false;
		} else if (!idUnidade.equals(other.idUnidade))
			return false;
		if (nmUnidade == null) {
			if (other.nmUnidade != null)
				return false;
		} else if (!nmUnidade.equals(other.nmUnidade))
			return false;
		return true;
	}

}
