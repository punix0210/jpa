package com.erp.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.erp.exception.ResponseException;
import com.erp.model.Usuario;
import com.erp.repository.custom.UsuarioRepositoryCustom;

public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

	@Autowired
	EntityManager manager;

	@Override
	public List<Usuario> findAllByStAtivo() {
		
		EntityGraph<?> graph = this.manager.createEntityGraph("user-graph");

		List<Usuario> rows = this.manager
				.createQuery(
						"From Usuario u "
								+ "Where u.stAtivo = :ativo",
						Usuario.class)
				.setParameter("ativo", "S")
				.setHint("javax.persistence.loadgraph", graph)				
				.getResultList();

		return rows;
	}

	public List<Usuario> findByNmLogin(String nmLogin) {
		
		EntityGraph<?> graph = this.manager.createEntityGraph("user-graph");
		
		List<Usuario> rows = this.manager
				.createQuery("From Usuario u Where u.nmLogin like :login", Usuario.class)		
				.setParameter("login", "%" + nmLogin + "%")
				.setHint("javax.persistence.loadgraph", graph)
				.getResultList();

		if (rows.isEmpty()) {
			throw new ResponseException("Nenhum usuário localizado com o termo " + nmLogin);
		}

		return rows;
	}

	public Usuario findByIdUsuario(String id) {

		EntityGraph<?> graph = this.manager.createEntityGraph("user-graph");
		
		Optional<Usuario> user = this.manager.createQuery(
				"Select distinct u From Usuario u where u.idUsuario= :id",
				Usuario.class)
				.setParameter("id", id)
				.setHint("javax.persistence.loadgraph",graph)
				.setHint("hibernate.query.passDistinctThrough", false)
				.getResultList().stream().findFirst();

		if (!user.isPresent()) {
			throw new ResponseException("Usuário não localizado!");
		}

		return user.get();
	}	
	
	public Usuario autenticar(String login, String senha) {
		Optional<Usuario> user = this.manager.createQuery("From Usuario Where nmLogin = :login", Usuario.class)
				.setParameter("login", login).getResultList().stream().findFirst();

		if (!user.isPresent()) {
			throw new ResponseException("Usuário não localizado!");
		}

		return user.get();
	}

	@Override
	public Usuario findByNmUsuario(String nmUsuario) {
		
		EntityGraph<?> graph = this.manager.createEntityGraph("user-graph");
		
		Optional<Usuario> row = this.manager.createQuery("From Usuario u where u.nmUsuario = :nome", Usuario.class)
				.setParameter("nome", nmUsuario)
				.setHint("javax.persistence.loadgraph", graph)
				.getResultStream().findFirst();

		if (!row.isPresent()) {
			throw new ResponseException("Usuário não localizado!");
		}

		return row.get();
	}

}
