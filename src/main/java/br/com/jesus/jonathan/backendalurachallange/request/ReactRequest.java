package br.com.jesus.jonathan.backendalurachallange.request;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class ReactRequest {

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ReactRequest [email=" + email + ", password=" + password + "]";
	}

	public UsernamePasswordAuthenticationToken converter() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
	
}
