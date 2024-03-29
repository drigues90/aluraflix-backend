package br.com.jesus.jonathan.backendalurachallange.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.jesus.jonathan.backendalurachallange.request.VideoRequest;

@Entity
@Table(name = "tb_video")
public class Video {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty @NotNull
	private String titulo;
	@NotEmpty @NotNull
	private String descricao;
	@NotEmpty @NotNull
	private String url;
	@ManyToOne
	private Categoria categoria;

	public Video() {
		super();
	}
	
	public Video(@NotEmpty @NotNull String titulo, @NotEmpty @NotNull String descricao, @NotEmpty @NotNull String url, Categoria categoria) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.url = url;
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void atualizar(@Valid VideoRequest request) {
		this.titulo = request.getTitulo();
		this.descricao = request.getDescricao();
		this.url = request.getUrl();
		this.categoria = new Categoria(request.getCategoriaId());
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
