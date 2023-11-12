package spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.controller.dto.PersonDTO;
import spring.entity.City;
import spring.entity.Person;
import spring.repository.CityRepository;
import spring.repository.PersonRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CityRepository cityRepository;

    public List<PersonDTO> findAll() {

        return personRepository.findAll()
                .stream()
                .map(PersonDTO::getInstance)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id).orElse(null);

        if (person != null)
            return new PersonDTO(person.getId(), person.getUsername(),person.getCitys()); //TODO

        return null;
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public PersonDTO addPerson(PersonDTO person) {
        City city = cityRepository.findByName("berlin"); //TODO

        if (city != null) {
        return PersonDTO.getInstance(personRepository.save(new Person(person.getUsername(),new ArrayList<>(Collections.singleton(city)))));
        }

        return null;
    }

    public PersonDTO editePerson(PersonDTO person) {
        City city = cityRepository.findByName("berlin"); //TODO

        Person editePerson = personRepository.findById(person.getId()).orElse(null);
        if (editePerson != null) {
            editePerson.setUsername(person.getUsername());
          //  editePerson.setCitys(new ArrayList<>(city)); //TODO
            personRepository.save(editePerson);
            return person;
        }
        return null;
    }


}
