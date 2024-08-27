package pl.piwowarski.onlineshopbackend.mappers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.onlineshopbackend.dtos.GetProductDto;
import pl.piwowarski.onlineshopbackend.entities.Product;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductMapper {

    public static GetProductDto map(Product product) {
        return GetProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .productType(product.getProductType())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
