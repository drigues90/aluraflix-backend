package br.com.jesus.jonathan.backendalurachallange.request;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.jesus.jonathan.backendalurachallange.model.Categoria;
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
	private Long categoriaId;

	public VideoRequest(@NotEmpty @NotNull String titulo, @NotEmpty @NotNull String descricao,
			@NotEmpty @NotNull String url, Long categoriaId) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoriaId = categoriaId;
	}

	public Video converter() {
		return new Video(this.getTitulo(), this.getDescricao(), this.getUrl(),new Categoria(this.categoriaId));
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

}
