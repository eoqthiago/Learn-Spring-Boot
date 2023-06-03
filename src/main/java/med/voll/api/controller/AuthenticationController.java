package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.domain.user.User;
import med.voll.api.domain.user.dto.DadosAuthentication;
import med.voll.api.infra.security.TokenService;
import med.voll.api.infra.security.dto.useToken;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity login(@RequestBody @Valid DadosAuthentication dados) {
		var authenticationToken = new  UsernamePasswordAuthenticationToken(dados.login(), dados.password());
		var authentication = authenticationManager.authenticate(authenticationToken);
		var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
		
		return ResponseEntity.ok(new useToken(tokenJWT));
		
	}
}
