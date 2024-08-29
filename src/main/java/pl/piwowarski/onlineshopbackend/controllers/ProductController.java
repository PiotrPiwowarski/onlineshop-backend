package pl.piwowarski.onlineshopbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.services.product.ProductService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product/")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductDto> getProductById(@PathVariable long productId) {
        GetProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

}
