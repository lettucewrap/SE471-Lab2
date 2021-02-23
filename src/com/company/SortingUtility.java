package com.company;

import java.util.List;

public class SortingUtility implements SortingIF{

    public SortingUtility(){
    }

    private void bubbleSort(List<Product> items){
        int size = items.size();
        for (int i = 0; i < size; i++){
            for(int j = 0; j < size - i - 1; j++){
                if(items.get(j).getID()>items.get(j+1).getID()){
                    Product temp = items.get(j);
                    items.set(j, items.get(j+1));
                    items.set(j+1, temp);
                }
            }
        }
    }

    private int partition(List<Product> items, int left,int right){
        middle(items, left, right);
        swap(items, left, (left+right)/2);
        Product pivot = items.get(left);

        int first = left;
        int last = right;

        while(first<last){
            while(first<right && pivot.getID() >= items.get(first).getID()){
                first++;
            }
            while(pivot.getID() < items.get(last).getID()){
                last--;
            }
            if(first<last){
                swap(items, first, last);
            }
        }

        swap(items, left, last);
        return last;
    }
    private void middle(List<Product> items, int left,int right){
        int middle = (left+right)/2;
        if(items.get(middle).getID() < items.get(left).getID()){
            swap(items,left,middle);
        }
        if(items.get(right).getID() < items.get(middle).getID()){
            swap(items,middle,right);
        }
        if(items.get(middle).getID() < items.get(left).getID()){
            swap(items,left,middle);
        }
    }
    private void swap(List<Product> items, int left,int right){
        Product temp = items.get(left);
        items.set(left, items.get(right));
        items.set(right, temp);
    }

    private void quickSort(List<Product> items, int left, int right){
        if(left<right){
            int q = partition(items, left, right);
            quickSort(items, left, q-1);
            quickSort(items, q+1, right);
        }
    }

    @Override
    public List<Product> sort(List<Product> items, int sortingApproach){
        switch (sortingApproach) {
            case 1:
                bubbleSort(items);
                return items;
            case 2:
                quickSort(items, 0, items.size()-1);
                return items;
        }
        return null;
    }

}
