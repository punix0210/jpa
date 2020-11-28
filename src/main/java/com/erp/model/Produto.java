package com.erp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.erp.model.dto.ProdutoDto;
import com.erp.model.dto.Produto_EmpresaDto;
import com.erp.model.dto.SetorDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produto", schema = "dbo")
@NamedEntityGraph(name = "produto-graph", 
attributeNodes = { 
		@NamedAttributeNode("codigos"),
		@NamedAttributeNode("grupoProduto"), 
		@NamedAttributeNode("familiaProduto"), 
		@NamedAttributeNode("unidade"),
		@NamedAttributeNode(value = "setores", subgraph = "setores-graph") ,
		@NamedAttributeNode(value = "empresas", subgraph = "empresas-graph") }, 
subgraphs = {
				@NamedSubgraph(name = "setores-graph", 
						attributeNodes = { 
								@NamedAttributeNode("setor") 
								
				}),
				@NamedSubgraph(name = "empresas-graph", 
				attributeNodes = { 
						@NamedAttributeNode("empresa") 						
		}) 				

})
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdProduto")
	private String idProduto;

	@Column(name = "CdClassificacao")
	private String cdClassificacao;

	@Column(name = "IdProdutoMaster")
	private String idProdutoMaster;

	@Column(name = "NmProduto")
	private String nmProduto;

	@Column(name = "NmCurto")
	private String nmCurto;

	@Column(name = "StAtivo")
	private String stAtivo;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Set<CodigoProduto> codigos = new HashSet<CodigoProduto>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdGrupoProduto", referencedColumnName = "IdGrupoProduto")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private GrupoProduto grupoProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdFamiliaProduto", referencedColumnName = "IdFamiliaProduto")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private FamiliaProduto familiaProduto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdUnidade", referencedColumnName = "IdUnidade")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Unidade unidade;

	@Column(name = "DsObservacao")
	private String dsObservacao;

	@Column(name = "FtConversaoUnidade")
	private String ftConversaoUnidade;

	@Column(name = "VlPesoBruto")
	private Double vlPesoBruto;

	@Column(name = "VlPesoLiquido")
	private Double vlPesoLiquido;

	@Column(name = "DtCadastro")
	private String dtCadastro;

	@Column(name = "TpProduto")
	private String tpProduto;

	@Column(name = "TpOrigemProduto")
	private String tpOrigemProduto;

	@Column(name = "StServico")
	private String stServico;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Set<Produto_Setor> setores = new HashSet<Produto_Setor>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
	private Set<Produto_Empresa> empresas = new HashSet<Produto_Empresa>();

	public Produto() {
	}

	public Produto(String idProduto, String cdClassificacao, String idProdutoMaster, String nmProduto, String nmCurto,
			String stAtivo, Set<CodigoProduto> codigos, GrupoProduto grupoProduto, FamiliaProduto familiaProduto,
			Unidade unidade, String dsObservacao, String ftConversaoUnidade, Double vlPesoBruto, Double vlPesoLiquido,
			String dtCadastro, String tpProduto, String tpOrigemProduto, String stServico) {
		super();
		this.idProduto = idProduto;
		this.cdClassificacao = cdClassificacao;
		this.idProdutoMaster = idProdutoMaster;
		this.nmProduto = nmProduto;
		this.nmCurto = nmCurto;
		this.stAtivo = stAtivo;
		this.codigos = codigos;
		this.grupoProduto = grupoProduto;
		this.familiaProduto = familiaProduto;
		this.unidade = unidade;
		this.dsObservacao = dsObservacao;
		this.ftConversaoUnidade = ftConversaoUnidade;
		this.vlPesoBruto = vlPesoBruto;
		this.vlPesoLiquido = vlPesoLiquido;
		this.dtCadastro = dtCadastro;
		this.tpProduto = tpProduto;
		this.tpOrigemProduto = tpOrigemProduto;
		this.stServico = stServico;
	}

	public ProdutoDto convertDTO() {
		
		List<Produto_EmpresaDto> empresaDTO = this.empresas.stream().map(e -> e.convertDTO()).collect(Collectors.toList());

		List<SetorDto> setoresDTO = this.getSetores().stream().map(ps -> ps.getSetor().convertToDto())
				.collect(Collectors.toList());

		ProdutoDto dto = new ProdutoDto(this.getIdProduto(), this.codigoPrincipal(), this.getNmProduto(),
				this.getUnidade() == null ? "" : this.getUnidade().getCdSigla(),
				this.getGrupoProduto() == null ? "" : this.getGrupoProduto().getIdGrupoProduto(),
				this.getGrupoProduto() == null ? "" : this.getGrupoProduto().getNmGrupoProduto(),
				this.getFamiliaProduto() == null ? "" : this.getFamiliaProduto().getIdFamiliaProduto(),
				this.getFamiliaProduto() == null ? "" : this.getFamiliaProduto().getNmFamiliaProduto(),
				this.getDtCadastro(), this.getTpProduto(), this.getTpOrigemProduto(), this.getStServico());

		dto.setSetores(setoresDTO);
		
		dto.setEmpresas(empresaDTO);

		return dto;
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

	public Set<CodigoProduto> getCodigos() {
		return codigos;
	}

	public void setCodigos(Set<CodigoProduto> codigos) {
		this.codigos = codigos;
	}

	public String getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}

	public String getCdClassificacao() {
		return cdClassificacao;
	}

	public void setCdClassificacao(String cdClassificacao) {
		this.cdClassificacao = cdClassificacao;
	}

	public String getIdProdutoMaster() {
		return idProdutoMaster;
	}

	public void setIdProdutoMaster(String idProdutoMaster) {
		this.idProdutoMaster = idProdutoMaster;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getNmCurto() {
		return nmCurto;
	}

	public void setNmCurto(String nmCurto) {
		this.nmCurto = nmCurto;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public GrupoProduto getGrupoProduto() {
		return grupoProduto;
	}

	public void setGrupoProduto(GrupoProduto grupoProduto) {
		this.grupoProduto = grupoProduto;
	}

	public FamiliaProduto getFamiliaProduto() {
		return familiaProduto;
	}

	public void setFamiliaProduto(FamiliaProduto familiaProduto) {
		this.familiaProduto = familiaProduto;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String getDsObservacao() {
		return dsObservacao;
	}

	public void setDsObservacao(String dsObservacao) {
		this.dsObservacao = dsObservacao;
	}

	public String getFtConversaoUnidade() {
		return ftConversaoUnidade;
	}

	public void setFtConversaoUnidade(String ftConversaoUnidade) {
		this.ftConversaoUnidade = ftConversaoUnidade;
	}

	public Double getVlPesoBruto() {
		return vlPesoBruto;
	}

	public void setVlPesoBruto(Double vlPesoBruto) {
		this.vlPesoBruto = vlPesoBruto;
	}

	public Double getVlPesoLiquido() {
		return vlPesoLiquido;
	}

	public void setVlPesoLiquido(Double vlPesoLiquido) {
		this.vlPesoLiquido = vlPesoLiquido;
	}

	public Set<Produto_Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Produto_Setor> setores) {
		this.setores = setores;
	}

	public Set<Produto_Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<Produto_Empresa> empresas) {
		this.empresas = empresas;
	}

	public String codigoPrincipal() {
		return this.codigos.stream().filter(value -> value.getStCodigoPrincipal().equals("S")).findFirst().get()
				.getCdChamada();
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
