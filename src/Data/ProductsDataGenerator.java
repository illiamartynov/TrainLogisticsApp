package Data;

import Cargo.Products;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProductsDataGenerator {

    private static String[] products = {"salmon", "beef", "chicken", "pork", "apple", "orange", "banana", "pear", "carrot", "potato", "broccoli", "asparagus", "cheese", "yogurt", "milk", "butter", "bread", "rice", "pasta", "egg"};
    private static Map<String, String> foodTypes;

    public ProductsDataGenerator() {
        foodTypes = new HashMap<>();
        for (String product : products) {
            String type = getType(product);
            if (!foodTypes.containsKey(type)) {
                foodTypes.put(type, getTypeName(type));
            }
        }
    }

    public static Products generateProduct() {
        Random random = new Random();
        String product = products[random.nextInt(products.length)];
        String type = getType(product);
        return new Products(product, type);
    }

    private static String getType(String product) {
        if (product.equals("salmon")) {
            return "fish";
        } else if (product.equals("beef") || product.equals("chicken") || product.equals("pork")) {
            return "meat";
        } else if (product.equals("apple") || product.equals("orange") || product.equals("banana") || product.equals("pear")) {
            return "fruit";
        } else if (product.equals("carrot") || product.equals("potato") || product.equals("broccoli") || product.equals("asparagus")) {
            return "vegetable";
        } else if (product.equals("cheese") || product.equals("yogurt") || product.equals("milk") || product.equals("butter")) {
            return "dairy";
        } else if (product.equals("bread") || product.equals("rice") || product.equals("pasta")) {
            return "grain";
        } else if (product.equals("egg")) {
            return "protein";
        } else {
            return "unknown";
        }
    }

    private String getTypeName(String type) {
        switch (type) {
            case "fish":
                return "seafood";
            case "meat":
                return "meat";
            case "fruit":
                return "fruit";
            case "vegetable":
                return "vegetable";
            case "dairy":
                return "dairy";
            case "grain":
                return "grain";
            case "protein":
                return "protein";
            default:
                return "unknown";
        }
    }
}
