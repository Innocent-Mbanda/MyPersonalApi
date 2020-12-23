package com.SpringProject.demo.api;

import com.SpringProject.demo.model.Person;
import com.SpringProject.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
@Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping()
    public void addPerson( @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person>getAllPeople(){
    return personService.getAllpeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById( @PathVariable ("id") UUID id){
    return personService.getPersonById(id)
            .orElse(null);

    }
    @DeleteMapping(path = "{id}")
    public void delatePerson(@PathVariable("{id}") UUID id){
    personService.delatePerson(id);
    }
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable UUID id, @RequestBody Person persontoUpdate){
    personService.updatePerson(id,persontoUpdate);
    }
}
