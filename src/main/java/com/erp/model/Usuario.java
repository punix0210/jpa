package com.erp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.erp.model.dto.UsuarioDto;

@Entity
@Table(name = "Usuario", schema = "dbo")
@NamedEntityGraph(name = "user-graph", 
attributeNodes = {
		@NamedAttributeNode(value = "empresas",subgraph = "empresa-graph") },
subgraphs = {
		@NamedSubgraph(
				name="empresa-graph",
				attributeNodes = @NamedAttributeNode("empresa")
		)}
)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IdUsuario")
	private String idUsuario;

	@Column(name = "NmLogin")
	private String nmLogin;

	@Column(name = "NmUsuario")
	private String nmUsuario;

	@Column(name = "StAtivo")
	private String stAtivo;

	@Column(name = "CdSenha")
	private String cdSenha;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
	private Set<UsuarioEmpresa> empresas = new HashSet<UsuarioEmpresa>();

	public Usuario() {
	}

	public UsuarioDto convertDto() {

		UsuarioDto dto = new UsuarioDto();

		dto.setStAtivo(this.stAtivo);
		dto.setCdSenha(this.cdSenha);
		dto.setIdUsuario(this.idUsuario);
		dto.setNmLogin(this.nmLogin);
		dto.setNmUsuario(this.nmUsuario);

		dto.setEmpresas(EmpresaERP.convertDtoList(empresas));

		return dto;
	}

	public Set<UsuarioEmpresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<UsuarioEmpresa> empresas) {
		this.empresas = empresas;
	}

	public String getCdSenha() {
		return cdSenha;
	}

	public void setCdSenha(String cdSenha) {
		this.cdSenha = cdSenha;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNmLogin() {
		return nmLogin;
	}

	public void setNmLogin(String nmLogin) {
		this.nmLogin = nmLogin;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((nmLogin == null) ? 0 : nmLogin.hashCode());
		result = prime * result + ((nmUsuario == null) ? 0 : nmUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (nmLogin == null) {
			if (other.nmLogin != null)
				return false;
		} else if (!nmLogin.equals(other.nmLogin))
			return false;
		if (nmUsuario == null) {
			if (other.nmUsuario != null)
				return false;
		} else if (!nmUsuario.equals(other.nmUsuario))
			return false;
		return true;
	}

}
