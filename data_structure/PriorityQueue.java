package data_structure;

import java.util.Scanner;

class Node {
  int data;
  int priority;
  Node link;

  Node(int data, int priority) {
    this.data = data;
    this.priority = priority;
    this.link = null;
  }
}

public class PriorityQueue {
  static Node head = null;
  static Node tail = null;
  static String error = "None"; 

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void error() {
    System.out.println("Error: " + error);
  }

  static void pop() {
    if (head == null) {
      error = "Linked list is empty";
      return;
    }

    if (head.link == null)
      tail = null;

    head = head.link;
    error = "None";
  }

  static void push(int data, int priority) {
    Node node = new Node(data, priority);
    Node current = head;
    boolean before = true;
 
    if (current != null) {
      if (current == tail) {
        if (current.data < priority)
          current = null;
      } else {
        boolean atFirst = true;
        while (current.link != null) {
          if (atFirst) {
            if (current.data > priority)
              break;

            atFirst = false;
            continue;
          } 

          if (current.link.data > priority) {
            before = false;
            break;
          }

          current = current.link;
        }
      }
    }

    if (head == null)
      head = tail = node;
    else if (current == head && before) {
      node.link = current;
      head = node;
    } else if (current != null && current.link != null) {
      node.link = current.link;
      current.link = node;
    } else {
      tail.link = node;
      tail = node;
    }

    error = "None";
  }

  static void traverse() {
    System.out.print("Linked list: ");
    if (head == null) {
      error = "Linked list is empty";
      return;
    }
    
    Node current = head;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.link;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      clrscr();
      error();
      traverse();

      System.out.print("\nMenu:\na) Push data\nb) Pop data\nc) Exit\nEnter choice (a/b/c): ");
      int choice = scanner.next().charAt(0);
      int data;
      switch (choice) {
        case 'a':
          System.out.print("Enter data: ");
          data = scanner.nextInt();
          System.out.print("Enter priority: ");
          push(data, scanner.nextInt());
          break;

        case 'b':
          pop();
          break;

        case 'c':
          System.out.print("Exited!");
          flag = false;
          break;

        default:
          error = "Invalid choice";
      }
    }
    scanner.close();
  }
}
