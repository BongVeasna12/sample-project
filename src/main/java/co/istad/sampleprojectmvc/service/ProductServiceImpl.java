package co.istad.sampleprojectmvc.service;
import co.istad.sampleprojectmvc.dto.ProductRequest;
import co.istad.sampleprojectmvc.dto.ProductResponse;
import co.istad.sampleprojectmvc.model.Product;
import co.istad.sampleprojectmvc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public List<ProductResponse> getAllProduct() {
        List<ProductResponse> response = new ArrayList<>();
        return  productRepository.getAllProducts().stream().map(pro ->{
            return ProductResponse.builder()
                  .id(pro.getId())
                  .title(pro.getTitle())
                  .description(pro.getDescription())
                  .price(pro.getPrice())
                  .imageUrl(pro.getImageUrl())
                  .build();
                }).toList();
    }
    @Override
    public ProductResponse createProduct(ProductRequest request) {
          Product newProduct = Product.builder()
                .title(request.title())
                .description(request.description())
                .price(request.price())
                .imageUrl(request.imageUrl())
                .build();

          var maxID = productRepository.getAllProducts().stream()
                  .max(Comparator.comparingInt(Product::getId ))
                  .map(Product::getId );

          int newID = 1;
          if (maxID.isPresent()) {
              newID = maxID.get() + 1;
          }
          newProduct.setId(newID);
          productRepository.addProduct(newProduct);
        return mapProductToResponse(newProduct);
    }

    private ProductResponse mapProductToResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }

    @Override
    public void deletedProduct(int productId) {
        
    }

    @Override
    public void updateProduct(ProductRequest productRequest) {
    }
}
