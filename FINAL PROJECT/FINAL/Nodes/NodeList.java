package FINAL.Nodes;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        next = null;
    }
}

public class NodeList {
    private Node head;
    private int count;

    public NodeList() {
        head = null;
        count = 0;
    }

    public boolean add(String data) {
        Node item = new Node(data);
        if (head == null) {
            head = item;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = item;
        }
        count++;
        return true;
    }

    public boolean delete(int location) {
        if (isEmpty() || location < 0 || location >= count) {
            System.out.println("Invalid index or list is empty.");
            return false;
        }

        if (location == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < location - 1; i++) {
                curr = curr.next;
            }
            if (curr.next != null) {
                curr.next = curr.next.next;
            }
        }
        count--;
        return true;
    }

    public void display() {
        Node curr = head;
        if (!isEmpty()) {
            System.out.println("List:");
            int index = 0;
            while (curr != null) {
                System.out.println("[" + index + "] " + curr.data);
                curr = curr.next;
                index++;
            }
        } else {
            System.out.println("List is Empty");
        }
    }

    private boolean isEmpty() {
        return count == 0;
    }

    public static void nodeList(Scanner scan) {
        NodeList list = new NodeList();
        String choice;

        do {
            System.out.println("\nNode List Menu:");
            System.out.println("[1] Add Node");
            System.out.println("[2] Delete Node");
            System.out.println("[3] Display Nodes");
            System.out.println("[x] Exit Node List Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter data to add: ");
                    String data = scan.nextLine();
                    list.add(data);
                    break;

                case "2":
                    System.out.print("Enter index to delete: ");
                    int index = scan.nextInt();
                    scan.nextLine();
                    list.delete(index);
                    break;

                case "3":
                    list.display();
                    break;

                case "x":
                case "X":
                    System.out.println("Exiting Node List Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (!choice.equalsIgnoreCase("x"));
    }
}
