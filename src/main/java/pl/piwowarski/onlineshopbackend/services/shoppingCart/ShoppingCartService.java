package pl.piwowarski.onlineshopbackend.services.shoppingCart;

import org.springframework.stereotype.Service;
import pl.piwowarski.onlineshopbackend.dtos.AddProductToShoppingCartDto;

@Service
public interface ShoppingCartService {

    void addProductToShoppingCart(AddProductToShoppingCartDto addProductToShoppingCartDto);
}
