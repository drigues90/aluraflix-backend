package br.com.jesus.jonathan.backendalurachallange.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.jesus.jonathan.backendalurachallange.model.Video;

public class VideoRequest {

	@NotEmpty
	@NotNull
	private String titulo;
	@NotEmpty
	@NotNull
	private String descricao;
	@NotEmpty
	@NotNull
	private String url;

	public VideoRequest(@NotEmpty @NotNull String titulo, @NotEmpty @NotNull String descricao,
			@NotEmpty @NotNull String url) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
	}

	public Video converter() {
		return new Video(this.getTitulo(), this.getDescricao(), this.getUrl());
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
