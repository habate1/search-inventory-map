package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InventoryMapApp {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);

        boolean searching = true;
        while (searching) {
            // call method and load the products from the file into the inventory
            HashMap<Integer, Product> inventory = loadInventory();
            // search by product id
            System.out.println("Enter product ID: ");
            int userId = myscanner.nextInt();
            // iterate through hashmap item by item and print values
            for (Product item : inventory.values()) {
                if (item.getId() == userId) {
                    System.out.printf("%d %s %.2f%n", item.getId(), item.getName(), item.getPrice());
                }
            }
            // prompt the user to search for an item. if not, they break the loop
            System.out.println("Do you want to search again? Enter yes or no: ");
            myscanner.nextLine();
            String userInput = myscanner.nextLine();
            // break loop
            if (userInput.equalsIgnoreCase("no")) {
                searching = false;
            }
        }

    }

    public static HashMap<Integer, Product> loadInventory() {
        HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();
        // read frm file
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            String line = bufReader.readLine();
            //String[] tokens = line.split("\\|");
            while (line != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);

                inventory.put(id, new Product(id, name, price));

                //System.out.println(line);
                //line.trim();
                line = bufReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return inventory;
    }
}
