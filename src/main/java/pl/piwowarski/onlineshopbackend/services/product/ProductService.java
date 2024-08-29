package pl.piwowarski.onlineshopbackend.services.product;

import org.springframework.stereotype.Service;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;

import java.util.List;

@Service
public interface ProductService {

    GetProductDto getProductById(long id);
    List<GetProductDto> getAllProducts();
}
