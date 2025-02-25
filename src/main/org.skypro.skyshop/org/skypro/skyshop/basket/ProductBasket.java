package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsMap = new HashMap<>();

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    // Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    // Метод печати содержимого корзины
    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Метод проверки наличия продукта в корзине по имени
    public boolean containsProduct(String productName) {
        return productsMap.containsKey(productName);
    }

    // Метод очистки корзины
    public void clearBasket() {
        productsMap.clear();
    }

    // Метод удаления продукта по имени
    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : new ArrayList<>();
    }
}
