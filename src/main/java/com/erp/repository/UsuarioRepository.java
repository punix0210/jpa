package com.erp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erp.model.Usuario;
import com.erp.repository.custom.UsuarioRepositoryCustom;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>, UsuarioRepositoryCustom {

}
