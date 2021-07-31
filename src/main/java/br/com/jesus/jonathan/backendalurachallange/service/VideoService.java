package br.com.jesus.jonathan.backendalurachallange.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jesus.jonathan.backendalurachallange.model.Video;
import br.com.jesus.jonathan.backendalurachallange.repository.VideoRepository;
import br.com.jesus.jonathan.backendalurachallange.response.VideoResponse;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository repository;
	
	public List<VideoResponse> listarVideoPorCategoria(Long id) {
		List<Video> categorias = repository.findByCategoriaId(id);
		return categorias.stream().map(VideoResponse::new).collect(Collectors.toList());
	}

}
