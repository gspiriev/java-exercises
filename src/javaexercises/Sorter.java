package javaexercises;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root_spiriev
 */
public class Sorter {
    
    static List<Integer> list = new ArrayList<>();
    Random rand = new Random();
    int unsortedIndex = 0;

    public Sorter() {
        for (int i = 0; i < 10000000; i++) {
            list.add(rand.nextInt(10000000));
        }
    }
    
    
    
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        //bs.displayIntegerArray(list);
        int[] unsortedCopy = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            unsortedCopy[i] = list.get(i);
        }
        sorter.sortAscendingMerge(unsortedCopy);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, unsortedCopy[i]);
        }
        //bs.displayIntegerArray(list);
        sorter.binarySearch(854, 0, list.size());
        
    }
  
    private void displayIntegerArray(List<Integer> arrayToDisplay) {
        for (int number: arrayToDisplay) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
    
    private void sortAscendingBubble() {
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i-1)) {
                int temp = list.get(i);
                list.set(i, list.get(i-1));
                list.set(i-1, temp);
                sortAscendingBubble();
            }
        }
    }
    
    private void sortAscendingSelection() {
        
        int minNumber = Integer.MAX_VALUE;
        int indexOfMinNumber = 0;
      
        for (int i = unsortedIndex; i < list.size(); i++) {
            if (list.get(i) < minNumber) {
                minNumber= list.get(i);
                indexOfMinNumber = i;
            }
        }
        int temp = list.get(unsortedIndex);
        list.set(unsortedIndex, list.get(indexOfMinNumber));
        list.set(indexOfMinNumber, temp);
        if (unsortedIndex < list.size() - 1) {
            unsortedIndex++;
            sortAscendingSelection();
        } else {
            return;
        }
    }
    
    private int[] sortAscendingMerge(int[] unsorted) {
        
        if (unsorted.length <= 1) {
            return unsorted;
        }
        int[] left = new int[unsorted.length/2];
        int[] right = new int[unsorted.length - left.length];
        System.arraycopy(unsorted, 0, left, 0,  left.length);
        System.arraycopy(unsorted, left.length, right, 0,  right.length);
        sortAscendingMerge(left);
        sortAscendingMerge(right);
        
        mergeParts(left, right, unsorted);
        
        return unsorted;
    }
    
    private static void mergeParts(int[] left, int[] right, int[] list) {
        
        int iFirst = 0;
        int iSecond = 0;
        int iMerged = 0;
        
        while(iFirst < left.length && iSecond < right.length) {
            if (left[iFirst] <= right[iSecond]) {
                list[iMerged] = left[iFirst];
                iFirst++;
            } else {
                list[iMerged] = right[iSecond];
                iSecond++;
            }
            iMerged++;
        }
        System.arraycopy(left, iFirst, list, iMerged, left.length - iFirst);
        System.arraycopy(right, iSecond, list, iMerged, right.length - iSecond);
    }
    
    private void binarySearch(int value, int lowerIndex, int higherIndex) {
    
        int mid = lowerIndex + (higherIndex - lowerIndex)/2;
        
        if (higherIndex - lowerIndex <= 1 && value == list.get(mid)) {
            System.out.println("Index: " + mid + " " + "Value: " + value);
            return;
        } else if (higherIndex - lowerIndex <= 1 && value != list.get(mid)) {
            System.out.println("Value not found in this list");
            return;
        }
        
        if (value == list.get(mid)) {
            System.out.println("Index: " + mid + " " + "Value: " + value);
        } else if (value > list.get(mid)) {
            binarySearch(value, mid + 1, higherIndex);
        } else if (value < list.get(mid)) {
            binarySearch(value, lowerIndex, mid - 1);
        }
    }
}
