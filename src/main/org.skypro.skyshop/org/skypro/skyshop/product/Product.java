package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String name;


    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract Integer getPrice();

    // Метод для проверки, является ли товар специальным
    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
