package br.com.jesus.jonathan.backendalurachallange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.jesus.jonathan.backendalurachallange.config.security.TokenService;
import br.com.jesus.jonathan.backendalurachallange.request.ReactRequest;
import br.com.jesus.jonathan.backendalurachallange.response.TokenResponse;

@RestController
@RequestMapping(value = "/sessions")
public class SessionController {
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenResponse> login(@RequestBody ReactRequest request) {
		
		UsernamePasswordAuthenticationToken dadosLogin = request.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenResponse(token,"Bearer"));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario ou senha invalidos");
		}
	}

}
