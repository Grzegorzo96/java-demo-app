package pl.grzegorzo96.demo.api;

import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import pl.grzegorzo96.demo.DemoApplicationTests;
import pl.grzegorzo96.demo.domain.*;

public class ProductEndPointTest extends DemoApplicationTests {
  @Autowired ProductFacade productFacade;

  @Test
  public void shouldGetNotExistingProducts() {
    final String url = "http://localhost:" + port + "/products/" + "product-id-123";
    ResponseEntity<ProductResponseDto> result =
        httpClient.getForEntity(url, ProductResponseDto.class);
    assertThat(result.getStatusCodeValue()).isEqualTo(404);
  }
  //
  //    @Test
  //    public void shouldGetExistingProducts(){
  //        //given
  //        PriceDto priceDto = new PriceDto(15.00, "cos");
  //        ProductRequestDto requestdto = new ProductRequestDto("product", priceDto);
  //        ProductResponseDto existingProduct = productFacade.create(requestdto);
  //        final String url = "http://localhost:" + port + "/products/" + "product-id-"
  // +existingProduct.getId();
  //        //when
  //        ResponseEntity<ProductResponseDto> result = httpClient.getForEntity(url,
  // ProductResponseDto.class);
  //        //ten
  //        assertThat(result.getStatusCodeValue()).isEqualTo(200);
  //        assertThat(result.getBody()).isEqualToComparingOnlyGivenFields(existingProduct);
  //    }
  //
  //    @Test
  //    public void shouldGetExistingListProducts(){
  //        //given
  //        PriceDto priceDto = new PriceDto(25.00, "cos");
  //        ProductRequestDto requestdto = new ProductRequestDto("product", priceDto);
  //        productFacade.create(requestdto);
  //
  //        ProductRequestDto requestdto2 = new ProductRequestDto("product2", priceDto);
  //        productFacade.create(requestdto2);
  //
  //        final String url = "http://localhost:" + port + "/products";
  //        //when
  //        ResponseEntity<ProductsListResponseDto> result = httpClient.getForEntity(url,
  // ProductsListResponseDto.class);
  //        //then
  //        ProductsListResponseDto products = result.getBody();
  //
  //        assertThat(result.getStatusCodeValue()).isEqualTo(200);
  //    //    assertThat(products.getProducts().size()).isEqualTo(2);
  //        assertThat(products.getProducts().contains(requestdto));
  //        assertThat(products.getProducts().contains(requestdto2));
  //
  //  //
  // assertThat(products.getProducts().get(0).getName()).isEqualTo(productFacade.getAll().getProducts().get(0).getName());
  //  //
  // assertThat(products.getProducts().get(1).getName()).isEqualTo(productFacade.getAll().getProducts().get(1).getName());
  //    }
  //
  //    @Test
  //    public void shouldCreateProduct(){
  //        //given
  //        PriceDto priceDto = new PriceDto(15.00, "cos");
  //        final String url = "http://localhost:" + port + "/products"; //dana
  //        final ProductRequestDto product = new ProductRequestDto("iphone", priceDto);
  //        String productJson = mapToJson(product);
  //        //when
  //        ResponseEntity<ProductResponseDto> result = httpClient.postForEntity(url
  //        , getHttpRequest(productJson), ProductResponseDto.class);
  //        //then
  //        assertThat(result.getStatusCodeValue()).isEqualTo(200);
  //        assertThat(result.getBody().getName()).isEqualTo("iphone");
  //    }
  //
  //    @Test
  //    public void shouldUpdateProduct(){
  //        //given
  //        PriceDto priceDto = new PriceDto(15.00, "cos");
  //        ProductRequestDto requestDto = new ProductRequestDto("product", priceDto);
  //        ProductResponseDto existingProduct = productFacade.create(requestDto);
  //
  //        final String url = "http://localhost:"+ port + "/products/" + existingProduct.getId();
  //
  //        ProductRequestDto updatedProduct = new ProductRequestDto("Product is updated",
  // priceDto);
  //
  //        String productJson = mapToJson(updatedProduct);
  //
  //        //when
  //        ResponseEntity<ProductResponseDto> result = httpClient.exchange(url, HttpMethod.PUT,
  // getHttpRequest(productJson), ProductResponseDto.class);
  //
  //        //then
  //        assertThat(result.getStatusCodeValue()).isEqualTo(200);
  //        assertThat(result.getBody().getId()).isEqualTo(existingProduct.getId());
  //        assertThat(result.getBody().getName()).isEqualTo(updatedProduct.getName());
  //        assertThat(result.getBody().getName()).isEqualTo(updatedProduct.getPrice());
  //    }
  //
  //    @Test
  //    public void shouldDeleteProduct(){
  //        PriceDto priceDto = new PriceDto(15.00, "cos");
  //        ProductRequestDto requestDto = new ProductRequestDto("product", priceDto);
  //        ProductResponseDto existingProduct = productFacade.create(requestDto);
  //
  //        final String url = "http://localhost:" + port + "/products/" + existingProduct.getId();
  //
  //        //when
  //        ResponseEntity<Void> result = httpClient
  //                .exchange(url, HttpMethod.DELETE, HttpEntity.EMPTY, Void.class);
  //
  //        assertThat(result.getStatusCodeValue()).isEqualTo(204);
  //    }

  // robimy metode po to, zeby wygluszyc wyjatek
  String mapToJson(ProductRequestDto productRequestDto) {
    try {
      return objectMapper.writeValueAsString(productRequestDto);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e); // zobaczymy wyjatek na konsoli
      // e.printStackTrace(); //najgorsze rozwiazanie - usuniecie tego i dacie pustego resulta
      // (string)
    }
  }

  private HttpEntity<String> getHttpRequest(String json) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set("content-type", "application/json");
    return new HttpEntity<>(json, httpHeaders);
  }
}
