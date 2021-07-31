package br.com.jesus.jonathan.backendalurachallange.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jesus.jonathan.backendalurachallange.model.Video;
import br.com.jesus.jonathan.backendalurachallange.repository.VideoRepository;
import br.com.jesus.jonathan.backendalurachallange.request.VideoRequest;
import br.com.jesus.jonathan.backendalurachallange.response.VideoResponse;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository repository;
	
	public List<VideoResponse> listarVideoPorCategoria(Long id) {
		List<Video> categorias = repository.findByCategoriaId(id);
		return categorias.stream().map(VideoResponse::new).collect(Collectors.toList());
	}

	public List<VideoResponse> listar(String titulo) {
		return Optional.ofNullable(titulo).map(t -> VideoResponse.converter(repository.findByTitulo(t))).
				orElse(VideoResponse.converter(repository.findAll()));
	}

	public Video salvar(@Valid VideoRequest request) {
		return repository.save(request.converter());
	}

	public Optional<VideoResponse> detalhar(Long id) {
		Optional<Video> video = repository.findById(id);
		return video.map(VideoResponse::new);
	}

	@Transactional
	public Optional<VideoResponse> atualizar(@Valid VideoRequest request, Long id) {
		Optional<Video> video = repository.findById(id);
		return video.map(v -> {
			v.atualizar(request);
			return new VideoResponse(v);
		});
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

}
