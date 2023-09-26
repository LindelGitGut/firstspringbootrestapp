package de.lindele.springbootapp.firstspringbootwebapp.mapper;


import de.lindele.springbootapp.firstspringbootwebapp.jpa.PersonEntity;
import de.lindele.springbootapp.firstspringbootwebapp.model.Person;
import org.springframework.stereotype.Component;

@Component // Springboot erkennt dadurch die Klasse als Bean


public class PersonMapper {



    public Person map(PersonEntity personEntity){
        Person newperson = Person.builder()
                .job(personEntity.getJob())
                .name(personEntity.getName())
                .age(personEntity.getAge())
                .id(personEntity.getId()).build();
        return  newperson;
    }

    public PersonEntity map(Person person){
        return PersonEntity.builder()
                .job(person.getJob())
                .name(person.getName())
                .age(person.getAge())
                .id(person.getId())
                .build();
    }

}
