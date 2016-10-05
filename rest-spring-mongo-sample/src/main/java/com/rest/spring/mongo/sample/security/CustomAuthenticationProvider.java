package com.rest.spring.mongo.sample.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.rest.spring.mongo.sample.services.model.service.domain.Usuario;
import com.rest.spring.mongo.sample.services.model.service.ibs.UsuarioService;
/**
 * Classe que implementa a customizacao da autenticacao oAuth2 para 
 * os servicos.
 * 
 * @category - Provedor de Seguranca.
 *
 */
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
		
	 
       final String email = auth.getName();
       final String senha = auth.getCredentials().toString();
      
		
        Usuario usuario = usuarioService.verificaCredenciais(email, senha);
        
        if (usuario == null) {
            throw new BadCredentialsException("[Server] - Usuario nao autorizado.");
        }
        
        List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
        granted.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        return new UsernamePasswordAuthenticationToken(email, senha, granted);
    }

	@Override
	public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
