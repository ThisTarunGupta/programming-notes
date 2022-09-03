package data_structure;

import java.util.Scanner;

public class QueueArray {
  final static int SIZE = 10;
  static int[] a = new int[SIZE];
  static int head = -1, tail = -1;
  static String error = "No";

  static void clrscr() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  static void error() {
    System.out.println("Error: " + error);
  }

  static void pop() {
    if (head == -1) {
      error = "Array is empty";
      return;
    }
    
    if (tail != 0 && head == tail) {
      head = -2;
      tail = -1;
    }
    
    if (head == SIZE - 1)
      head = -1;

    head++;
    error = "No";
  }

  static void push(int data) {
    if ((head == 0 && tail == SIZE - 1) || head == tail + 1) {
      error = "Array is full";
      return;
    }

    if (head == -1)
      head++;

    if (tail == SIZE - 1)
      tail = -1;

    a[++tail] = data;
    error = "No";
  }

  static void traverse() {
    System.out.print("Stack array: ");
    if (head == -1) {
      error = "Array is empty";
      return;
    }

    boolean polarityChanged = false;
    for (int i = head; head <= tail || i <= tail || polarityChanged ? i <= tail : true; i++) {
      if (head > tail && i == SIZE) {
        i = -1;
        polarityChanged = true;
        continue;
      }
      System.out.print(a[i] + " ");
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
      clrscr();

      error();
      traverse();

      System.out.print("\nMenu:\na) Add data\nb) Pop data\nc) Exit\n\nEnter choice (a/b/c): ");
      char choice = scanner.next().charAt(0);

      switch (choice) {
        case 'a':
          System.out.print("Enter data: ");
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
