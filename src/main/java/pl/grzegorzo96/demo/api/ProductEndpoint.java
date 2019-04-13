package pl.grzegorzo96.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.grzegorzo96.demo.domain.ProductFacade;
import pl.grzegorzo96.demo.domain.ProductRequestDto;
import pl.grzegorzo96.demo.domain.ProductResponseDto;
import pl.grzegorzo96.demo.domain.ProductsListResponseDto;

@RestController
@RequestMapping("/products")
class ProductEndpoint {

    private final ProductFacade productFacade;

    ProductEndpoint(ProductFacade productFacade){
        this.productFacade = productFacade;
    }

    @PostMapping
    ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productFacade.create(productRequestDto);
    }

    @GetMapping("/product-id-{id}") //method = RequestMethod.GET produces = MediaType.*/
    ProductResponseDto getProduct(@PathVariable("id") String id){
        return productFacade.findById(id);
    }

    @GetMapping
    ProductsListResponseDto getAllProducts(){
        return productFacade.getAll();
    }

    @PutMapping("/{id}")
    ProductResponseDto updateProduct(@PathVariable("id") String id, @RequestBody ProductRequestDto productRequestDto){
        return productFacade.update(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable("id") String id){
        return productFacade.delete(id);
    }
}
