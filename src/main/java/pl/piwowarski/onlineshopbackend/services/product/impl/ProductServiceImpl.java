package pl.piwowarski.onlineshopbackend.services.product.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.entities.Product;
import pl.piwowarski.onlineshopbackend.exceptions.NoProductWithSuchIdException;
import pl.piwowarski.onlineshopbackend.mappers.ProductMapper;
import pl.piwowarski.onlineshopbackend.repositories.ProductRepository;
import pl.piwowarski.onlineshopbackend.services.product.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public GetProductDto getProductById(long id) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(NoProductWithSuchIdException::new);
        return ProductMapper.map(product);
    }

    @Override
    public List<GetProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductMapper::map).toList();
    }
}
