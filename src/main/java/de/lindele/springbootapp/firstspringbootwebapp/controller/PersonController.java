package de.lindele.springbootapp.firstspringbootwebapp.controller;

import de.lindele.springbootapp.firstspringbootwebapp.model.CreatePersonRessource;
import de.lindele.springbootapp.firstspringbootwebapp.model.Person;
import de.lindele.springbootapp.firstspringbootwebapp.services.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class PersonController {

    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> person(@RequestBody CreatePersonRessource res) {
        Person person = Person.builder()
                .age(res.age())
                .job(res.job())
                .name(res.name())
                .build();
        return ResponseEntity.ok( personService.savePerson(person));
    }

    @PostMapping("/person/remove{id}")
    public ResponseEntity<Person> removePersonbyID(@PathVariable(value = "id")long id){
        Person person = personService.deletePerson()

    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonByID(@PathVariable(value = "id") long id) {
        Person person = personService.getPersonbyID(id);
        return ResponseEntity.ok(person);
    }
}