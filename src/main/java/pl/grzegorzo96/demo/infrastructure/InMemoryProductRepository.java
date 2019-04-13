package pl.grzegorzo96.demo.infrastructure;

import org.springframework.stereotype.Repository;
import pl.grzegorzo96.demo.domain.ImageDto;
import pl.grzegorzo96.demo.domain.PriceDto;
import pl.grzegorzo96.demo.domain.Product;
import pl.grzegorzo96.demo.domain.ProductNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(String id) {
        if(!products.containsKey(id)){
            throw new ProductNotFoundException("Nie ma takiego produktu!");
        }
        return products.get(id);
    }

    @Override
    public List<Product> getAll() {
        return List.copyOf(products.values());
    }

    @Override
    public Product update(Product product, String name, PriceDto price, ImageDto image) {
        if(!products.containsKey(product.getId())){
            throw new ProductNotFoundException("Nie ma takiego produktu!");
        }
        products.put(product.getId(), new Product(product.getId(), name, product.getCreatedAt(), price, image ));
        return products.get(product.getId());
    }

    @Override
    public void delete(String id) {
        if(!products.containsKey(id)) throw new ProductNotFoundException("Nie mozna usunac produktu!");
        products.remove(id);
    }
}
