package br.com.jesus.jonathan.backendalurachallange.response;

import java.util.List;

public class CategoriaResponse {

	private Long id;
	private String titulo;
	private String cor;

	private List<VideoResponse> videos;

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCor() {
		return cor;
	}

	public List<VideoResponse> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoResponse> videos) {
		this.videos = videos;
	}
}
