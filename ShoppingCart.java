/**
 11.create a shopping cart program(Using HashMap with product name and price as key value pair)Process the map with Stream
 1. add product
 2.remove product
 3.get all products
 4.find the total price of all products purchased
 5.Find product with its price value
 6.Find the price value of a product
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ShoppingCart {
    Map<String, Double> cart = new HashMap<>();
    public void addProduct(String name, double price) {
        cart.put(name, price);
    }
    public void removeProduct(String name) {
        cart.remove(name);
    }
    public void getAllProducts() {
        cart.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " : Price:" + entry.getValue()));
    }
    public double getTotalPrice() {
        return cart.values().stream().mapToDouble(Double::doubleValue).sum();
    }
    public void findProductAndPrice(String name) {
        cart.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(name)).forEach(entry -> System.out.println("Item: " + entry.getKey() + ", price: " + entry.getValue()));
    }

    public Optional<Double> getPriceOfProduct(String name) {
        return cart.entrySet().stream().filter(entry -> entry.getKey().equalsIgnoreCase(name)).map(Map.Entry::getValue).findFirst();
    }

    public static void main(String[] args) {
        ShoppingCart myCart = new ShoppingCart();
        myCart.addProduct("TV", 24000.00);
        myCart.addProduct("Juicer", 5000.00);
        myCart.addProduct("Saree", 2000.00);
        myCart.addProduct("Mobile", 35000.00);
        myCart.getAllProducts();
        System.out.println();
        System.out.println("Total Price: Rs." + myCart.getTotalPrice());
        System.out.print("\n");
        myCart.findProductAndPrice("Mobile");
        System.out.print("\n");
        String searchProduct = "Juicer";
        System.out.println("Price of " + searchProduct + ": Rs." + myCart.getPriceOfProduct(searchProduct).orElse(0.00));
        System.out.print("\n");
        myCart.removeProduct("Saree");
        System.out.println("New Total Price: Rs." + myCart.getTotalPrice());
    }
}
