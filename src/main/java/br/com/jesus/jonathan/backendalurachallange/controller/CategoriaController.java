package br.com.jesus.jonathan.backendalurachallange.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jesus.jonathan.backendalurachallange.request.CategoriaRequest;
import br.com.jesus.jonathan.backendalurachallange.response.CategoriaResponse;
import br.com.jesus.jonathan.backendalurachallange.service.CategoriaService;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping
	public List<CategoriaResponse> listar() {
		return service.listar();
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<CategoriaResponse> detalhar(@PathVariable Long id) {
		 Optional<CategoriaResponse> categoria = service.detalhar(id);
		 return categoria.map(c -> ResponseEntity.ok(c)).orElse(ResponseEntity.notFound().build());
	};
	
	@PostMapping
	public ResponseEntity<CategoriaResponse> salvar(@RequestBody @Valid CategoriaRequest request, UriComponentsBuilder builder) {
		CategoriaResponse categoria = service.salvar(request);
		
		URI uri = builder.path("categorias/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@PutMapping(path = "{id}")
	public ResponseEntity<CategoriaResponse> atualizar(@RequestBody @Valid CategoriaRequest request, @PathVariable Long id) {
		Optional<CategoriaResponse> categoria = service.atualizar(request,id);
		return categoria.map(c -> ResponseEntity.ok(c)).orElse(ResponseEntity.notFound().build());
	}

}
