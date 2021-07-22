package br.com.jesus.jonathan.backendalurachallange.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(path = "/{id}")
	public VideoResponse detalhar(@PathVariable Long id){
		Optional<Video> video = videoRepository.findById(id);
		return new VideoResponse(video.get());
	}
	
	@PutMapping(path = "/{id}")
	@Transactional
	public ResponseEntity<VideoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid VideoRequest request) {
		Video video = videoRepository.getOne(id);
		video.atualizar(request);
		
		return ResponseEntity.ok(new VideoResponse(video));
	}
	
	@PostMapping
	public ResponseEntity<VideoResponse> criarVideo(@RequestBody @Valid VideoRequest request, UriComponentsBuilder builder) {
		Video video = request.converter();
		videoRepository.save(video);
		
		URI uri = builder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
		return ResponseEntity.created(uri).body(new VideoResponse(video));
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deletar(@PathVariable Long id) {
		videoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
