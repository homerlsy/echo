package com.example.echo;

import java.util.List;

public interface PersonService {

	List<Person> getAll();

	Person getByName(String name);
}
