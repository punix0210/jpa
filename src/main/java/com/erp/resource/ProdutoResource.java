package com.erp.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erp.exception.ResponseException;
import com.erp.model.dto.ProdutoDto;
import com.erp.service.ProdutoService;

@RequestMapping(value = "api/produtos")
@RestController
public class ProdutoResource {

	private final ProdutoService service;

	public ProdutoResource(ProdutoService service) {
		this.service = service;
	}

	@GetMapping("id")
	public ResponseEntity<?> findByIdProduto(@RequestParam(value = "value", defaultValue = "") String id) {
		try {
			return new ResponseEntity<ProdutoDto>(this.service.findByIdProduto(id), HttpStatus.OK);
		} catch (ResponseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<ProdutoDto>>(this.service.findAll(), HttpStatus.OK);
	}

}
