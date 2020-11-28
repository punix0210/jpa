package com.erp.model.dto;

import java.util.List;

public class ProdutoDto {

	private String idProduto;

	private String codigo;

	private String nmProduto;

	private String cdSigla;

	private String idGrupo;

	private String nmGrupo;

	private String idFamilia;

	private String nmFamilia;

	private String dtCadastro;

	private String tpProduto;

	private String tpOrigemProduto;

	private String stServico;

	private List<SetorDto> setores;

	private List<Produto_EmpresaDto> empresas;

	public ProdutoDto() {
	}

	public ProdutoDto(String idProduto, String codigo, String nmProduto, String cdSigla, String idGrupo, String nmGrupo,
			String idFamilia, String nmFamilia, String dtCadastro, String tpProduto, String tpOrigemProduto,
			String stServico) {
		super();
		this.idProduto = idProduto;
		this.codigo = codigo;
		this.nmProduto = nmProduto;
		this.cdSigla = cdSigla;
		this.idGrupo = idGrupo;
		this.nmGrupo = nmGrupo;
		this.idFamilia = idFamilia;
		this.nmFamilia = nmFamilia;
		this.dtCadastro = dtCadastro;
		this.tpProduto = tpProduto;
		this.tpOrigemProduto = tpOrigemProduto;
		this.stServico = stServico;
	}

	public List<SetorDto> getSetores() {
		return setores;
	}

	public void setSetores(List<SetorDto> setores) {
		this.setores = setores;
	}

	public String getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public String getTpProduto() {
		return tpProduto;
	}

	public void setTpProduto(String tpProduto) {
		this.tpProduto = tpProduto;
	}

	public String getTpOrigemProduto() {
		return tpOrigemProduto;
	}

	public void setTpOrigemProduto(String tpOrigemProduto) {
		this.tpOrigemProduto = tpOrigemProduto;
	}

	public String getStServico() {
		return stServico;
	}

	public void setStServico(String stServico) {
		this.stServico = stServico;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getCdSigla() {
		return cdSigla;
	}

	public void setCdSigla(String cdSigla) {
		this.cdSigla = cdSigla;
	}

	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	public String getNmGrupo() {
		return nmGrupo;
	}

	public void setNmGrupo(String nmGrupo) {
		this.nmGrupo = nmGrupo;
	}

	public String getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(String idFamilia) {
		this.idFamilia = idFamilia;
	}

	public String getNmFamilia() {
		return nmFamilia;
	}

	public void setNmFamilia(String nmFamilia) {
		this.nmFamilia = nmFamilia;
	}

	public List<Produto_EmpresaDto> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Produto_EmpresaDto> empresas) {
		this.empresas = empresas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		ProdutoDto other = (ProdutoDto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
