package br.com.jesus.jonathan.backendalurachallange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jesus.jonathan.backendalurachallange.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{

	List<Video> findByTitulo(String titulo);
	List<Video> findByCategoriaId(Long id);

}
