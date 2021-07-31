package br.com.jesus.jonathan.backendalurachallange.response;

public class CategoriaResponse {

	private Long id;
	private String titulo;
	private String cor;

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
}
