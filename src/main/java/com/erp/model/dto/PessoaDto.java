package com.erp.model.dto;

public class PessoaDto {

	private String idPessoa;

	private String cdChamada;

	private String tpPessoa;

	private String cdCpfCgc;

	private String nmPessoa;

	private String nmCurto;

	public PessoaDto(String idPessoa, String cdChamada, String tpPessoa, String cdCpfCgc, String nmPessoa,
			String nmCurto) {
		super();
		this.idPessoa = idPessoa;
		this.cdChamada = cdChamada;
		this.tpPessoa = tpPessoa;
		this.cdCpfCgc = cdCpfCgc;
		this.nmPessoa = nmPessoa;
		this.nmCurto = nmCurto;
	}

	public PessoaDto() {
		super();
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

}
