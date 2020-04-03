package eg.edu.alexu.csd.datastructure.stack;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
* @author Muhannad
*/


public class ExpressionEvaluator implements IExpressionEvaluator {
	
  private static String closeBracket = ")";
	  
  private static String openBracket = "(";
  
  private Object n1;
  
  private Object n2;
 
  public String infixToPostfix(String expression) {
    
    expression = DealingWithNegative(expression);
    if (expression.isEmpty()) {
        throw new RuntimeException();
      }
    StringBuilder post = new StringBuilder("");
    Stack stack = new Stack();
    int totalnumbers = 0;
    int totaloperations = 0;
    for (int i = 0; i < expression.length();) {
      char te = expression.substring(i, i + 1).charAt(0);
      if (Character.isLetterOrDigit(te)) {
        String num = "";
        while (Character.isLetterOrDigit(te)) {
          num += expression.substring(i, i + 1);
          i++;
          if (i == expression.length()) {
            break;
          }
          te = expression.substring(i, i + 1).charAt(0);
        }
        post.append(num + " ");
        totalnumbers++;
      } else {
        if (checkOp(expression.substring(i, i + 1))
            || expression.substring(i, i + 1).equals(openBracket)) {
          String e = expression.substring(i, i + 1);
          while (!stack.isEmpty() && operations((String) stack.peek(), e)) {
            post.append((String) stack.peek() + " ");
            stack.pop();
          }
          stack.push(e);
          if (checkOp(expression.substring(i, i + 1))) {
            totaloperations++;
          }
        } else if (expression.substring(i, i + 1).equals(closeBracket)) {
          while (!stack.isEmpty() && !stack.peek().equals(openBracket)) {
            post.append((String) stack.peek() + " ");
            stack.pop();
          }
          stack.pop();
        }
        i++;
      }
    }
    if (totalnumbers <= totaloperations) {
      throw new RuntimeException();
    }
    while (!stack.isEmpty()) {
      if (stack.peek().toString().equals(openBracket)) {
        throw new RuntimeException();
      }
      post.append(stack.pop() + " ");
    }
    post.deleteCharAt(post.length() - 1);
    return post.toString();
  }

  
  public final int evaluate(final String expression) {

    if (expression.isEmpty()) {
      throw new RuntimeException();
    }
    Stack stack = new Stack();
    for (int x = 0; x < expression.length(); x++) {
      char te = expression.charAt(x);
      if (Character.isLetterOrDigit(te)) {
        String t = "";
        while (expression.charAt(x) != ' ') {
          t += expression.substring(x, x + 1);
          x++;
        }
        stack.push(Float.valueOf(t));
      } else if (expression.charAt(x) != ' ') {
        n2 = stack.pop();
        n1 = stack.pop();
        stack.push(opEvaluation(expression.charAt(x)));
      }
    }
    return Math.round((float) stack.peek());
  }
  /**
   * this method deal with the negative numbers or characters 
   * 
   * @param the string that the user entered
   * @return the modified string that deals with negative
   */
  public String DealingWithNegative(String expression) {
		
		expression = expression.replaceAll("\\(", "\\( ");
		expression = expression.replaceAll("\\)", " \\)");
		String[] split = expression.trim().split("\\s+");
		expression = "";

		for(int x=0 ; x<split.length ; x++) {
			if(split[x].charAt(0) == '-' && split[x].length() > 1) 
				split[x] = "( 0 - " + split[x].substring(1) + " )";
			expression+= split[x] + " ";
		}
		
		return expression;
	}
  /**
  * checks the operations 
  * @param op
  *          
  * @return true or false
  */
  private boolean checkOp(final String op) {
	    return op.equals("+") || op.equals("-") || op.equals("*")
	        || op.equals("/");
	  }

  private boolean operations(final String op1, final String op2) {
	    if ((op1.equals("*") || op1.equals("/"))
	        && (op2.equals("+") || op2.equals("-"))) {
	      return true;
	    } else if ((op1.equals("*") && op2.equals("/"))
	        || (op2.equals("*") && op1.equals("/"))) {
	      return true;
	    } else if ((op1.equals("-") && op2.equals("+"))
	        || (op2.equals("-") && op1.equals("+"))) {
	      return true;
	    } else if ((op1.equals("*") && op2.equals("*"))
	        || (op2.equals("/") && op1.equals("/"))) {
	      return true;
	    } else if ((op1.equals("+") && op2.equals("+"))
	        || (op2.equals("-") && op1.equals("-"))) {
	      return true;
	    }
	    return false;

	  }
	  
 /**
  *this method performs a specified operation 
  *
  * @param a specified operation
  * 
  * @return the result of the performed operation
  */
  private Object opEvaluation(final char operation) {
	    if (operation == '+') {
	      return (float) n1 + (float) n2;
	    } else if (operation == '-') {
	      return (float) n1 - (float) n2;
	    } else if (operation == '*') {
	      return (float) n1 * (float) n2;
	    } else if (operation == '/') {
	      return ((float) n1 / (float) n2);
	    }
	    return null;

	  }

}