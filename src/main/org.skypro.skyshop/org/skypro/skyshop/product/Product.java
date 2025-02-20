package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private String Name;
    private Integer Price;

    public Product(String productName, Integer productValue) {
        this.Name = productName;
        this.Price = productValue;
    }

    public String getName() {
        return Name;
    }

    public Integer getPrice() {
        return Price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(Name, product.Name) && Objects.equals(Price, product.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + Name + '\'' +
                ", productValue=" + Price +
                '}';
    }
}
