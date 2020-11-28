package com.erp.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idUsuario;

	private String nmLogin;

	private String nmUsuario;

	private String stAtivo;

	private String cdSenha;

	private List<EmpresaDto> empresas = new ArrayList<EmpresaDto>();

	public UsuarioDto() {
	}

	public List<EmpresaDto> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<EmpresaDto> empresas) {
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
		UsuarioDto other = (UsuarioDto) obj;
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
