package FINAL.Nodes;

import java.util.Scanner;

public class QueueNode {
   static class Node {
      Object value;
      Node next;

      public Node(Object value) {
         this.value = value;
         this.next = null;
      }
   }

   Node first;
   Node last;
   int count;

   public QueueNode() {
      first = null;
      last = null;
      count = 0;
   }

   public boolean isEmpty() {
      return first == null && last == null;
   }

   public boolean enqueue(Object value) {
      Node newNode = new Node(value);
      if (isEmpty()) {
         first = newNode;
         last = newNode;
      } else {
         last.next = newNode;
         last = newNode;
      }
      count++;
      return true;
   }

   public boolean dequeue() {
      if (!isEmpty()) {
         if (first == last) {
            first = null;
            last = null;
         } else {
            first = first.next;
         }
         count--;
         return true;
      }
      return false;
   }

   public Object getFirst() {
      return !isEmpty() ? first.value : null;
   }

   public Object getLast() {
      return !isEmpty() ? last.value : null;
   }

   public String toString() {
      StringBuilder result = new StringBuilder();
      if (!isEmpty()) {
         result.append("first = [").append(first.value).append("]\n");
         result.append("last  = [").append(last.value).append("]\n");

         Node temporary = first;
         while (temporary != null) {
            result.append("[").append(temporary.value).append("]->");
            temporary = temporary.next;
         }
         result.append("\n");
      }
      return result.toString();
   }

   public void display() {
      if (!isEmpty()) {
         Node temporary = first;
         while (temporary != null) {
            System.out.print("[" + temporary.value + "]");
            if (temporary.next != null) {
               System.out.print(" -> ");
            }
            temporary = temporary.next;
         }
         System.out.println();
      } else {
         System.out.println("Queue is empty...");
      }
   }

   public static void menuQueueNode(Scanner scan) {
      QueueNode qn = new QueueNode();
      String choice;
      Object value;

      do {
         System.out.println();
         System.out.println("----QUEUENODE MENU----");
         System.out.println("[1] Enqueue");
         System.out.println("[2] Dequeue");
         System.out.println("[3] Get First Value");
         System.out.println("[4] Get Last Value");
         System.out.println("[5] Display Queue");
         System.out.println("[x] Exit");
         System.out.println("---------------------");
         System.out.print("Enter your choice [1-6] : ");
         choice = scan.nextLine();
         System.out.println();

         switch (choice) {
            case "1":
               System.out.print("Enter value to enqueue : ");
               value = scan.nextLine();
               qn.enqueue(value);
               System.out.println("'" + value + "' Successfully enqueued");
               System.out.println();
               break;

            case "2":
               if (!qn.isEmpty()) {
                  qn.dequeue();
                  System.out.println("Successfully dequeued");
               } else {
                  System.out.println("Queue is empty.");
               }
               break;

            case "3":
               if (!qn.isEmpty()) {
                  System.out.println("The first value is [" + qn.getFirst() + "]");
               } else {
                  System.out.println("Queue is empty.");
               }
               break;

            case "4":
               if (!qn.isEmpty()) {
                  System.out.println("The last value is [" + qn.getLast() + "]");
               } else {
                  System.out.println("Queue is empty.");
               }
               break;

            case "5":
               if (!qn.isEmpty()) {
                  System.out.println(qn.toString());
               } else {
                  System.out.println("Queue is empty.");
               }
               break;

            case "x":
            case "X":
               System.out.println("Exiting the code...");
               break;

            default:
               System.out.println("Invalid choice. Please try again.");
         }
      } while (!choice.equalsIgnoreCase("x"));
   }
}
