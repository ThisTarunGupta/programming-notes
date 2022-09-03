package miscellaneous;

import java.util.Arrays;
import java.util.Random;

public class QuickSortAnalysis {
  static final int SIZE = 10;
  static Random random = new Random();
  static int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  static int[] b = Arrays.copyOf(a, SIZE);

  static long averageTime, averageRTime;

  static int partition(int[] a, int lb, int ub) {
    int pivot = a[ub];
    int pidx = lb - 1;

    for (int i = lb; i < ub; i++)
      if (a[i] < pivot) {
        pidx++;

        swap(a, pidx, i);
      }

    pidx++;
    swap(a, ub, pidx);

    return pidx;
  }

  static void printArray(int[] a, String message) {
    System.out.print(message + ":\t");
    for (int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
  }

  static void run(int[] a, int lb, int ub, boolean randomPivot) {
    if (lb >= ub)
      return;

    if (randomPivot)
      swap(a, lb + random.nextInt(ub - lb), ub);

    int pidx = partition(a, lb, ub);

    run(a, lb, pidx - 1, randomPivot);
    run(a, pidx + 1, ub, randomPivot);
  }

  static void swap(int[] a, int x, int y) {
    int temp = a[x];
    a[x] = a[y];
    a[y] = temp;
  }

  public static void main(String[] args) {
    final int MAX = 100;
    int n = 0;
    while (n++ < MAX) {
      long start = System.nanoTime();
      run(a, 0, SIZE - 1, false);
      averageTime += System.nanoTime() - start;

      start = System.nanoTime();
      run(b, 0, SIZE - 1, true);
      averageRTime += System.nanoTime() - start;
    }

    System.out.println("Pivot at end: " + averageTime / MAX + "ns");

    System.out.println("Pivot at random: " + averageRTime / MAX + "ns");
  }
}
