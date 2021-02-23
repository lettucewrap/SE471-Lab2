package com.company;

import java.util.List;

public class SortingProxy implements SortingIF {

    private SortingIF sortingif;

    public SortingProxy(){
        this.sortingif = new SortingUtility();
    }

    @Override
    public List<Product> sort(List<Product> items, int sortingApproach) {
        
        sortingif.sort(items, sortingApproach);

        switch (sortingApproach) {
            case 1:
                System.out.println("Logging choice 1 bubble sort list...");
                for (Product product : items) {
                    System.out.println("ID: " + product.getID() + "   Name: " + product.getName() +
                            "   price: $" + product.getPrice());
                }
                return items;
            case 2:

                System.out.println("Logging choice 2 quick sort list...");
                for (Product product : items) {
                    System.out.println("Name: " + product.getName() + "   ID: " + product.getID() +
                            "   price: $" + product.getPrice());
                }
                return items;
        }


        return null;
    }
}