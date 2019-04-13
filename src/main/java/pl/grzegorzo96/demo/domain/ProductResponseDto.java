package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductResponseDto {

    private final String id;
    private final String name;
    private final PriceDto price;
    private final ImageDto image;

    @JsonCreator
    public ProductResponseDto(@JsonProperty("id")String id,
                              @JsonProperty("name") String name,
                              @JsonProperty("price") PriceDto price,
                              @JsonProperty("image") ImageDto image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PriceDto getPrice() {
        return price;
    }

    public ImageDto getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
