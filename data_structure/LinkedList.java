package data_structure;

import java.util.Scanner;

class Node {
  int data;
  Node link;

  Node(int data) {
    this.data = data;
    this.link = null;
  }
}

public class LinkedList {
  static int filled;
  static Node head = null;
  static Node tail = null;
  static String message = "None";

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void fill(int fill) {
    if (fill < 1) {
      message = "Filling must be atleat 1";
      return;
    }

    for (int i = 0; i < fill; i++)
      push(i + 1);

    filled = fill;
    message = "None";
  }

  static void insert(int index, int data) {
    if (index < 0 || index >= filled) {
      message = "Linked list index is out of index; 0 <= index < " + filled;
      return;
    }

    Node current = head;
    Node node = new Node(data);

    while (index > 1) {
      current = current.link;
      index--;
    }

    if (index == 0) {
      node.link = current;
      head = node;
    } else {
      node.link = current.link;
      current.link = node;
    }

    filled++;
    message = "None";
  }

  static void insertAfter(int item, int data) {
    int index = search(item);
    if (index == -1) {
      message = "Target data not found";
      return;
    }

    insert(index + 1, data);
  }

  static void insertBefore(int item, int data) {
    int index = search(item);
    if (index == -1) {
      message = "Target data not found";
      return;
    }

    insert(index, data);
  }

  static void message() {
    System.out.println("Message: " + message);
  }

  static void pop() {
    if (filled == 0) {
      message = "Linked list is empty";
      return;
    }

    Node current = head;
    int index = 0;
    while (index < filled - 2) {
      current = current.link;
      index++;
    }

    current.link = null;
    tail = current;

    filled--;
    message = "None";
  }

  static void push(int data) {
    Node node = new Node(data);

    if (head == null)
      head = node;
    else
      tail.link = node;

    tail = node;

    filled++;
  }

  static void remove(int index) {
    if (filled == 0) {
      message = "LinkedList is empty";
      return;
    }

    if (index < 0 || index >= filled) {
      message = "Linked list index is out of index; 0 <= index < " + filled;
      return;
    }

    Node current = head;
    while (index > 1) {
      current = current.link;
      index--;
    }

    if (index == 0)
      head = current.link;
    else
      current.link = current.link.link;

    if (index == filled - 1)
      tail = current;

    filled--;
    message = "None";
  }

  static void removeItem(int item) {
    if (filled == 0) {
      message = "LinkedList is empty";
      return;
    }

    int index = search(item);
    if (index == -1) {
      message = "Target data not found";
      return;
    }

    remove(index);
  }

  static int search(int item) {
    boolean found = false;
    int loc = -1;

    Node current = head;
    while (current != null) {
      loc++;

      if (current.data == item) {
        found = true;
        break;
      }

      current = current.link;
    }

    if (found) {
      message = "Item " + item + " found at " + (loc + 1) + "th postion";
      return loc;
    } else {
      message = "Item " + item + " not found";
      return -1;
    }
  }

  static void traverse() {
    System.out.print("Linked list: ");

    if (filled == 0) {
      message = "Linked list is empty";
      return;
    }

    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.link;
    }

    System.out.println();
  }

  public static void main(String[] args) {
    fill(5);

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
