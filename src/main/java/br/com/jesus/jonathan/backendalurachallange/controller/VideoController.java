package br.com.jesus.jonathan.backendalurachallange.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jesus.jonathan.backendalurachallange.model.Video;
import br.com.jesus.jonathan.backendalurachallange.repository.CategoriaRepository;
import br.com.jesus.jonathan.backendalurachallange.request.VideoRequest;
import br.com.jesus.jonathan.backendalurachallange.response.VideoResponse;
import br.com.jesus.jonathan.backendalurachallange.service.VideoService;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoService service;
	
	@GetMapping
	public List<VideoResponse> listar(String titulo) {
		return service.listar(titulo);
	}

	@PostMapping
	public ResponseEntity<VideoResponse> criarVideo(@RequestBody @Valid VideoRequest request, UriComponentsBuilder builder) {
		
		try {
			Video video = service.salvar(request);
			URI uri = builder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
			return ResponseEntity.created(uri).body(new VideoResponse(video));
			
		}catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Categoria não cadastrada",e);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<VideoResponse> detalhar(@PathVariable Long id) {
		Optional<VideoResponse> video = service.detalhar(id);
		return video.map(v -> ResponseEntity.ok(v)).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<VideoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid VideoRequest request) {
		try {
			Optional<VideoResponse> video = service.atualizar(request, id);
			return video.map(v -> ResponseEntity.ok(v)).orElse(ResponseEntity.notFound().build());
		}catch (DataIntegrityViolationException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Categoria não cadastrada",e);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		try {
			service.deletar(id);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
