#include <stdio.h>
#include <stdlib.h>

char *error = "None";

struct Node {
  int count, max, min;
  int data;
  struct Node *link;
};

struct Node *head, *tail;

void pop() {
  if (head == NULL) {
    error = "Linked list is empty";
    return;
  }

  if (head->link->link && (head->max == head->link->data || head->min == head->link->data)) {
    struct Node *current = head->link->link;
    int max = current->data;
    int min = current->data;
    while (current != NULL) {
      if (max < current->data)
        max = current->data;
      if (min > current->data)
        min = current->data;

      current = current->link;
    }

    head->max = max;
    head->min = min;
  }

  head->count--;
  if (head->count > 0)
    head->link = head->link->link;
  else
    head = NULL;
  
  error = "None";
}

void printError() {
  printf("Error: %s", error);
}

void push(int data) {
  struct Node *node = (struct Node*)malloc(sizeof(struct Node));
  node->data = data;
  if (head == NULL) {
    head = (struct Node*)malloc(sizeof(struct Node));
    head->count = 0;
    head->max = data;
    head->min = data;
    head->link = node;
  } else {
    if (head->max < data)
      head->max = data;
    if (head->min > data)
      head->min = data;

    tail->link = node;
  }

  head->count++;
  tail = node;
  error = "None";
}

void traverse() {
  if (head == NULL) {
    error = "Linked list is empty";
    return;
  }

  printf("\nLinked list: COUNT: %d; MAX: %d; MIN: %d;\n", head->count, head->max, head->min);
  struct Node *current = head->link;
  while (current != NULL) {
    printf("%d ", current->data);
    current = current->link;
  }
}

int main() {
  while (1) {
    system("clear");
    int choice, data;

    printError();
    traverse();

    printf("\nMenu:\n1) Add data\n2) Pop data\n3) Exit\nEnter choice(1/2/3): ");
    scanf("%d", &choice);

    switch (choice) {
      case 1:
        printf("Enter data: ");
        scanf("%d", &data);
        push(data);
        break;

      case 2:
        pop();
        break;

      case 3:
        printf("Exited!\n");
        return 0;

      default:
        error = "Invalid choice";
    }
  }

  return 0;
}
