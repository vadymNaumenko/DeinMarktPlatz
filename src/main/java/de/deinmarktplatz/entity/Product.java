package de.deinmarktplatz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", length = 30)
    private String title;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "product")
    private List<Image> image;

    private Double price;

    private String description;

    private LocalDateTime dateOfCreated;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", dateOfCreated=" + dateOfCreated +
                '}';
    }

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

}
