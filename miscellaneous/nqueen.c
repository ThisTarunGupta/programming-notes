#include <stdio.h>
#include <stdlib.h>

int *arr, sol;
int place(int k, int j);

int absdiff(int x, int y) {
  return x - y > 0 ? x - y : y - x;
}

void nQueen(int k, int n) {
  for (int i = 0; i < n; i++) {
    if (place(k, i)) {
      arr[k] = i;

      if (k == n - 1) {
        printf("Solution %d: ", ++sol);
        for (int i = 0; i < n; i++)
          printf("%d ", arr[i] + 1);
        printf("\n");
      } else nQueen(k + 1, n);
    }
  }
}

int place(int k, int j) {
  for (int i = 0; i < k; i++)
    if (arr[i] == j || absdiff(k, i) == absdiff(j, arr[i]))
      return 0;

  return 1;
}

int main() {
  system("clear");
  int n;
  printf("Enter number of Queens you want to insert: ");
  scanf("%d", &n);

  if (n < 4) {
    printf("Number of Queens must be greater than 3\n");
    return 0;
  }

  arr = (int *)malloc(n * sizeof(int));
  nQueen(0, n);

  return 0;
}
