package com.lino.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lino.hrpayroll.feignclients.WorkerFeignClients;
import com.lino.hrpayroll.model.entities.Payment;
import com.lino.hrpayroll.model.entities.Worker;

@Service//esta anotando como um componente de serviço do spring
public class PaymentService {
	
	//vai chamar do projeto worker os dados que serão passados através de uma chamada rest
	@Autowired
	private WorkerFeignClients workerFeignClients;
	
	public Payment getPayment(Long workerId,int days) {//vai instaciar um pagamento
		
		Worker worker = workerFeignClients.findById(workerId).getBody();//está chamando o outro WebService de hr-worker
		
		// por enquanto iremos passar alguns dados mocado
		return new Payment(worker.getName(),worker.getDailyIncome(),days);
		
	}//Vai instaciar um obj do tipo pagamento apartir do workerId vai buscar no micro serviço o worker correspondente a esse id passado
	
}
