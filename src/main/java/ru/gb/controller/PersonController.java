package ru.gb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.model.Person;
import ru.gb.repository.PersonRepository;

@Controller
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @PostMapping("/add-person")
    public String addPerson(@RequestParam String firstName,
                            @RequestParam String lastName,
                            @RequestParam Integer age,
                            Model model) {
        Person person = new Person(null, firstName, lastName, age);
        personRepository.save(person);
        model.addAttribute("message", "Новый читатель добавлен!");
        return "redirect:/";
    }
}
