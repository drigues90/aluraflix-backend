package br.com.jesus.jonathan.backendalurachallange.config.security;


import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.jesus.jonathan.backendalurachallange.repository.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AutenticacaoService autenticaoService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Bean
	@Override // cria e disponibiliza o autentication manager para a injecao de dependencias
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
	// configuracoes de autenticacao
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(autenticaoService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	// configuracoes de autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/categorias").permitAll()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/sessions").permitAll()
		.antMatchers(HttpMethod.OPTIONS,"/login").permitAll()
		.antMatchers(HttpMethod.POST,"/login").permitAll()
		.anyRequest().authenticated().and().csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().addFilterBefore(new AutenticacaoTokenFilter(tokenService,usuarioRepository), UsernamePasswordAuthenticationFilter.class)
	    .exceptionHandling()
	    .authenticationEntryPoint((request, response, e) -> 
	    {
	        response.setContentType("application/json;charset=UTF-8");
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.getWriter().write(new ObjectMapper().valueToTree(Map.of("messagem","Não Autorizado")).toString());
	    });
		
	}
	
	// configuracoes de arquivos estativos (css,js,html e etc)
	@Override
	public void configure(WebSecurity web) throws Exception {
	}
}

