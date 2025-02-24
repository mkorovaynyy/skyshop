import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.List;


public class App {
    public static void main(String[] args) {
        try {
            Product apple = new SimpleProduct("Яблоко", 50);
            Product bread = new SimpleProduct("Хлеб", 30);
            Product milk = new DiscountedProduct("Молоко", 80, 10);
            Product cheese = new FixPriceProduct("Сыр");
            Product juice = new DiscountedProduct("Сок", 100, 20);

            // Создаем статьи
            Article article1 = new Article("Как выбрать яблоки", "Советы по выбору свежих яблок.");
            Article article2 = new Article("Польза молока", "Почему молоко полезно для здоровья.");

            // Создаем поисковый движок
            SearchEngine searchEngine = new SearchEngine();

            // Добавляем товары и статьи в поисковый движок
            searchEngine.add(apple);
            searchEngine.add(bread);
            searchEngine.add(milk);
            searchEngine.add(cheese);
            searchEngine.add(juice);
            searchEngine.add(article1);
            searchEngine.add(article2);

            // Поиск по запросу "яблоко"
            System.out.println("Результаты поиска по запросу 'яблоко':");
            List<Searchable> results = searchEngine.search("яблоко");
            results.forEach(result -> System.out.println(result.getStringRepresentation()));

            // Поиск по запросу "молоко"
            System.out.println("Результаты поиска по запросу 'молоко':");
            results = searchEngine.search("молоко");
            results.forEach(result -> System.out.println(result.getStringRepresentation()));

            // Поиск по запросу "сыр"
            System.out.println("Результаты поиска по запросу 'сыр':");
            results = searchEngine.search("сыр");
            results.forEach(result -> System.out.println(result.getStringRepresentation()));

            // Поиск лучшего результата
            try {
                Searchable bestMatch = searchEngine.findBestMatch("яблоко");
                System.out.println("Лучший результат для 'яблоко': " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            try {
                Searchable bestMatch = searchEngine.findBestMatch("несуществующий запрос");
                System.out.println("Лучший результат для 'несуществующий запрос': " + bestMatch.getStringRepresentation());
            } catch (BestResultNotFound e) {
                System.out.println(e.getMessage());
            }

            // Создаем корзину
            ProductBasket basket = new ProductBasket();

            // Добавляем продукты в корзину
            basket.addProduct(apple);
            basket.addProduct(bread);
            basket.addProduct(milk);
            basket.addProduct(cheese);
            basket.addProduct(juice);

            // Удаляем существующий продукт
            System.out.println("Удаляем продукт 'Хлеб':");
            List<Product> removedProducts = basket.removeProductByName("Хлеб");
            removedProducts.forEach(product -> System.out.println(product.getName() + " удален"));
            basket.printBasket();

            // Удаляем несуществующий продукт
            System.out.println("Удаляем продукт 'Шоколад':");
            removedProducts = basket.removeProductByName("Шоколад");
            if (removedProducts.isEmpty()) {
                System.out.println("Список пуст");
            }
            basket.printBasket();

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }
    }
}

