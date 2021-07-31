package br.com.jesus.jonathan.backendalurachallange.request;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank
	private String titulo;
	@NotBlank
	private String cor;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	

}
