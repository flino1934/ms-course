package com.lino.hruser.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lino.hruser.Repositories.UserRepository;
import com.lino.hruser.entities.User;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	//private static Logger logger = LoggerFactory.getLogger(UserResource.class);

//	@Value("${test.config}")
//	private String testeConfig;
//	
//	@Autowired
//	private Environment environment;
//	
	
	private UserRepository repository;

	
	
	public UserResource(UserRepository repository) {
		
		this.repository = repository;
	
	}

//	//vai pegar as configurações do servidor configurado no git
//	@GetMapping(value = "/configs")
//	public ResponseEntity<Void> getConfig(){
//		
//		logger.info("Config = "+testeConfig);
//		return ResponseEntity.noContent().build();
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<User>> findAll(){
//		
//		List<User> list = repository.findAll();//esta buscando todos e devolvendo para a lista 
//		return ResponseEntity.ok().body(list);
//		
//	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){

//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//logger.info("porta = "+environment.getProperty("local.server.port"));
		
		User obj = repository.findById(id).get();//esta buscando todos e devolvendo o trabalhador conforme o id solicitado, como o findById devolve um optional ele faz essa requisição .get() 
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		
		User obj = repository.findByEmail(email);//esta buscando todos e devolvendo o trabalhador conforme o id solicitado, como o findByEmail devolve um optional
		return ResponseEntity.ok().body(obj);
		
	}
	
}
