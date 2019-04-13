package pl.grzegorzo96.demo.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public final class Product {

    private final String id;
    private final String name;
    private final LocalDateTime createdAt;
    private final PriceDto price;
    private final ImageDto image;

    public Product(String id, String name, LocalDateTime createdAt, PriceDto price, ImageDto image) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.price = price;
        this.image = image;
    }


    public String getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;
    }

    public PriceDto getPrice() {
        return price;
    }

    public ImageDto getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(price, product.price)&&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createdAt, price, image);
    }
}
