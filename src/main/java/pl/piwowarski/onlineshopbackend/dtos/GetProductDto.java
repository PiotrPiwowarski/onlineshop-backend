package pl.piwowarski.onlineshopbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.piwowarski.onlineshopbackend.enums.Category;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetProductDto {

    private long id;
    private String name;
    private Category category;
    private BigDecimal price;
    private String description;
}
