package br.com.jesus.jonathan.backendalurachallange.response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.jesus.jonathan.backendalurachallange.model.Categoria;
import br.com.jesus.jonathan.backendalurachallange.model.Video;

public class VideoResponse {
	
	private Long id;
	private Long categoriaId;
	private String titulo;
	private String descricao;
	private String url;

	public VideoResponse(Video video) {
		this.id = video.getId();
		Optional.ofNullable(video.getCategoria()).ifPresentOrElse(v -> this.categoriaId = v.getId(),() -> this.categoriaId = Categoria.CATEGORIA_LIVRE);
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

	public Long getCategoriaId() {
		return categoriaId;
	}

}
