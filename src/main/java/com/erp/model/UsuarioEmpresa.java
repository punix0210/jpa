package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Usuario_Empresa", schema = "dbo")
public class UsuarioEmpresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UsuarioEmpresaPK id;

	@MapsId("CdEmpresa")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CdEmpresa", referencedColumnName = "CdEmpresa")
	@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
	private EmpresaERP empresa;

	@Column(name = "CdOrdemConsultaEmpresa")
	private Integer cdOrdemConsultaEmpresa;

	public UsuarioEmpresa(UsuarioEmpresaPK id, EmpresaERP empresa, Integer cdOrdemConsultaEmpresa) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.cdOrdemConsultaEmpresa = cdOrdemConsultaEmpresa;
	}

	public UsuarioEmpresa() {
	}

	public EmpresaERP getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaERP empresa) {
		this.empresa = empresa;
	}

	public UsuarioEmpresaPK getId() {
		return id;
	}

	public void setId(UsuarioEmpresaPK id) {
		this.id = id;
	}

	public Integer getCdOrdemConsultaEmpresa() {
		return cdOrdemConsultaEmpresa;
	}

	public void setCdOrdemConsultaEmpresa(Integer cdOrdemConsultaEmpresa) {
		this.cdOrdemConsultaEmpresa = cdOrdemConsultaEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UsuarioEmpresa other = (UsuarioEmpresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
