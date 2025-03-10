package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private Integer basePrice;
    private Integer discountPercent;

    public DiscountedProduct(String name, Integer basePrice, Integer discountPercent) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть строго больше 0.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно.");
        }

        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public Integer getPrice() {
        return basePrice * (100 - discountPercent) / 100;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар со скидкой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return Objects.equals(basePrice, that.basePrice) && Objects.equals(discountPercent, that.discountPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discountPercent);
    }
}
