package com.erp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.model.Usuario;
import com.erp.model.dto.UsuarioDto;
import com.erp.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	public Usuario findByNmUsuario(String nmUsuario) {
		return this.repository.findByNmUsuario(nmUsuario);
	}

	public UsuarioDto findByNmUsuarioWithEmpresa(String nmUsuario) {

		Usuario user = this.repository.findByNmUsuario(nmUsuario);

		return user.convertDto();
	}

	public List<Usuario> findAll() {
		List<Usuario> rows = this.repository.findAllByStAtivo();

		return rows;
	}

	public Usuario findByIdUsuario(String id) {
		Usuario user = this.repository.findByIdUsuario(id);

		return user;
	}

	public List<Usuario> findByNmLogin(String nmLogin) {
		return this.repository.findByNmLogin(nmLogin);
	}

	public Usuario autenticar(String login, String senha) {
		return this.repository.autenticar(login, senha);
	}

}
