package FINAL.InfToPostf;

import java.util.Scanner;

import FINAL.Nodes.StackList;

public class InfixtoPostfix {
   private String infix;
   
   public InfixtoPostfix(String i) {
      infix = i;
   }
   
   private int getPrec(char o) {
      if (o == '*'||o == '/')
         return 2;
      if (o == '+'||o == '-')
         return 1;
      return -1;
   }
   
   public String convert() {
      StackList s = new StackList();
      String result = "";
      
      for (int i= 0; i < infix.length(); i++) {
         char c = infix.charAt(i);
         
         if (Character.isDigit(c)) {
            result+=c;
         } else if (c == '(') {
            s.push(c+"");
         } else if (c == ')') {
            while (!s.peek().equals("(")) {
               result += s.pop();
            }
            s.pop();
         } else {
            while (!s.isEmpty() && ((getPrec(c) <= getPrec(s.peek().charAt(0))))) {
               result += s.pop();
            }
            
            s.push(c + "");
         }
      }
      
      while (!s.isEmpty()) {
         result += s.pop();
      }
      
      return result;
   }
   static class Evaluate {
      private String postfix;
      
      public Evaluate(String postfix) {
         this.postfix = postfix;
      }
      
      public double getResult() {
         StackList s = new StackList();
         double ans = 0;
         
         for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            
            if (Character.isDigit(c)) {
               s.push(c + " ");
            } else {
               double val2 = Double.parseDouble(s.pop());
               double val1 = Double.parseDouble(s.pop());
               
               switch (c) {
                  case '*':
                     ans = val1 * val2;
                     break;
                  case '/':
                     ans = val1 / val2;
                  case '+':
                     ans = val1 + val2;
                     break;
                  case '-':
                     ans = val1 - val2;
                     break;
               }
               s.push(ans + "");
            }
         }
         return Double.parseDouble(s.pop());
      }
   }
   public static void menuInfixToPostfix(Scanner scan) {
      String choice;

        do {
            System.out.println("Infix to Postfix Menu : ");
            System.out.println("[1] Convert infix to postfix");
            System.out.println("[2] Evaluate postfix expression");
            System.out.println("[x] Exit");
            System.out.print("Choose an option: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter an infix expression: ");
                    String infix = scan.nextLine();
                    InfixtoPostfix converter = new InfixtoPostfix(infix);
                    String postfix = converter.convert();
                    System.out.println("\nPostfix expression: " + postfix);
                    break;
                case "2":
                    System.out.print("Enter a postfix expression: ");
                    String postfixInput = scan.nextLine();
                    Evaluate evaluator = new Evaluate(postfixInput);
                    double result = evaluator.getResult();
                    System.out.println("\nResult: " + result);
                    break;
                case "x":
                case "X":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } 
        while (!choice.equalsIgnoreCase("x"));
   }
}