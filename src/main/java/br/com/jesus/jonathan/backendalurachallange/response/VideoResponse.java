package br.com.jesus.jonathan.backendalurachallange.response;

import br.com.jesus.jonathan.backendalurachallange.model.Video;

public class VideoResponse {

	private String titulo;
	private String descricao;
	private String url;

	public VideoResponse(Video video) {
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

}
