package com.erp.repository.custom;

import java.util.List;

import com.erp.model.Usuario;

public interface UsuarioRepositoryCustom {

	public List<Usuario> findAllByStAtivo();
	public Usuario findByIdUsuario(String id);
	public List<Usuario> findByNmLogin(String nmLogin);
	public Usuario autenticar(String login, String senha);
	public Usuario findByNmUsuario(String nmUsuario);
	
	
}
