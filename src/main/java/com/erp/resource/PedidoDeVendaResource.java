package com.erp.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.exception.ResponseException;
import com.erp.model.dto.PedidoDeVendaDto;
import com.erp.model.filter.PedidoDeVendaFilter;
import com.erp.service.PedidoDeVendaService;

@RestController
@RequestMapping(value = "api/pedidos")
public class PedidoDeVendaResource {

	PedidoDeVendaService service;

	public PedidoDeVendaResource(PedidoDeVendaService service) {
		this.service = service;
	}

	@GetMapping("")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<PedidoDeVendaDto>>(this.service.findAll(), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		try {
			PedidoDeVendaDto dto = this.service.findByIdPedido(id);
			return new ResponseEntity<PedidoDeVendaDto>(dto, HttpStatus.OK);
		} catch (ResponseException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("search")
	public ResponseEntity<?> search(@RequestBody PedidoDeVendaFilter filter) {
		return new ResponseEntity<>(this.service.search(filter), HttpStatus.OK);
	}	

}
