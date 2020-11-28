package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Produto_EmpresaPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "IdProduto")
	private String idProduto;

	@Column(name = "CdEmpresa")
	private Integer cdEmpresa;

	public Produto_EmpresaPK(String idProduto, Integer cdEmpresa) {
		super();
		this.idProduto = idProduto;
		this.cdEmpresa = cdEmpresa;
	}

	public Produto_EmpresaPK() {
		super();
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public Integer getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Integer cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
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
		Produto_EmpresaPK other = (Produto_EmpresaPK) obj;
		if (cdEmpresa == null) {
			if (other.cdEmpresa != null)
				return false;
		} else if (!cdEmpresa.equals(other.cdEmpresa))
			return false;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
