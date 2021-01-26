package com.performance.code.flowcode.controllers.Imperative;

import com.performance.code.flowcode.Entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ImperativeProductImpl {


    public static void mergeSort(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = (int) array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = (int) array[mid + i + 1];

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }


    public List<Double> filterByPrices(List<Product> products, Double price1, Double price2) {
        List<Double> emptyList = new ArrayList<>();
        List<Double> filteredPrices = new ArrayList<>();
        for (Product p : products) {
            emptyList.add(p.getPrice());
        }

        for (int i = 0; i < emptyList.size(); i++) {
            if (price1 <= emptyList.get(i) && price2 >= emptyList.get(i)) {
                filteredPrices.add(emptyList.get(i));
            }
        }
        return filteredPrices;
    }

    public void findDuplicate(List<Product> products, String description, String name, Double price) {

        for (Product product : products) {
            if (product.getDescription().equalsIgnoreCase(description) &&
                    product.getName().equalsIgnoreCase(name) &&
                    product.getPrice().equals(price)) {
                System.out.println(product.getDescription() + " " + product.getName() + " " + product.getPrice());
            }
        }

    }
}
