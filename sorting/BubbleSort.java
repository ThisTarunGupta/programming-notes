package sorting;

import java.util.Random;

public class BubbleSort {
  static final int SIZE = 10;
  static int[] a = new Random().ints(SIZE, 0, 100).toArray();

  static int comparison, swap;

  static void printArray(String message) {
    System.out.print(message + ":\t\t");
    for (int i = 0; i < SIZE; i++)
      System.out.print(a[i] + " ");
  }

  public static void main(String[] args) {
    printArray("Original array");

    for (int i = 0; i < SIZE - 1; i++)
      for (int j = 0; j < SIZE - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;

          swap++;
        }

        comparison++;
      }

    printArray("\nSorted array");

    System.out.print("\nNo. of comparisons:\t");
    System.out.print(comparison);
    System.out.print("\nNo. of swaps:\t\t");
    System.out.print(swap);

    System.out.println();
  }
}