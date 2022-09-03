package sorting;

import java.util.Random;

public class InsertionSort {
  static final int SIZE = 10;
  static int[] a = new Random().ints(SIZE, 0, 100).toArray();

  static int comparison;

  static void printArray(String message) {
    System.out.print(message + ":\t\t");
    for (int i = 0; i < SIZE; i++)
      System.out.print(a[i] + " ");
  }

  public static void main(String[] args) {
    printArray("Original array");

    for (int i = 1; i < SIZE; i++) {
      int current = a[i];
      int j = i - 1;

      while (j >= 0 && current < a[j]) {
        a[j + 1] = a[j];
        j--;

        comparison++;
      }

      a[j + 1] = current;

      comparison++;
    }

    printArray("\nSorted array");

    System.out.print("\nNo. of comparisons:\t");
    System.out.print(comparison);

    System.out.println();
  }
}