package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    // Метод добавления продукта в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод получения общей стоимости корзины
    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    // Метод печати содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Метод проверки наличия продукта в корзине по имени
    public boolean containsProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    // Метод очистки корзины
    public void clearBasket() {
        products.clear();
    }

    // Метод удаления продукта по имени
    public List<Product> removeProductByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
