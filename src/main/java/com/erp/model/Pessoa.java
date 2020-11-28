package com.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.model.dto.PessoaDto;

@Entity
@Table(name = "Pessoa", schema = "dbo")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdPessoa")
	private String idPessoa;

	@Column(name = "CdChamada")
	private String cdChamada;

	@Column(name = "TpPessoa")
	private String tpPessoa;

	@Column(name = "CdCPF_CGC")
	private String cdCpfCgc;

	@Column(name = "NmPessoa")
	private String nmPessoa;

	@Column(name = "NmCurto")
	private String nmCurto;

	public Pessoa(String idPessoa, String cdChamada, String tpPessoa, String cdCpfCgc, String nmPessoa,
			String nmCurto) {
		super();
		this.idPessoa = idPessoa;
		this.cdChamada = cdChamada;
		this.tpPessoa = tpPessoa;
		this.cdCpfCgc = cdCpfCgc;
		this.nmPessoa = nmPessoa;
		this.nmCurto = nmCurto;
	}

	public Pessoa() {
		super();
	}
	
	public PessoaDto convertToDto() {
		return new PessoaDto(this.getIdPessoa(), this.getCdChamada(), this.getTpPessoa(), this.getCdCpfCgc(), this.getNmPessoa(), this.getNmCurto());
	}

	public String getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(String idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public String getCdCpfCgc() {
		return cdCpfCgc;
	}

	public void setCdCpfCgc(String cdCpfCgc) {
		this.cdCpfCgc = cdCpfCgc;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getNmCurto() {
		return nmCurto;
	}

	public void setNmCurto(String nmCurto) {
		this.nmCurto = nmCurto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdChamada == null) ? 0 : cdChamada.hashCode());
		result = prime * result + ((cdCpfCgc == null) ? 0 : cdCpfCgc.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((nmPessoa == null) ? 0 : nmPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cdChamada == null) {
			if (other.cdChamada != null)
				return false;
		} else if (!cdChamada.equals(other.cdChamada))
			return false;
		if (cdCpfCgc == null) {
			if (other.cdCpfCgc != null)
				return false;
		} else if (!cdCpfCgc.equals(other.cdCpfCgc))
			return false;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (nmPessoa == null) {
			if (other.nmPessoa != null)
				return false;
		} else if (!nmPessoa.equals(other.nmPessoa))
			return false;
		return true;
	}

}
