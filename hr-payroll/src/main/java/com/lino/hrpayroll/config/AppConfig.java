package com.lino.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean
	public RestTemplate restTemplate() {//vai registrar uma instancia unica singleton de rest Template que ficara disponivel para ser injetada em outros componentes
		return new RestTemplate();
	}

}
