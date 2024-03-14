package com.example.echo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultPersonService implements PersonService{

	private final List<Person> store = List.of(
		new Person("John", 30),
		new Person("Jane", 25),
		new Person("Doe", 40)
	);
	@Override
	public List<Person> getAll() {
		return this.store;
	}

	@Override
	public Person getByName(String name) {
		return this.store.stream()
			.filter(person -> person.name().equals(name))
			.findFirst()
			.orElseThrow();
	}
}
