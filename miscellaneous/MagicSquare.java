package miscellaneous;

public class MagicSquare {
  public static void main(String[] args) {
    final int SIZE = 3;
    int[][] a = new int[SIZE][SIZE];
    int r = SIZE / 2, c = SIZE - 1, j = SIZE * SIZE;

    for (int i = 1; i <= j; i++) {
      a[r][c] = i;

      if (i % SIZE == 0) {
        r++;

        if (r >= SIZE)
          r = 0;
      } else {
        r--;
        c--;

        if (r < 0)
          r += SIZE;
        if (c < 0)
          c += SIZE;
      }
    }

    for (r = 0; r < SIZE; r++) {
      for (c = 0; c < SIZE; c++)
        System.out.print(a[r][c] + " ");

      System.out.println();
    }
  }
}