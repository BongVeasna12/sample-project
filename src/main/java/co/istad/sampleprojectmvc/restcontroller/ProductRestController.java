package co.istad.sampleprojectmvc.restcontroller;
import co.istad.sampleprojectmvc.dto.ProductRequest;
import co.istad.sampleprojectmvc.dto.ProductResponse;
import co.istad.sampleprojectmvc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductService productService;
    @GetMapping("/get-all")
    public Map<String , Object> getProduct(){
        HashMap<String ,Object> response = new HashMap<String , Object>();
        response.put("payload", productService.getAllProduct());
        response.put("message", "success");
        response.put("status", HttpStatus.OK.value());
        return  response;
    }
    @PostMapping("/new-product")
    public Map<String , Object> createNewProduct(@RequestBody ProductRequest request){
        HashMap<String ,Object> response = new HashMap<>();
      response.put("payload", productService.createProduct(request));
      response.put("message",  "Your have created a new product successfully!");
      response.put("status", HttpStatus.CREATED.value());
      return response;

    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map<String,Object>  findProductByID(@PathVariable int id){
        return null;
    }

}
