package com.lino.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lino.hrpayroll.model.entities.Payment;
import com.lino.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResources {

	private PaymentService service;
	
	public PaymentResources(PaymentService service) {
		
		this.service = service;
	
	}//estamos fazendo a injeção de dependencia através do construtor
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value = "/{workerId}/days/{days}")// id do worker(workerId) depois a palavra days e o parametro que tem o numero de dias
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(payment);
	}
	
	
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId,Integer days) {
		Payment payment = new Payment("Brann",400.0,days);
		return ResponseEntity.ok().body(payment);
	}


}
