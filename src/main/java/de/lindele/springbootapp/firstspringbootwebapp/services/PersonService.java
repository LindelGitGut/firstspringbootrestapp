package de.lindele.springbootapp.firstspringbootwebapp.services;


import de.lindele.springbootapp.firstspringbootwebapp.jpa.PersonEntity;
import de.lindele.springbootapp.firstspringbootwebapp.mapper.PersonMapper;
import de.lindele.springbootapp.firstspringbootwebapp.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import de.lindele.springbootapp.firstspringbootwebapp.repository.PersonRepository;


@Service
@Slf4j
public class PersonService {


    public PersonService(PersonRepository repo, PersonMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private final PersonRepository repo;
    private final PersonMapper mapper;


    public Person getPersonbyID(Long id) {
        System.out.println("getPersonbyID: Erhaltene ID lautet: " + id.toString());
        var personEntityOptional = repo.findById(id);

        if (personEntityOptional.isPresent()) {
            log.info("Person mit ID: " + personEntityOptional.get().getId() + " gefunden");

            return mapper.map(new PersonEntity(personEntityOptional.get().getId(),
                    personEntityOptional.get().getName(),
                    personEntityOptional.get().getAge(),
                    personEntityOptional.get().getJob()));
        } else throw new IllegalStateException();
    }

    public void updatePerson(Long id, Person person) {
        var personEntityOptional = repo.findById(id);
        if (personEntityOptional.isPresent()) {
            log.info("Updateperson: Person wurde gefunden!");
            PersonEntity oldpersonentity = personEntityOptional.get();
            oldpersonentity.toBuilder()
                    .name(person.getName())
                    .age(person.getAge())
                    .job(person.getJob());
            repo.save(oldpersonentity);
        } else throw new IllegalStateException();
    }

    public Boolean deletePerson(Long id, Person person) {
        var personEntityOptional = repo.findById(id);
        return true;
    }

    public Person savePerson(Person person) {
        var personEntity = repo.save(mapper.map(person));
        return mapper.map(personEntity);
    }
}