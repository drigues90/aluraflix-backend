package br.com.jesus.jonathan.backendalurachallange.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jesus.jonathan.backendalurachallange.request.VideoRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VideoControllerTest {

	private URI uri;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void before() throws URISyntaxException {
		uri = new URI("/videos");
	}

	@Test
	public void deveRetornar200AoListarVideos() throws Exception {
		mockMvc.perform(get(uri)).andExpect(status().isOk());
	}

	@Test
	public void deveRetornar200ConsultarVideoPorId() throws Exception {
		mockMvc.perform(get("/videos/{id}", 1)).andExpect(status().isOk());
	}

	@Test
	public void deveRetornar201AoCriarNovoVideo() throws JsonProcessingException, Exception {
		mockMvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper()
						.writeValueAsString(new VideoRequest("Primeiro Video", "Meu primeiro video", "yabfc",null))))
				.andExpect(status().isCreated());
	}

	@Test
	public void deveRetornar200AoatualizarVideo() throws JsonProcessingException, Exception {
		mockMvc.perform(put("/videos/{id}", 1).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper()
						.writeValueAsString(new VideoRequest("atualiacao Video", "atualizado video", "yabfc",null))))
				.andExpect(status().isOk());
	}

	@Test
	public void deveRetornar200aoExcluirVideo() throws Exception {
		mockMvc.perform(delete("/videos/{id}", 1)).andExpect(status().isOk());
	}

	@Test
	public void deveRetornar404AoBuscarVideoInexistente() throws Throwable {
		mockMvc.perform(get("/videos/{id}", 999)).andExpect(status().isNotFound());
	}

}
