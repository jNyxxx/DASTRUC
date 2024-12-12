package FINAL.Nodes;

import java.util.Scanner;

class StackNode {
    String data;
    StackNode tail;
    
    public StackNode(String data) {
        this.data = data;
        tail = null;
    }
}

public class StackList {
    private StackNode head;
    private int count;
    
    public StackList() {
        head = null;
        count = 0;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean push(String data) {
        StackNode node = new StackNode(data);
        
        node.tail = head;
        head = node;
        count++;
        return true;
    }
    
    public String pop() {
        String data;

        if (!isEmpty()) {
            data = head.data;
            head = head.tail;
            count--;
           return data;
        }
        return null;
    }  
    
    public String peek() {
        if (!isEmpty()) {
            return head.data;
        }
        return null;
    }
    
    public int getCount() {
        return count;
    }
    
    public void display() {
        if (!isEmpty()) {
            StackNode temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.tail;
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty....");
        }
    }
    public static void stackList(Scanner scan) {
        StackList stack = new StackList();

        String choice;
        do {
            System.out.println("\nStack List Menu:");
            System.out.println("[1] Push to Stack");
            System.out.println("[2] Pop from Stack");
            System.out.println("[3] Peek at Stack");
            System.out.println("[4] Display Stack");
            System.out.println("[x] Exit Stack List Program");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter value to push: ");
                    String value = scan.nextLine();
                    stack.push(value);
                    System.out.println("Pushed " + value + " to the stack.");
                    break;

                case "2":
                    if (stack.pop() != null) {
                        System.out.println("Successfully popped from the stack.");
                    } else {
                        System.out.println("Stack is empty. Cannot pop.");
                    }
                    break;

                case "3":
                    String top = stack.peek();
                    if (top != null) {
                        System.out.println("Top of stack: " + top);
                    } else {
                        System.out.println("Stack is empty.");
                    }
                    break;

                case "4":
                    System.out.println("Current Stack:");
                    stack.display();
                    break;

                case "x":
                case "X":
                    System.out.println("Exiting Stack List Program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (!choice.equalsIgnoreCase("x"));
    }
}