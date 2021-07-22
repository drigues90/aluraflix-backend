package br.com.jesus.jonathan.backendalurachallange.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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

import br.com.jesus.jonathan.backendalurachallange.model.Video;
import br.com.jesus.jonathan.backendalurachallange.repository.VideoRepository;
import br.com.jesus.jonathan.backendalurachallange.request.VideoRequest;
import br.com.jesus.jonathan.backendalurachallange.response.VideoResponse;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public List<VideoResponse> listar() {
		return VideoResponse.converter(videoRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<VideoResponse> criarVideo(@RequestBody @Valid VideoRequest request, UriComponentsBuilder builder) {
		Video video = request.converter();
		videoRepository.save(video);
		
		URI uri = builder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new VideoResponse(video));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<VideoResponse> detalhar(@PathVariable Long id){
		Optional<Video> video = videoRepository.findById(id);
		if(video.isPresent())
			return ResponseEntity.ok(new VideoResponse(video.get()));
		else
			return ResponseEntity.notFound().build();
	}
	
	@Transactional
	@PutMapping(path = "/{id}")
	public ResponseEntity<VideoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid VideoRequest request) {
		Optional<Video> video = videoRepository.findById(id);
		if(video.isPresent()) {
			video.get().atualizar(request);
			return ResponseEntity.ok(new VideoResponse(video.get()));
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		try {
			videoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (EmptyResultDataAccessException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
