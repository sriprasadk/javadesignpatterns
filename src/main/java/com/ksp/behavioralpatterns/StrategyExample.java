package com.ksp.behavioralpatterns;

//Strategy interface
interface SortingStrategy {
 void sort(int[] array);
}

//Concrete Strategy A
class BubbleSort implements SortingStrategy {
 @Override
 public void sort(int[] array) {
     System.out.println("Sorting using Bubble Sort");
     // Bubble sort logic
 }
}

//Concrete Strategy B
class QuickSort implements SortingStrategy {
 @Override
 public void sort(int[] array) {
     System.out.println("Sorting using Quick Sort");
     // Quick sort logic
 }
}

//Context
class Sorter {
 private SortingStrategy strategy;

 public void setStrategy(SortingStrategy strategy) {
     this.strategy = strategy;
 }

 public void applyStrategy(int[] array) {
     strategy.sort(array);
 }
}

//Client
public class StrategyExample {
 public static void main(String[] args) {
     int[] data = {7, 2, 5, 1, 9};

     Sorter sorter = new Sorter();

     // Using Bubble Sort strategy
     sorter.setStrategy(new BubbleSort());
     sorter.applyStrategy(data.clone()); // clone to keep original array

     // Using Quick Sort strategy
     sorter.setStrategy(new QuickSort());
     sorter.applyStrategy(data.clone()); // clone to keep original array
 }
}
