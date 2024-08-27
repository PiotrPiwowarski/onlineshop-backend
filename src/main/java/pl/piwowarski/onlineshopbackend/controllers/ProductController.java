package pl.piwowarski.onlineshopbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.entities.Product;
import pl.piwowarski.onlineshopbackend.services.product.ProductService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductDto> getProductById(@PathVariable long productId) {
        GetProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

}
