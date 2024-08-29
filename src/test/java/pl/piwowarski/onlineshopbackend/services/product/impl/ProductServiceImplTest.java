package pl.piwowarski.onlineshopbackend.services.product.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.entities.Product;
import pl.piwowarski.onlineshopbackend.exceptions.NoProductWithSuchIdException;
import pl.piwowarski.onlineshopbackend.mappers.ProductMapper;
import pl.piwowarski.onlineshopbackend.repositories.ProductRepository;
import pl.piwowarski.onlineshopbackend.services.product.ProductService;

import java.math.BigDecimal;
import java.util.Optional;

public class ProductServiceImplTest {

    private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
    private final ProductService productService = new ProductServiceImpl(productRepository);
    private final Product product = Product.builder()
            .id(1L)
            .name("Schar bread")
            .build();
    private final GetProductDto getProductDto = GetProductDto.builder()
            .id(1L)
            .name("Schar bread")
            .build();

    @Test
    void ifProductIsNotNullThenReturnsTrue() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        try(var mockStatic = Mockito.mockStatic(ProductMapper.class)) {
            mockStatic.when(() -> ProductMapper.map(product)).thenReturn(getProductDto);
            GetProductDto productById = productService.getProductById(1L);
            Assertions.assertNotNull(productById);
            Assertions.assertDoesNotThrow(() -> productService.getProductById(1L));
        }
    }
}
