package com.lino.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lino.hrpayroll.model.entities.Worker;



@Component//estou falando que é componente gerenciado pelo spring
@FeignClient(name = "hr-worker",path ="/workers" )//vamos passar por enuanto o serviço que será consumido via hardcode
public interface WorkerFeignClients {

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id);
	
}
