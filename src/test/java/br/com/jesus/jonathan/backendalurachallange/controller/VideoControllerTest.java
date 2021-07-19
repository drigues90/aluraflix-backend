package br.com.jesus.jonathan.backendalurachallange.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
}
