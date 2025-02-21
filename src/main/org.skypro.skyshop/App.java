import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создаем продукты
        Product apple = new SimpleProduct("Яблоко", 50);
        Product bread = new SimpleProduct("Хлеб", 30);
        Product milk = new DiscountedProduct("Молоко", 80, 10); // Скидка 10%
        Product cheese = new FixPriceProduct("Сыр"); // Фиксированная цена
        Product juice = new DiscountedProduct("Сок", 100, 20); // Скидка 20%

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(juice);

        // Печать содержимого корзины
        System.out.println("Содержимое корзины:");
        basket.printBasket();

        // Получение общей стоимости корзины
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        // Поиск товара, который есть в корзине
        System.out.println("Есть ли в корзине Хлеб? " + basket.containsProduct("Хлеб"));

        // Поиск товара, которого нет в корзине
        System.out.println("Есть ли в корзине Шоколад? " + basket.containsProduct("Шоколад"));

        // Очистка корзины
        basket.clearBasket();

        // Печать содержимого пустой корзины
        System.out.println("Содержимое корзины после очистки:");
        basket.printBasket();

        // Получение стоимости пустой корзины
        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());

        // Поиск товара по имени в пустой корзине
        System.out.println("Есть ли в корзине Яблоко? " + basket.containsProduct("Яблоко"));
    }
}

