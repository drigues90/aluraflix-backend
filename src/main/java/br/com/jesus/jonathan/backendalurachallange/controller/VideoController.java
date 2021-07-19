package br.com.jesus.jonathan.backendalurachallange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.jonathan.backendalurachallange.model.Video;
import br.com.jesus.jonathan.backendalurachallange.repository.VideoRepository;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	private List<Video> listar() {
		return videoRepository.findAll();
	}

}
