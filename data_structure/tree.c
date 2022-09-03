#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Node;

void append(int data);
void pop();
void populateQueueLevel(int level);
struct Node *queuePeek(struct Node *queue);
struct Node *queuePop(struct Node *queue);
void queuePush(struct Node *queue, struct Node *ref);

int count, head = -1, level = -1, maxCountAtLevel, maxCountAtQueueLevel, parentCount, tail = -1;
char* message;
struct Node *parent = NULL, *root = NULL, *queueLevel = NULL;

struct Node {
  int data;
  struct Node *left, *right;
};

void append(int data) {
  struct Node *node = (struct Node*)malloc(sizeof(struct Node));
  node->data = data;

  if (level == -1) {
    root = node;
    level++;
    maxCountAtLevel = pow(2, level);
    parentCount++;
  }
  else {
    if (parentCount == maxCountAtLevel) {
      populateQueueLevel(level);
      parent = queuePop(queueLevel);
      level++;
      maxCountAtLevel = pow(2, level);
      parentCount = 0;
    }

    if (parentCount && parentCount % 2 == 0)
      parent = queuePop(queueLevel);

    if (parent->left == NULL)
      parent->left = node;
    else
      parent->right = node;

    parentCount++;
  }

  count++;
  free node;
  message = "";
} 

void printMessage() {
  printf("%s\n", message);
}

void pop() {
  if (!count) {
    message = "Tree is empty";
    return;
  }

  if (count == 1)
    root = NULL;
  else {
    struct Node *ptr = queuePeek(queueLevel);
    if (ptr->right)
      ptr->right = NULL;
    else
      ptr->left = NULL;

    free ptr;
  }

  count--;
  message = "";
} 

void populateQueueLevel(int level) {
  if (level == -1) return;

  maxCountAtQueueLevel = pow(2, level);
  int countBeforeLevel = level == 0 ? 0 : pow(2, level - 1);

  if (level == 0)
    populateQueueLevel(queueLevel);
  else {
    struct Node *current;
    struct Node *newQueueLevel = (struct Node*)malloc(maxCountAtQueueLevel * sizeof(struct Node));
    while (countBeforeLevel) {
      current = queuePop(queueLevel);
      queuePush(newQueueLevel, current->left);
      queuePush(newQueueLevel, current->right);

      countBeforeLevel--;
    }

    queueLevel = newQueueLevel;
    free current;
    free newQueueLevel;
  }
} 

struct Node *queuePeek(struct Node* queue) {
  if (head == -1) {
    message = "Queue is empty";
    return;
  }

  return queue[head];
}

struct Node *queuePop(struct Node *queue) {
  if (head == -1 || head > tail) {
    head = -1;
    message = "Queue is empty";
    return;
  }

  head++;
  return queue[head - 1];
}

void queuePush(struct Node *queue, struct Node *ref) {
  if (tail == maxCountAtQueueLevel - 1) {
    message = "Queue is full";
    return;
  }

  if (head == -1)
    head++;

  queue[++tail] = ref;
}

void traverse(struct Node *root, char[] order = "pre") {
  if (!count) {
    message = "Tree is empty";
    return;
  }

  if (root == NULL)
    return;

  printf("%d", root->data);

  if (root->left == NULL && root->right == NULL)
    return;

  traverse(root->left, order);
  traverse(root->right, order);
} 

int main() {
  while (1) {
    system("clear");
    int choice, data;

    printMessage();
    traverse(root);

    printf("\nMenu\n1) Append data\n2) Pop data\n3) Exit\nEnter choice(1/2/3): ");
    scanf("%d", &choice);

    switch (choice) {
      case 1:
        printf("Enter data: ");
        scanf("%d", &data);
        append(data);

        break;

      case 2:
        pop();
        break;

      case 3:
        printf("Exited!");
        return 0;
    }
  }

  return 0;
}
