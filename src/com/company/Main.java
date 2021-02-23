package com.company;

import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // creating test list
        Product product1 = new Product(22, "buttons", 12);
        Product product2 = new Product(10, "bags", 4);
        Product product3 = new Product(13, "bins", 8);
        Product product4 = new Product(19, "books", 10);

        List<Product> items1 = new ArrayList<>();
        items1.add(product1);
        items1.add(product2);
        items1.add(product3);
        items1.add(product4);

        // identical test list
        Product produc1 = new Product(22, "buttons", 12);
        Product produc2 = new Product(10, "bags", 4);
        Product produc3 = new Product(13, "bins", 8);
        Product produc4 = new Product(19, "books", 10);

        List<Product> items2 = new ArrayList<>();
        items2.add(produc1);
        items2.add(produc2);
        items2.add(produc3);
        items2.add(produc4);

        // print original list out here
        System.out.println("\nOriginal List:");
        for (Product product : items1) {
            System.out.println("Name: " + product.getName() + "   ID: " + product.getID() +
                    "   price: $" + product.getPrice());
        }

        // calling sorting proxy through interface - bubble sort
        System.out.println("\nBubble Sort List:");
        SortingIF sortingB = new SortingProxy();
        sortingB.sort(items1, 1);

        // calling sorting proxy through interface - quick sort
        System.out.println("\nQuick Sort List:");
        SortingIF sortingQ = new SortingProxy();
        sortingQ.sort(items2, 2);

    }
}
