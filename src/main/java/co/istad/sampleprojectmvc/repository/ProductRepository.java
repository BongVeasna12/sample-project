package co.istad.sampleprojectmvc.repository;

import co.istad.sampleprojectmvc.model.Product;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Repository
@Getter
public class ProductRepository {
     private final List<Product> allProducts = new ArrayList<Product>(){{
         add(Product.builder()
                 .id(1)
                 .title("sting")
                 .description("sting is the best product")
                 .price(4.3f)
                 .imageUrl("sting.jpg")
                 .build());
         add(Product.builder()
                 .id(2)
                 .title("Worst")
                 .description("worst is the best product")
                 .price(4.3f)
                 .imageUrl("worst.jpg")
                 .build());
         add(Product.builder()
                 .id(3)
                 .title("coca")
                 .description("coca is the best product")
                 .price(4.3f)
                 .imageUrl("coca.jpg")
                 .build());
     }};

    public void addProduct(Product product){
         allProducts.add(product);
    }

}
