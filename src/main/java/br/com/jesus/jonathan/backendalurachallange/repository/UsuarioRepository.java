package br.com.jesus.jonathan.backendalurachallange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jesus.jonathan.backendalurachallange.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUserName(String username);

}
