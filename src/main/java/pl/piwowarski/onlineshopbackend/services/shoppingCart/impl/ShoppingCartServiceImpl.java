package pl.piwowarski.onlineshopbackend.services.shoppingCart.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.onlineshopbackend.dtos.AddProductToShoppingCartDto;
import pl.piwowarski.onlineshopbackend.entities.Product;
import pl.piwowarski.onlineshopbackend.entities.ShoppingCart;
import pl.piwowarski.onlineshopbackend.exceptions.NoProductWithSuchIdException;
import pl.piwowarski.onlineshopbackend.repositories.ProductRepository;
import pl.piwowarski.onlineshopbackend.repositories.ShoppingCartRepository;
import pl.piwowarski.onlineshopbackend.services.shoppingCart.ShoppingCartService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Override
    public void addProductToShoppingCart(AddProductToShoppingCartDto addProductToShoppingCartDto) {
        Product product = productRepository.findById(addProductToShoppingCartDto.getShoppingItemId())
                .orElseThrow(NoProductWithSuchIdException::new);
        Optional<ShoppingCart> optionalCart = shoppingCartRepository.findBySessionId(addProductToShoppingCartDto.getSessionId());
        if(optionalCart.isEmpty()) {
            ShoppingCart newCart = ShoppingCart.builder()
                    .products(List.of(product))
                    .sessionId(addProductToShoppingCartDto.getSessionId())
                    .build();
            shoppingCartRepository.save(newCart);
        } else {
            ShoppingCart shoppingCart = optionalCart.get();
            List<Product> productsList = shoppingCart.getProducts();
            productsList.add(product);
            shoppingCart.setProducts(productsList);
            shoppingCartRepository.save(shoppingCart);
        }
    }
}
