package pl.piwowarski.onlineshopbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AddProductToShoppingCartDto {
    private long shoppingItemId;
    private String sessionId;
}
