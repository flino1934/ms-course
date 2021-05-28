package com.lino.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.lino.hrpayroll.model.entities.Payment;

@Service//esta anotando como um componente de serviço do spring
public class PaymentService {

	public Payment getPayment(Long workerId,int days) {//vai instaciar um pagamento
		
		//por enquanto iremos passar alguns dados mocado
		return new Payment("Bob",200.0,days);
		
	}//Vai instaciar um obj do tipo pagamento apartir do workerId vai buscar no micro serviço o worker correspondente a esse id passado
	
}
