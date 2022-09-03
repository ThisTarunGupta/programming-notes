package data_structure;

import java.util.Scanner;

public class Array {
  final static int SIZE = 10;
  static int[] a = new int[SIZE];
  static int filled;
  static String message = "None";

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void fill(int fill) {
    if (fill < 1 || fill > SIZE) {
      message = "Array filing is out of scope; 1 <= fill <= 10";
      return;
    }

    for (int i = 0; i < fill; i++)
      a[i] = (int) (Math.random() * 100);

    filled = fill;
    message = "None";
  }

  static void insert(int index, int data) {
    if (filled == SIZE) {
      message = "Array is full";
      return;
    }

    if (index >= filled) {
      message = "Use option 'a' instead";
      return;
    }

    for (int i = filled - 1; i >= index; i--)
      a[i + 1] = a[i];

    a[index] = data;
    filled++;
    message = "None";
  }

  static void insertAfter(int item, int data) {
    if (filled == SIZE) {
      message = "Array is full";
      return;
    }

    int index = search(item);
    if (index == -1) {
      message = "Target item not found";
      return;
    }

    insert(index + 1, data);
  }

  static void insertBefore(int item, int data) {
    if (filled == SIZE) {
      message = "Array is full";
      return;
    }

    int index = search(item);
    if (index == -1) {
      message = "Target item not found";
      return;
    }

    insert(index, data);
  }

  static void message() {
    System.out.println("Message: " + message);
  }

  static void pop() {
    if (filled == 0) {
      message = "Array is empty";
      return;
    }

    filled--;
    message = "None";
  }

  static void push(int data) {
    if (filled == SIZE) {
      message = "Array is full";
      return;
    }

    a[filled++] = data;
    message = "None";
  }

  static void remove(int index) {
    if (filled == 0) {
      message = "Array is empty";
      return;
    }

    if (index < 0 || index >= filled) {
      message = "Array index is out of bound; 0 <= index < " + filled;
      return;
    }

    for (int i = index; i < filled - 1; i++)
      a[i] = a[i + 1];

    filled--;
    message = "None";
  }

  static void removeItem(int item) {
    if (filled == 0) {
      message = "Array is empty";
      return;
    }

    int index = search(item);
    if (index == -1) {
      message = "Target item not found";
      return;
    }

    remove(index);
    message = "None";
  }

  static int search(int item) {
    int loc = -1;

    for (int i = 0; i < SIZE; i++)
      if (a[i] == item) {
        loc = i;
        break;
      }

    if (loc == -1)
      message = "Item " + item + " not found.";
    else
      message = "Item " + item + " found at " + (loc + 1) + "th position.";

    return loc;
  }

  static void traverse() {
    System.out.print("Array: ");

    if (filled == 0) {
      message = "Array is empty";
      return;
    }

    for (int i = 0; i < filled; i++)
      System.out.print(a[i] + " ");

    message = "None";
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int data, item, index;
    boolean flag = true;
    while (flag) {
      clrscr();

      message();
      traverse();

      System.out.print(
          "\nMenu:\na) Append data\nb) Add data at index\nc) Add data after specific item\nd) Add data before specific item\ne) Remove item\nf) Remove item at index\ng) Remove item at last\nh) Search item\ni) Exit\n\nEnter choice (a/b/c/d/e/f/g/h/i): ");
      char choice = scanner.next().charAt(0);

      switch (choice) {
        case 'a':
          System.out.print("Enter data: ");
          push(scanner.nextInt());
          break;

        case 'b':
          System.out.print("Enter data: ");
          data = scanner.nextInt();
          System.out.print("Enter index: ");
          index = scanner.nextInt();
          insert(index, data);
          break;

        case 'c':
          System.out.print("Enter data: ");
          data = scanner.nextInt();
          System.out.print("Enter item: ");
          item = scanner.nextInt();
          insertAfter(item, data);
          break;

        case 'd':
          System.out.print("Enter data: ");
          data = scanner.nextInt();
          System.out.print("Enter item: ");
          item = scanner.nextInt();
          insertBefore(item, data);
          break;

        case 'e':
          System.out.print("Enter item: ");
          removeItem(scanner.nextInt());
          break;

        case 'f':
          System.out.print("Enter index: ");
          remove(scanner.nextInt());
          break;

        case 'g':
          pop();
          break;

        case 'h':
          System.out.print("Enter item: ");
          search(scanner.nextInt());
          break;

        case 'i':
          flag = false;
          System.out.println("Exited!");
          break;
      }
    }
    scanner.close();
  }
}
