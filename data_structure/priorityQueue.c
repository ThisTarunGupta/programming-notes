#include <stdio.h>
#include <stdlib.h>

char* error = "None";

struct Node {
  int data;
  struct Node* link;
};

struct Node* head;

void pop() {
  if (head == NULL) {
    error = "Linked list is empty";
    return;
  }

  head = head->link;
}

void printError() {
  printf("Error: %s", error);
}

void push(int _data) {
  struct Node* node = (struct Node*)malloc(sizeof(struct Node));
  node->data = _data;

  struct Node *current = head, *previous = NULL;
  while (current != NULL) {
    if (current->data > _data)
      break;

    previous = current;
    current = current->link;
  }

  if (previous == NULL) {
    node->link = head;
    head = node;
  } else {
    node->link = previous->link;
    previous->link = node;
  }
}

void traverse() {
  if (head == NULL) {
    error = "Linked list is empty";
    return;
  }

  printf("\nLinked list: ");
  struct Node* current = head;
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
        exit(0);

      default:
        error = "Invalid choice";
    }
  }

  return 0;
}
