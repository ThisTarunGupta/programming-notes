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

public class StackLinkedList {
  static Node top = null;

  static int filled;
  static String error = "No";

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void error() {
    System.out.println("Error: " + error);
  }

  static void pop() {
    if (filled == 0) {
      error = "Linked list is empty";
      return;
    }

    top = top.link;

    filled--;
    error = "No";
  }

  static void push(int data) {
    Node node = new Node(data);
    node.link = top;
    top = node;

    filled++;
    error = "No";
  }

  static void traverse() {
    System.out.print("Linked list: ");
    if (filled == 0) {
      System.out.print("Linked list is empty");
      return;
    }

    Node current = top;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.link;
    }

    System.out.println();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      clrscr();
      error();
      traverse();

      System.out.print("\nMenu:\na) Add data\nb) Pop data \nc) Exit\n\nEnter choice (a/b/c): ");
      char choice = scanner.next().charAt(0);

      switch (choice) {
        case 'a':
          System.out.print("Enter an data: ");
          push(scanner.nextInt());
          break;

        case 'b':
          pop();
          break;

        case 'c':
          flag = false;
          System.out.println("Exited!");
          break;
      }
    }

    scanner.close();
  }
}