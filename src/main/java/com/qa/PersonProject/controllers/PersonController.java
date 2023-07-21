package com.qa.PersonProject.controllers;

import com.qa.PersonProject.dtos.PersonDTO;
import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.services.PersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        super();
        this.personService = personService;
    }

    @PostMapping("/create")
    public PersonDTO addPerson(@RequestBody @Valid Person person){
        return this.personService.addPerson(person);
    }

    @GetMapping("/getallpeople")
    public List<PersonDTO> getAllPeople(){
        return this.personService.getAllPeople();
    }

    @PutMapping("/update")
    public PersonDTO updatePerson(@PathParam("id") long id, @RequestBody @Valid Person person){
        return this.personService.updatePerson(id, person);
    }
    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable long id){
        return this.personService.removePerson(id);
    }

    @GetMapping("/test")
    public String test(){
        return "Testing 1, 2, 3.";
    }
}
