package com.example.echo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ApiController {

	private final PersonService personService;

	@Autowired
	public ApiController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping("/persons")
	public Flux<Person> allPerson(){
		return Flux.fromIterable(personService.getAll());
	}

	@GetMapping("/person")
	public Mono<Person> getPersonByName(@RequestParam("name") String name){
		return Mono.just(personService.getByName(name));
	}

}
