package eg.edu.alexu.csd.datastructure.stack;

import java.util.Scanner;

public class UI {
 
  public static void main(final String[] args) {
    final Stack s = new Stack();
    final ExpressionEvaluator expression = new ExpressionEvaluator();
    final Scanner input = new Scanner(System.in);
    boolean still = true;
    int choice = 0;
    Object t;
    
    System.out.println("1 - Push");
    System.out.println("2 - Pop");
    System.out.println("3 - Peek");
    System.out.println("4 - Size");
    System.out.println("5 - Check Empty");
    System.out.println("6 - postfix creation");
    System.out.println("7 - Evaluate postfix");
    System.out.println("8 - Exit");
    while (still) {
      System.out.println("\nEnter Your Choice :");
      choice = input.nextInt();
      input.nextLine();
      if (choice == 1) {
        System.out.println("write the Element you want to push");
        t = input.nextLine();
        s.push(t);
      } else if (choice == 2) {
        System.out.println("the poped element : " + s.pop().toString());
      } else if (choice == 3) {
        System.out.println("the peek : " + s.peek().toString());
      } else if (choice == 4) {
        System.out.println("the Size : " + s.size());
      } else if (choice == 5) {
    	  if(s.isEmpty()) {
    	     System.out.println("the stack is empty");	  
    	  }
    	  else {
    	     System.out.println("the stack is not empty");
    	  }
      } else if (choice == 6) {
        System.out.println("input the Expression : ");
        final String x = input.nextLine();
        System.out.println("Postfix : " + expression.infixToPostfix(
            x));
      } else if (choice == 7) {
        System.out.println("input the Postfix to be evaluted : ");
        final String x = input.nextLine();
        System.out.println("result = " + expression.evaluate(x));
      } else if (choice == 8) {
        still = false;
      } else {
        System.out.println("Wrong choice , please choose from the list.");
      }
    }
    input.close();
  }
}