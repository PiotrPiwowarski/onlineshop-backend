package pl.piwowarski.onlineshopbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.onlineshopbackend.dtos.AddProductToShoppingCartDto;
import pl.piwowarski.onlineshopbackend.dtos.GetShoppingCartDto;
import pl.piwowarski.onlineshopbackend.services.shoppingCart.ShoppingCartService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/shoppingCart")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping
    public ResponseEntity<Void> addProductToShoppingCart(@RequestBody AddProductToShoppingCartDto addProductToShoppingCartDto) {
        shoppingCartService.addProductToShoppingCart(addProductToShoppingCartDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<GetShoppingCartDto> getShoppingCart() {

        return ResponseEntity.ok(null);
    }
}
