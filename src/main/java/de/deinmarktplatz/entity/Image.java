package de.deinmarktplatz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long size;
    private String type;
//    @Lob
//    private byte[] bytes;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    public Image() {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Image;
    }


    public String toString() {
        return "Image(id=" + this.getId() + ", name=" + this.getName() + ", size=" + this.getSize() + ", type=" + this.getType() + ", bytes=" + ", product=" + this.getProduct() + ")";
    }
}
