package com.qa.PersonProject.services;

import com.qa.PersonProject.Exceptions.PersonNotFoundException;
import com.qa.PersonProject.dtos.PersonDTO;
import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
//    private List<Person> people = new ArrayList<>();
    private PersonRepository personRepository;
    private ModelMapper mapper;

    public PersonService(PersonRepository personRepository, ModelMapper mapper) {
        super();
        this.personRepository = personRepository;
        this.mapper = mapper;
    }

    private PersonDTO mapToDTO(Person person){
        return this.mapper.map(person, PersonDTO.class);
    }

    public PersonDTO addPerson(Person person){
//        this.people.add(person);
//        return this.people.get(this.people.size() -1);
//        return this.personRepository.save(person);
        Person saved = this.personRepository.save(person);
        return mapToDTO(person);

    }

    public List<PersonDTO> getAllPeople(){
//        return this.people;
//        return this.personRepository.findAll();
        return this.personRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PersonDTO updatePerson(long id, Person person){
//        this.people.remove(id);
//        this.people.add(id, person);
//        return this.people.get(id);
        Optional<Person> existingOptional = this.personRepository.findById(id);
        if(!existingOptional.isPresent())
            throw new PersonNotFoundException();
        Person existing = existingOptional.get();
        existing.setAge(person.getAge());
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        Person saved = this.personRepository.save(existing);
        return this.mapToDTO(saved);
    }

    public boolean removePerson(long id){
//        return this.people.remove(id);
        this.personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
        this.personRepository.deleteById(id);
        boolean exists = this.personRepository.existsById(id);
        return !exists;
    }
}
