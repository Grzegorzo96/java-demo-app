package pl.grzegorzo96.demo.domain;

import org.springframework.http.ResponseEntity;

public interface ProductFacade {

  // create
  // create(String name)
  ProductResponseDto create(ProductRequestDto productRequest);

  // update
  ProductResponseDto update(String id, ProductRequestDto productRequest);

  // delete
  ResponseEntity<Void> delete(String id);

  // get
  ProductResponseDto findById(String id);

  ProductsListResponseDto getAll();

  ProductsListResponseDto getAllByTag(String tag);
}
