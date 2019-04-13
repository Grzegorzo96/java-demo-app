package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// ignoruje nieznane wartosci
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private final String name;
    private final PriceDto price;
    private final ImageDto image;

    @JsonCreator
    public ProductRequestDto(@JsonProperty("name") String name,
                             @JsonProperty("price") PriceDto price,
                             @JsonProperty("image") ImageDto image) {
        this.name = name;
        this.price = price;
        this.image = image;
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

    public ImageDto getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                "price='" + price + '\'' +
                "image='" + image + '\'' +
                '}';
    }
}
