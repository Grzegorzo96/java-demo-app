package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// ignoruje nieznane wartosci
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private final String name;
    private final PriceDto price;

    @JsonCreator
    public ProductRequestDto(@JsonProperty("name") String name,
                             @JsonProperty("price") PriceDto price) {
        this.name = name;
        this.price = price;
    }

    public  boolean isValid(){
        return  name != null && !name.isBlank();
    }

    public String getName() {
        return name;
    }

    public PriceDto getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                '}';
    }
}
