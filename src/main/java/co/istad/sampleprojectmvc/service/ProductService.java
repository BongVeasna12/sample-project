package co.istad.sampleprojectmvc.service;

import co.istad.sampleprojectmvc.dto.ProductRequest;
import co.istad.sampleprojectmvc.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse createProduct(ProductRequest productRequest);
    void deletedProduct(int productId);
    void updateProduct(ProductRequest productRequest);

    Object findProductByID(int id);

}

