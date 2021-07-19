package br.com.jesus.jonathan.backendalurachallange.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
	public void before () throws URISyntaxException {
		uri = new URI("/videos");
	}

	@Test
	public void deveRetornar200AoListarVideos() throws Exception {
		mockMvc.perform(get(uri)).andExpect(status().isOk());
	}
	
	@Test
	public void deveRetornar201AoCriarNovoVideo() throws JsonProcessingException, Exception {
		mockMvc.perform(post(uri)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(new VideoRequest("Primeiro Video","Meu primeiro video","yabfc")))).andExpect(status().isCreated());
	}
}
