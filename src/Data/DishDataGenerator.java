package Data;

import Cargo.Dish;

import java.util.Random;

public class DishDataGenerator {
    private static final String[] DISH_NAMES = {"Pelmeni", "Borsh", "Vareniki", "Salmon", "Steak", "Chicken curry", "Meat balls", "Pizza", "Burger", "Pasta", "Salad", "Soup"};

    private static final Random random = new Random();

    public static Dish generateDish() {
        String name = DISH_NAMES[random.nextInt(DISH_NAMES.length)];
        return new Dish(name);
    }
}