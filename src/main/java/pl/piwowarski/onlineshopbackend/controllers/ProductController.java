package pl.piwowarski.onlineshopbackend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.services.product.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductDto> getProductById(@PathVariable long productId) {
        GetProductDto product = productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetProductDto>> getAllProducts() {
        List<GetProductDto> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @GetMapping
    public ResponseEntity<List<GetProductDto>> getProductsByCategory(@RequestParam String category) {
        List<GetProductDto> productsByCategory = productService.getProductsByCategory(category);
        return ResponseEntity.ok(productsByCategory);
    }

}
