package pl.grzegorzo96.demo.infrastructure;

import pl.grzegorzo96.demo.domain.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product); // docelowo robimy ProductEntitiy

    Product findById(String id);
    List<Product> getAll();

    Product update(Product product, String name);

    void delete(String id);
}
