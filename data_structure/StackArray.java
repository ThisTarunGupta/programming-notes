package data_structure;

import java.util.Scanner;

public class StackArray {
  final static int SIZE = 10;
  static int[] a = new int[SIZE];
  static int top = -1;
  static String error = "No";

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void error() {
    System.out.println("Error: " + error);
  }

  static void pop() {
    if (top == -1) {
      error = "Array is empty";
      return;
    }

    top--;
    error = "No";
  }

  static void push(int item) {
    if (top == SIZE - 1) {
      error = "Array is full";
      return;
    }

    a[++top] = item;
    error = "No";
  }

  static void traverse() {
    System.out.print("Stack array: ");
    if (top == -1) {
      System.out.print("Array is empty");
      return;
    }

    for (int i = top; i >= 0; i--)
      System.out.print(a[i] + " ");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      clrscr();
      error();
      traverse();

      System.out.print("\nMenu:\na) Push item\nb) Pop item\nc) Exit\n\nEnter choice (a/b/c): ");
      char choice = scanner.next().charAt(0);

      switch (choice) {
        case 'a':
          System.out.print("Enter an item: ");
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