package de.lindele.springbootapp.firstspringbootwebapp.repository;


import de.lindele.springbootapp.firstspringbootwebapp.jpa.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Long> {



}
