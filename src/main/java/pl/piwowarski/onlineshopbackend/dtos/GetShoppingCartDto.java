package pl.piwowarski.onlineshopbackend.dtos;

import lombok.*;
import pl.piwowarski.onlineshopbackend.entities.Product;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetShoppingCartDto {

    private Long id;
    private String sessionId;
    private List<Product> items;
}
