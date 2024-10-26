import java.util.*;

public class InfixtoPostfix {
    private String infix;

    public InfixtoPostfix(String i) {
        infix = i;            
    }

    private int getPrec(char o) {
        if (o == '*' || o == '/') return 2;
        if (o == '+' || o == '-') return 1;
        return -1;
    }

    public String convert() {
        StackList stack = new StackList();
        String result = "";

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                result += c;
            } else if (c == '(') {
                stack.push(String.valueOf(c));
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    result += " " + stack.pop();
                }
                if (!stack.isEmpty()) stack.pop();
            } else if ("+-*/".indexOf(c) >= 0) {
                if (!result.isEmpty()) result += " ";
                while (!stack.isEmpty() && (getPrec(c) <= getPrec(stack.peek().charAt(0)))) {
                    result += stack.pop() + " ";
                }
                stack.push(String.valueOf(c));
            }
        }

        while (!stack.isEmpty()) {
            result += " " + stack.pop();
        }

        return result.trim();
    }
}

class Evaluate {
    private String postfix;

    public Evaluate(String p) {
        postfix = p;
    }

    public double getResult() {
        StackList stack = new StackList();

        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(token);
            } else {
                double val2 = Double.parseDouble(stack.pop());
                double val1 = Double.parseDouble(stack.pop());

                switch (token.charAt(0)) {
                    case '*':
                        stack.push(String.valueOf(val1 * val2));
                        break;
                    case '/':
                        stack.push(String.valueOf(val1 / val2));
                        break;
                    case '+':
                        stack.push(String.valueOf(val1 + val2));
                        break;
                    case '-':
                        stack.push(String.valueOf(val1 - val2));
                        break;
                }
            }
        }

        return Double.parseDouble(stack.pop());
    }

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Infix to Postfix Menu : ");
            System.out.println("1. Convert infix to postfix");
            System.out.println("2. Evaluate postfix expression");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter an infix expression: ");
                    String infix = scanner.nextLine();
                    InfixtoPostfix converter = new InfixtoPostfix(infix);
                    String postfix = converter.convert();
                    System.out.println("Postfix expression: " + postfix);
                    break;
                case "2":
                    System.out.print("Enter a postfix expression: ");
                    String postfixInput = scanner.nextLine();
                    Evaluate evaluator = new Evaluate(postfixInput);
                    double result = evaluator.getResult();
                    System.out.println("Result: " + result);
                    break;
                case "3":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } while (!choice.equals("3"));

        scanner.close();
    }
}