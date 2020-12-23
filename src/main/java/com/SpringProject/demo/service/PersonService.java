package com.SpringProject.demo.service;

import com.SpringProject.demo.deo.PersonDeo;
import com.SpringProject.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDeo personDeo;
     @Autowired
    public PersonService( @Qualifier ("postgres") PersonDeo personDeo) {
        this.personDeo = personDeo;

    }

    public int addPerson(Person person) {
        return personDeo.insertPerson(person);
    }

    public List<Person>getAllpeople(){
         return personDeo.selectAllPeople();
    }
    public Optional<Person>getPersonById(UUID id){
         return personDeo.selectPersonById(id);
    }

    public int delatePerson(UUID id){
         return personDeo.delatePersonById(id);

    }
    public int updatePerson(UUID id,Person newperson){
         return personDeo.updatePersonById(id,newperson);
    }

}
