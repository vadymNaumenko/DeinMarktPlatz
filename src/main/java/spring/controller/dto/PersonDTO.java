package spring.controller.dto;

import lombok.*;
import spring.entity.City;
import spring.entity.Person;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;
    private String username;
    private List<City> city;

    public static PersonDTO getInstance(Person person){
        return new PersonDTO(person.getId(),person.getUsername(), person.getCitys());
    }

}
