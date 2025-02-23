import org.skypro.skyshop.basket.ProductBasket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
// Создаем товары
        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new SimpleProduct("Хлеб", 30);
        Product milk = new DiscountedProduct("Молоко", 80, 10);
        Product cheese = new FixPriceProduct("Сыр");
        Product juice = new DiscountedProduct("Сок", 100, 20);

        // Создаем статьи
        Article article1 = new Article("Как выбрать яблоки", "Советы по выбору свежих яблок.");
        Article article2 = new Article("Польза молока", "Почему молоко полезно для здоровья.");

        // Создаем поисковый движок
        SearchEngine searchEngine = new SearchEngine(10);

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
        Searchable[] results = searchEngine.search("яблоко");
        System.out.println(Arrays.toString(results));

        // Поиск по запросу "молоко"
        System.out.println("Результаты поиска по запросу 'молоко':");
        results = searchEngine.search("молоко");
        System.out.println(Arrays.toString(results));

        // Поиск по запросу "сыр"
        System.out.println("Результаты поиска по запросу 'сыр':");
        results = searchEngine.search("сыр");
        System.out.println(Arrays.toString(results));
    }
}

