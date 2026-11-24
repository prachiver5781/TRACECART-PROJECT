package com.tracecart.app;

import java.util.Scanner;
import com.tracecart.db.Schema;
import com.tracecart.service.ProductService;
import com.tracecart.service.InventoryService;

public class VanshikaMain {
    public static void main(String[] args) {
        try {
            Schema.create();
            ProductService products = new ProductService();
            InventoryService inventory = new InventoryService();
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n===== VANSHIKA: PRODUCT & INVENTORY MODULE =====");
                System.out.println("1. View products");
                System.out.println("2. Add product");
                System.out.println("3. View inventory batches");
                System.out.println("4. Add inventory batch");
                System.out.println("5. Restock batch");
                System.out.println("0. Exit");
                System.out.print("Choose: ");
                String choice = sc.nextLine().trim();
                try {
                    switch (choice) {
                        case "1" -> products.list().forEach(System.out::println);
                        case "2" -> {
                            System.out.print("Product name: "); String name = sc.nextLine();
                            System.out.print("Category: "); String category = sc.nextLine();
                            System.out.print("Price: "); double price = Double.parseDouble(sc.nextLine());
                            products.add(name, category, price);
                            System.out.println("Product added successfully.");
                        }
                        case "3" -> inventory.list().forEach(System.out::println);
                        case "4" -> {
                            System.out.print("Product ID: "); int productId = Integer.parseInt(sc.nextLine());
                            System.out.print("Batch code: "); String code = sc.nextLine();
                            System.out.print("Quantity: "); int qty = Integer.parseInt(sc.nextLine());
                            inventory.add(productId, code, qty);
                            System.out.println("Batch added successfully.");
                        }
                        case "5" -> {
                            System.out.print("Batch ID: "); int id = Integer.parseInt(sc.nextLine());
                            System.out.print("Quantity to add: "); int qty = Integer.parseInt(sc.nextLine());
                            inventory.restock(id, qty);
                            System.out.println("Stock updated successfully.");
                        }
                        case "0" -> { System.out.println("Exiting Vanshika module."); return; }
                        default -> System.out.println("Invalid option.");
                    }
                } catch (Exception e) {
                    System.out.println("Operation failed: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Could not start Vanshika module: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
