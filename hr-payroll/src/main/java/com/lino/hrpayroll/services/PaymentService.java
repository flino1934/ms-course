package com.lino.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lino.hrpayroll.model.entities.Payment;
import com.lino.hrpayroll.model.entities.Worker;

@Service//esta anotando como um componente de serviço do spring
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;//esta chamando da classe application.properties
	
	//vai chamar do projeto worker os dados que serão passados através de uma chamada rest
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(Long workerId,int days) {//vai instaciar um pagamento

		Map<String, String> uriVariables = new HashMap<>();//esta passando o id em forma de parametros no map 
		uriVariables.put("id", ""+workerId);//esta passando a chave e o id
		
		//vai chamar do projeto worker os dados que serão passados através de uma chamada rest
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}",Worker.class,uriVariables);
		
		// por enquanto iremos passar alguns dados mocado
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
		
	}//Vai instaciar um obj do tipo pagamento apartir do workerId vai buscar no micro serviço o worker correspondente a esse id passado
	
}
