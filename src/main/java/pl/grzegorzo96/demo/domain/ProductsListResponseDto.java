package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class ProductsListResponseDto {
  private final List<ProductResponseDto> products; // typ nie moze byc Product, bo wycieka domena!

  @JsonCreator
  public ProductsListResponseDto(@JsonProperty("products") List<ProductResponseDto> productsList) {
    this.products = productsList;
  }

  public List<ProductResponseDto> getProducts() {
    return products;
  }
}
