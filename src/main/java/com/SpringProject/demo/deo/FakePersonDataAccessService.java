package com.SpringProject.demo.deo;

import com.SpringProject.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDeo")
public class FakePersonDataAccessService implements PersonDeo{
 private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add( new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(Person ->Person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int delatePersonById(UUID id) {
        Optional<Person> personMayBe = selectPersonById(id);
        if (personMayBe.isEmpty()){
            return 0;
        }
        DB.remove(personMayBe.get());
        return 1;

    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id)
                .map(p->{
                    int indexOfPersonToDelate =DB.indexOf(person);
                    if (indexOfPersonToDelate >=0){
                        DB.set(indexOfPersonToDelate, person);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }




}
