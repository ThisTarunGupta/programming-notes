package sorting;

import java.util.Random;

public class MergeSort {
  static final int SIZE = 10;
  static int[] a = new Random().ints(SIZE, 0, 100).toArray();

  static void conquer(int lb, int mid, int ub) {
    int i = lb, j = mid + 1, x = 0;
    int[] merged = new int[ub - lb + 1];

    while (i <= mid && j <= ub) {
      if (a[i] < a[j])
        merged[x++] = a[i++];
      else
        merged[x++] = a[j++];
    }

    while (i <= mid)
      merged[x++] = a[i++];
    while (j <= ub)
      merged[x++] = a[j++];

    for (i = 0, j = lb; i < merged.length; i++, j++)
      a[j] = merged[i];
  }

  static void divide(int lb, int ub) {
    if (lb >= ub)
      return;

    int mid = lb + (ub - lb) / 2;

    divide(lb, mid);
    divide(mid + 1, ub);
    conquer(lb, mid, ub);
  }

  static void printArray(String message) {
    System.out.print(message);
    for (int i = 0; i < SIZE; i++)
      System.out.print(a[i] + " ");
  }

  public static void main(String[] args) {
    printArray("Original array:\t");

    divide(0, SIZE - 1);

    printArray("\nSorted array:\t");

    System.out.println();
  }
}