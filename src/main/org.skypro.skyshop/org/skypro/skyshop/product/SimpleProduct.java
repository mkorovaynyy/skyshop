package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {
    private Integer price;

    public SimpleProduct(String name, Integer price) {
        super(name);
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false; // Обычный товар не является специальным
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return "SimpleProduct{" +
                "name=" + this.getName() +
                "price=" + price +
                '}';
    }
}
