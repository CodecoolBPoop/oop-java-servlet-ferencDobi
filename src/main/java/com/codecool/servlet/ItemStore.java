package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static List<Item> items = new ArrayList<>();

    static void add(Item item) {
        items.add(item);
    }

    static void remove(Item item) {
        items.remove(item);
    }

    static List<Item> getItems() {
        return items;
    }

    static Item get(int index) {
        return items.get(index);
    }

    static int size() {
        return items.size();
    }

    /*
    contains a static List (ArrayList or LinkedList) of Items.
    It should provide static functions as well, like add and remove.
    The business logic is not that important, adding multiple Items with the same id is valid use case.

    Pro version: store it in a session instead of a static list!
     */
}
