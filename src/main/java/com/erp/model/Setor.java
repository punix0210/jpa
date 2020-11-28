package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.model.dto.SetorDto;

@Entity
@Table(name = "Setor", schema = "dbo")
public class Setor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdSetor")
	private String idSetor;

	@Column(name = "cdChamada")
	private String cdChamda;

	@Column(name = "nmSetor")
	private String nmSetor;

	@Column(name = "cdEmpresa")
	private Integer cdEmpresa;

	public Setor() {
	}

	public Setor(String idSetor, String cdChamda, String nmSetor, Integer cdEmpresa) {
		super();
		this.idSetor = idSetor;
		this.cdChamda = cdChamda;
		this.nmSetor = nmSetor;
		this.cdEmpresa = cdEmpresa;
	}

	public SetorDto convertToDto() {		
		return new SetorDto(this.getIdSetor(), this.getCdChamda(), this.getNmSetor());
	}

	public String getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(String idSetor) {
		this.idSetor = idSetor;
	}

	public String getCdChamda() {
		return cdChamda;
	}

	public void setCdChamda(String cdChamda) {
		this.cdChamda = cdChamda;
	}

	public String getNmSetor() {
		return nmSetor;
	}

	public void setNmSetor(String nmSetor) {
		this.nmSetor = nmSetor;
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
		result = prime * result + ((cdChamda == null) ? 0 : cdChamda.hashCode());
		result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
		result = prime * result + ((nmSetor == null) ? 0 : nmSetor.hashCode());
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
		Setor other = (Setor) obj;
		if (cdChamda == null) {
			if (other.cdChamda != null)
				return false;
		} else if (!cdChamda.equals(other.cdChamda))
			return false;
		if (cdEmpresa == null) {
			if (other.cdEmpresa != null)
				return false;
		} else if (!cdEmpresa.equals(other.cdEmpresa))
			return false;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		if (nmSetor == null) {
			if (other.nmSetor != null)
				return false;
		} else if (!nmSetor.equals(other.nmSetor))
			return false;
		return true;
	}

}
