package pl.grzegorzo96.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// ignoruje nieznane wartosci
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {
    private  final String name;

    @JsonCreator
    public ProductRequestDto(@JsonProperty("name") String name) {
        this.name = name;
    }

    public  boolean isValid(){
        return  name != null && !name.isBlank();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }


}