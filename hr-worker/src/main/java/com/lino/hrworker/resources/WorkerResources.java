package com.lino.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lino.hrworker.model.entities.Worker;
import com.lino.hrworker.repositories.WorkerRepository;


@RestController
@RequestMapping("/workers")
public class WorkerResources {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

	@Autowired
	private Environment environment;
	
	
	private WorkerRepository repository;

	public WorkerResources(WorkerRepository repository) {//esta fazendo a injeção de depencia via construtor
		
		this.repository = repository;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> list = repository.findAll();//esta buscando todos e devolvendo para a lista 
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){

		/*try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		logger.info("porta = "+environment.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();//esta buscando todos e devolvendo o trabalhador conforme o id solicitado, como o findById devolve um optional ele faz essa requisição .get() 
		return ResponseEntity.ok().body(obj);
		
	}
	
}
