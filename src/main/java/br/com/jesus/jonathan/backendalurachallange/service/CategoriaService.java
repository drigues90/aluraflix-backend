package br.com.jesus.jonathan.backendalurachallange.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jesus.jonathan.backendalurachallange.model.Categoria;
import br.com.jesus.jonathan.backendalurachallange.repository.CategoriaRepository;
import br.com.jesus.jonathan.backendalurachallange.request.CategoriaRequest;
import br.com.jesus.jonathan.backendalurachallange.response.CategoriaResponse;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ModelMapper mapper;

	public List<CategoriaResponse> listar() {
		return categoriaRepository.findAll().stream().map(c -> mapper.map(c, CategoriaResponse.class))
				.collect(Collectors.toList());
	}

	public Optional<CategoriaResponse> detalhar(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.map(c -> mapper.map(c, CategoriaResponse.class));
	}
	
	public CategoriaResponse salvar(CategoriaRequest request) {
		Categoria categoria = mapper.map(request, Categoria.class);
		categoria = categoriaRepository.save(categoria);
		return mapper.map(categoria, CategoriaResponse.class);
	}

	@Transactional
	public Optional<CategoriaResponse> atualizar(@Valid CategoriaRequest request, Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.map(c -> {
			c.atualizar(request);
			return mapper.map(c, CategoriaResponse.class);
		});
	}

	public void deletar(Long id) {
		categoriaRepository.deleteById(id);
	}

}
;