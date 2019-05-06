package pl.grzegorzo96.demo.infrastructure;

import org.springframework.stereotype.Repository;
import pl.grzegorzo96.demo.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
    public List<Product> getAllByTags(String tag) {
        return products.values()
                .stream()
                .filter(p -> p.getTags() != null)
                .filter(p -> p.getTags().contains(new TagsDto(tag)))
                .collect(Collectors.toList());
    }

    @Override
    public Product update(Product product, String name, PriceDto price, ImageDto image, DescriptionDto description, List<TagsDto> tags) {
        if(!products.containsKey(product.getId())){
            throw new ProductNotFoundException("Nie ma takiego produktu!");
        }
        products.put(product.getId(), new Product(product.getId(), name, product.getCreatedAt(), price, image, description, tags));
        return products.get(product.getId());
    }

    @Override
    public void delete(String id) {
        if(!products.containsKey(id)) throw new ProductNotFoundException("Nie mozna usunac produktu!");
        products.remove(id);
    }
}
