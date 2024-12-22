package ru.gb;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.gb.model.User;
import ru.gb.repository.UserRepository;

import java.util.List;
import ru.gb.model.Person;
import ru.gb.repository.PersonRepository;

import java.util.Optional;

@SpringBootApplication
public class SpringDataDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);

		PersonRepository personRepository = context.getBean(PersonRepository.class);

		// Create a new Person
		Person person = new Person(null, "John", "Doe", 30);
		personRepository.save(person);

		// Read all Persons
		System.out.println("All persons:");
		personRepository.findAll().forEach(System.out::println);

		// Update an existing Person
		Optional<Person> optionalPerson = personRepository.findById(1L); // assuming there is a Person with ID 1
		if (optionalPerson.isPresent()) {
			Person updatedPerson = optionalPerson.get();
			updatedPerson.setFirstName("Jane");
			personRepository.save(updatedPerson);
		}

		// Delete a Person
		personRepository.deleteById(1L);

		// Verify deletion
		System.out.println("\nPersons after deletion:");
		personRepository.findAll().forEach(System.out::println);
	}
}
