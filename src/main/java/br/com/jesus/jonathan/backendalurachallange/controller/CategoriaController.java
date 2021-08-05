package br.com.jesus.jonathan.backendalurachallange.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import br.com.jesus.jonathan.backendalurachallange.response.VideoResponse;
import br.com.jesus.jonathan.backendalurachallange.service.CategoriaService;
import br.com.jesus.jonathan.backendalurachallange.service.VideoService;

@RestController
@RequestMapping(value = "categorias")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@Autowired
	private VideoService videoService;

	@GetMapping
	public List<?> listar(String _embed) {
		return service.listar(_embed);
	}
	
	@GetMapping(path = "{id}/videos")
	public List<VideoResponse> listarPorCategoria(@PathVariable Long id){
		return videoService.listarVideoPorCategoria(id);
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
	
	@DeleteMapping(path = "{id}")
	public ResponseEntity<CategoriaResponse> deletar(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
