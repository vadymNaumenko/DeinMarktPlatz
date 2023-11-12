package spring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String username;

    @OneToMany(mappedBy = "person")
    @JoinColumn(name = "city_id")
    private List<City> citys = new ArrayList<>();

    public Person(String username, List<City> citys) {
        this.username = username;
        this.citys = citys;
    }
}
