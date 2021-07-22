package br.com.jesus.jonathan.backendalurachallange.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.jesus.jonathan.backendalurachallange.model.Video;

public class VideoResponse {

	private Long id;
	private String titulo;
	private String descricao;
	private String url;

	public VideoResponse(Video video) {
		this.id = video.getId();
		this.titulo = video.getTitulo();
		this.descricao = video.getDescricao();
		this.url = video.getUrl();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static List<VideoResponse> converter(List<Video> videos) {
		return videos.stream().map(VideoResponse::new).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

}
