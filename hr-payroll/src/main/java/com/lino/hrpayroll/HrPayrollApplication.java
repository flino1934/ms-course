package com.lino.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients//vai conectar um projeto com o outro usando o feing ao invés de RestTemplate
@RibbonClient(name = "hr-worker")//vamos configurar a aplicação como um cliente ribbon que vai fazer o balanceamento
@SpringBootApplication
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
