package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable{
    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
        }
        this.name = name;
    }

    // Абстрактный метод для получения цены
    public abstract Integer getPrice();

    // Метод для проверки, является ли товар специальным
    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return getName(); // Поиск по имени товара
    }

    @Override
    public String getContentType() {
        return "PRODUCT"; // Тип контента — товар
    }

    @Override
    public String getName() {
        return name;
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
