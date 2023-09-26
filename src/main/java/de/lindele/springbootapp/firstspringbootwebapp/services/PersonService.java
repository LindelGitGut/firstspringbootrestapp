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
    //TODO herausfinden warum ID trotz angabe der ID ein Eintrag mit neuer ID generiert wird.
    public Person updatePersonByID(Long id, Person person) {
        log.info("Erhaltene ID lautet: "+id);
        var personEntityOptional = repo.findById(id);
        if (personEntityOptional.isPresent()) {
            log.info("Updateperson: Person wurde gefunden!");
            PersonEntity oldpersonentity = personEntityOptional.get();
            person.setId(id);
            repo.deleteById(id);
            var newPersonEntity = repo.save(mapper.map(person));
            return mapper.map(newPersonEntity);
        } else throw new IllegalStateException();
    }

    public void deletePerson(Long id) {
        var personEntityOptional = repo.findById(id);
        if (personEntityOptional.isPresent()){
            repo.delete(personEntityOptional.get());
        }
        else throw new IllegalStateException();
    }

    public Person savePerson(Person person) {
        var personEntity = repo.save(mapper.map(person));
        return mapper.map(personEntity);
    }
}