package pl.grzegorzo96.demo.infrastructure;

import java.util.List;

import pl.grzegorzo96.demo.domain.*;

public interface ProductRepository {
  void save(Product product); // docelowo robimy ProductEntitiy

  Product findById(String id);

  List<Product> getAll();

  List<Product> getAllByTags(String tag);

  Product update(
      Product product,
      String name,
      PriceDto price,
      ImageDto image,
      DescriptionDto description,
      List<TagsDto> tags);

  void delete(String id);
}
