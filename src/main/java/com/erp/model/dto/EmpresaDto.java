package com.erp.model.dto;

public class EmpresaDto {

	private Integer cdEmpresa;

	private String nmEmpresa;

	private String nrCGC;

	private String nmEmail;

	private String nrInscrEstadual;

	private String nmEmpresaCurto;

	private String cdUf;

	public EmpresaDto() {
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

}
