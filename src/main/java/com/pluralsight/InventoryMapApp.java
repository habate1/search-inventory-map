package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryMapApp {
    public static void main(String[] args) {

        HashMap<Integer, String> inventory = new HashMap<Integer, String>();

    }

    public static void loadInventory() {
        HashMap<Integer, String> inventory = new HashMap<Integer, String>();
        inventory.put(1, "hammer");
        inventory.put(2, "nails");
        inventory.put(3, "wrench");
        inventory.put(4, "screws");
        inventory.put(5, "ruler");

    }
}
