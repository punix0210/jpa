package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CodigoProduto")
public class CodigoProduto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdCodigoProduto")
	private String idCodigoProduto;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "IdProduto")
	private String idProduto;

	@Column(name = "IdTipoCodigoProduto")
	private String idTipoCodigoProduto;

	@Column(name = "StCodigoPrincipal")
	private String stCodigoPrincipal;

	public CodigoProduto(String idCodigoProduto, String cdChamada, String idProduto, String idTipoCodigoProduto,
			String stCodigoPrincipal) {
		super();
		this.idCodigoProduto = idCodigoProduto;
		this.cdChamada = cdChamada;
		this.idProduto = idProduto;
		this.idTipoCodigoProduto = idTipoCodigoProduto;
		this.stCodigoPrincipal = stCodigoPrincipal;
	}
	
	public CodigoProduto() {}

	public String getIdCodigoProduto() {
		return idCodigoProduto;
	}

	public void setIdCodigoProduto(String idCodigoProduto) {
		this.idCodigoProduto = idCodigoProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getIdTipoCodigoProduto() {
		return idTipoCodigoProduto;
	}

	public void setIdTipoCodigoProduto(String idTipoCodigoProduto) {
		this.idTipoCodigoProduto = idTipoCodigoProduto;
	}

	public String getStCodigoPrincipal() {
		return stCodigoPrincipal;
	}

	public void setStCodigoPrincipal(String stCodigoPrincipal) {
		this.stCodigoPrincipal = stCodigoPrincipal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCodigoProduto == null) ? 0 : idCodigoProduto.hashCode());
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		CodigoProduto other = (CodigoProduto) obj;
		if (idCodigoProduto == null) {
			if (other.idCodigoProduto != null)
				return false;
		} else if (!idCodigoProduto.equals(other.idCodigoProduto))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
