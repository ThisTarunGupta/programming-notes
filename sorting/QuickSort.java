package sorting;

import java.util.Random;

public class QuickSort {
  static final int SIZE = 10;
  static int[] a = new Random().ints(SIZE, 0, 100).toArray();

  static int partition(int lb, int ub) {
    int pivot = a[ub];
    int pidx = lb - 1;

    for (int i = lb; i < ub; i++)
      if (a[i] < pivot) {
        pidx++;

        int temp = a[pidx];
        a[pidx] = a[i];
        a[i] = temp;
      }

    pidx++;
    int temp = a[ub];
    a[ub] = a[pidx];
    a[pidx] = temp;

    return pidx;
  }

  static void printArray(String message) {
    System.out.print(message + ":\t");
    for (int i = 0; i < SIZE; i++)
      System.out.print(a[i] + " ");
  }

  static void run(int lb, int ub) {
    if (lb >= ub)
      return;

    int pidx = partition(lb, ub);

    run(lb, pidx - 1);
    run(pidx + 1, ub);
  }

  public static void main(String[] args) {
    printArray("Original array");
    run(0, SIZE - 1);
    printArray("\nSorted array");

    System.out.println();
  }
}