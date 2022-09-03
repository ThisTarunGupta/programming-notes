#include <stdio.h>
#include <stdlib.h>

int array[10];
char* error = "None";
int top[] = { -1, 10 };

void pop(int stack) {
  if (stack == 0) {
    if (top[stack] == -1) {
      return;
    }

    top[stack]--;
  } else {
    if (top[stack] == 10) {
      return;
    }

    top[stack]++;
  }
}

void printError() {
  printf("Error: %s", error);
}

void push(int stack, int data) {
  if (top[0] == top[1] - 1 || top[0] == 9 || top[1] == 0) {
    error = "Array is full";
    return;
  }

  if (stack == 0)
    array[++top[stack]] = data;
  else
    array[--top[stack]] = data;
}

void traverse() {
  if (top[0] == -1 && top[1] == 10) {
    error = "Array is empty";
    return;
  }

  int topx = top[0];
  printf("\nStack 1: ");
  if (topx == -1)
    error = "Empty";
  else
    while (topx != -1)
      printf("%d ", array[topx--]);

  topx = top[1];
  printf("\nStack 2: ");
  if (topx == 10)
    error = "Empty";
  else
    while (topx != 10)
      printf("%d ", array[topx++]);
}

int main() {
  while (1) {
    system("clear");
    int choice, data, stack;

    printError();
    traverse();

    printf("\nMenu:\n1) Add data\n2) Pop data\n3) Exit\nEnter choice(1/2/3): ");
    scanf("%d", &choice);

    switch (choice) {
      case 1:
        printf("Enter data: ");
        scanf("%d", &data);
        printf("Enter stack: ");
        scanf("%d", &stack);
        push(stack - 1, data);
        break;

      case 2:
        printf("Enter stack: ");
        scanf("%d", &stack);
        pop(stack + 1);
        break;

      case 3:
        printf("Exited!\n");
        exit(0);

      default:
        error = "Invalid choice";
    }
  }

  return 0;
}
