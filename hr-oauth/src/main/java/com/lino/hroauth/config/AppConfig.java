package com.lino.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration//estou passando para o spring boot qque é uma classe de configuração
public class AppConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {//vai traduzir o dado ceiptografado que vai vir na base64
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		tokenConverter.setSigningKey("MY-SECRET-KEY");//Vai assinar a chave 
		return tokenConverter;
		
	}
	
	@Bean
	public JwtTokenStore tokenStore() {//vai ler as informações do token
		return new JwtTokenStore(accessTokenConverter());
	}
	
}
