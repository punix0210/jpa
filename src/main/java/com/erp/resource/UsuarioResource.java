package com.erp.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erp.exception.ResponseException;
import com.erp.model.Usuario;
import com.erp.model.dto.UsuarioDto;
import com.erp.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "api/usuarios")
public class UsuarioResource {

	private final UsuarioService service;

	public UsuarioResource(UsuarioService service) {
		this.service = service;
	}

	@GetMapping(value = "")
	public ResponseEntity<?> findAll() {
		try {
			List<Usuario> users = this.service.findAll();
			return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
		} catch (ResponseException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("id")
	public ResponseEntity<?> findByIdUsuario(@RequestParam(value = "value", defaultValue = "") String id) {
		try {
			Usuario user = this.service.findByIdUsuario(id);
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("search")
	public ResponseEntity<?> findByNmLogin(@RequestParam(value = "login", defaultValue = "") String login) {
		try {
			List<Usuario> users = this.service.findByNmLogin(login);
			return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
		} catch (ResponseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("search-nome")
	public ResponseEntity<?> findByNmUsuario(@RequestParam(value = "value", defaultValue = "") String nome) {
		try {
			Usuario user = this.service.findByNmUsuario(nome);
			return new ResponseEntity<Usuario>(user, HttpStatus.OK);
		} catch (ResponseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}	

	@PostMapping("auth")
	public ResponseEntity<?> autenticar(@RequestBody UsuarioDto user) {
		try {
			Usuario u = this.service.autenticar(user.getNmLogin(), user.getCdSenha());
			return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		} catch (ResponseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
