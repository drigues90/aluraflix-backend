package br.com.jesus.jonathan.backendalurachallange.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jesus.jonathan.backendalurachallange.config.security.TokenService;
import br.com.jesus.jonathan.backendalurachallange.request.LoginRequest;
import br.com.jesus.jonathan.backendalurachallange.response.TokenResponse;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenResponse> login(@RequestBody @Valid LoginRequest request) {
		UsernamePasswordAuthenticationToken dadosLogin = mapper.map(request, UsernamePasswordAuthenticationToken.class);
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenResponse(token,"Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
