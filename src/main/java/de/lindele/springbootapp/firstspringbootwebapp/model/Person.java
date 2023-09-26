package de.lindele.springbootapp.firstspringbootwebapp.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Builder // ermöglicht es schnell eine Person in folgendem Format zu erstellen
// Person.builder()
//                        .age(value)
//                        .job(value)
//                        .name(value)

@Getter
@Setter
public class Person {
    public Person(long id, String name, int age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }
    long id;
    String name;
    int age;
    String job;
}


