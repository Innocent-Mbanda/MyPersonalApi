package com.SpringProject.demo.deo;


import com.SpringProject.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDeo {

    int insertPerson(UUID id, Person person);

   default int insertPerson( Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
   }
    List<Person> selectAllPeople();
   Optional<Person> selectPersonById(UUID id);
   int delatePersonById( UUID id);
   int updatePersonById(UUID id,Person person);
}

