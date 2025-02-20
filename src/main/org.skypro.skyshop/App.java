import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создаем продукты
        Product apple = new Product("Яблоко", 50);
        Product bread = new Product("Хлеб", 30);
        Product milk = new Product("Молоко", 80);
        Product cheese = new Product("Сыр", 120);
        Product juice = new Product("Сок", 100);
        Product chocolate = new Product("Шоколад", 70);

        // Создаем корзину
        ProductBasket basket = new ProductBasket();

        // Добавляем продукты в корзину
        basket.addProduct(apple);
        basket.addProduct(bread);
        basket.addProduct(milk);
        basket.addProduct(cheese);
        basket.addProduct(juice);

        // Попытка добавить продукт в заполненную корзину
        basket.addProduct(chocolate); // Выведет "Невозможно добавить продукт"

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

