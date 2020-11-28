package com.erp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.erp.model.dto.EmpresaDto;

@Entity
@Table(name = "EmpresaERP", schema = "dbo")
public class EmpresaERP implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CdEmpresa")
	private Integer cdEmpresa;

	@Column(name = "NmEmpresa")
	private String nmEmpresa;

	@Column(name = "NrCGC")
	private String nrCGC;

	@Column(name = "NmEmail")
	private String nmEmail;

	@Column(name = "NrInscrEstadual")
	private String nrInscrEstadual;

	@Column(name = "NmEmpresaCurto")
	private String nmEmpresaCurto;

	@Column(name = "CdUF")
	private String cdUf;

	public EmpresaERP() {
		super();
	}

	public EmpresaERP(Integer cdEmpresa, String nmEmpresa, String nrCGC, String nmEmail, String nrInscrEstadual,
			String nmEmpresaCurto,String cdUf) {
		super();
		this.cdEmpresa = cdEmpresa;
		this.nmEmpresa = nmEmpresa;
		this.nrCGC = nrCGC;
		this.nmEmail = nmEmail;
		this.nrInscrEstadual = nrInscrEstadual;
		this.nmEmpresaCurto = nmEmpresaCurto;
		this.cdUf = cdUf;
	}

	public EmpresaDto convertDTO() {

		EmpresaDto dto = new EmpresaDto();

		dto.setCdEmpresa(getCdEmpresa());
		dto.setNmEmpresa(getNmEmpresa());
		dto.setNmEmpresaCurto(getNmEmpresaCurto());
		dto.setNrCGC(getNrCGC());
		dto.setNrInscrEstadual(getNrInscrEstadual());
		dto.setNmEmail(getNmEmail());
		dto.setCdUf(getCdUf());

		return dto;
	}

	public static List<EmpresaDto> convertDtoList(Set<UsuarioEmpresa> empresas) {

		List<EmpresaDto> dtos = new ArrayList<EmpresaDto>();

		empresas.forEach(empresa -> {

			EmpresaDto dto = new EmpresaDto();

			dto.setCdEmpresa(empresa.getEmpresa().getCdEmpresa());
			dto.setNmEmpresa(empresa.getEmpresa().getNmEmpresa());
			dto.setNmEmpresaCurto(empresa.getEmpresa().getNmEmpresaCurto());
			dto.setNrCGC(empresa.getEmpresa().getNrCGC());
			dto.setNrInscrEstadual(empresa.getEmpresa().getNrInscrEstadual());
			dto.setNmEmail(empresa.getEmpresa().getNmEmail());

			dtos.add(dto);
		});

		return dtos;
	}

	public String getCdUf() {
		return cdUf;
	}

	public void setCdUf(String cdUf) {
		this.cdUf = cdUf;
	}

	public Integer getCdEmpresa() {
		return cdEmpresa;
	}

	public void setCdEmpresa(Integer cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getNmEmpresa() {
		return nmEmpresa;
	}

	public void setNmEmpresa(String nmEmpresa) {
		this.nmEmpresa = nmEmpresa;
	}

	public String getNrCGC() {
		return nrCGC;
	}

	public void setNrCGC(String nrCGC) {
		this.nrCGC = nrCGC;
	}

	public String getNmEmail() {
		return nmEmail;
	}

	public void setNmEmail(String nmEmail) {
		this.nmEmail = nmEmail;
	}

	public String getNrInscrEstadual() {
		return nrInscrEstadual;
	}

	public void setNrInscrEstadual(String nrInscrEstadual) {
		this.nrInscrEstadual = nrInscrEstadual;
	}

	public String getNmEmpresaCurto() {
		return nmEmpresaCurto;
	}

	public void setNmEmpresaCurto(String nmEmpresaCurto) {
		this.nmEmpresaCurto = nmEmpresaCurto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdEmpresa == null) ? 0 : cdEmpresa.hashCode());
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
		EmpresaERP other = (EmpresaERP) obj;
		if (cdEmpresa == null) {
			if (other.cdEmpresa != null)
				return false;
		} else if (!cdEmpresa.equals(other.cdEmpresa))
			return false;
		return true;
	}

}
