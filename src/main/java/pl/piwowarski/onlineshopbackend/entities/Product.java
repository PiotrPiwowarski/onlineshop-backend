package pl.piwowarski.onlineshopbackend.entities;

import jakarta.persistence.*;
import lombok.*;
import pl.piwowarski.onlineshopbackend.enums.ProductType;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ProductType productType;
    private BigDecimal price;
    private String description;
}
