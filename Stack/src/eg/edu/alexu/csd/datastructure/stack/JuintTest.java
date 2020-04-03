package eg.edu.alexu.csd.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuintTest {
	@Test
    public void lenghtTest() {
        Stack s = new Stack();
        s.push(0);
        assertEquals(1, s.size());
        s.push(10);
        s.push('m');
        s.push('n');
        assertEquals(4, s.size());
        s.pop();
        assertEquals(3, s.size());
        s.push(100);
        s.push(200);
        s.push(300);
        s.push(400);
        assertEquals(7, s.size());
    }
    
    @Test
    public void popTest() {
        Stack s = new Stack();
        s.push('a');
        s.push('b');
        s.push('c');
        s.push('d');
        assertEquals('d', s.pop());
        assertEquals('c', s.pop());
        assertEquals('b', s.pop());
        assertEquals('a', s.pop());
        assertEquals(true, s.isEmpty());
    }
    @Test
    public void PushTest(){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        assertEquals(3, s.size());
    }
    @Test
    public void emptyTest() {
        Stack s = new Stack();
        assertEquals(true ,s.isEmpty());
        s.push('m');
        assertEquals(false ,s.isEmpty());
        assertEquals('m' ,s.pop());
        assertEquals(true ,s.isEmpty());
    }
    @Test
    public void peekTest() {
        Stack s = new Stack();
        s.push(100);
        s.push(200);
        assertEquals(200, s.peek());
        assertEquals(200, s.pop());
        assertEquals(100, s.peek());
    }
    @Test
    public void infixToPostixTestForPdfTestCases(){
        ExpressionEvaluator e = new ExpressionEvaluator();
        String p = e.infixToPostfix("2 + 3 * 4");
        assertEquals("2 3 4 * +", p);
        p = e.infixToPostfix("a * b + 5");
        assertEquals("a b * 5 +", p);
        p = e.infixToPostfix("(1 + 2) * 7");
        assertEquals("1 2 + 7 *", p);
        p = e.infixToPostfix("a * b / c");
        assertEquals("a b * c /", p);
        p = e.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
        assertEquals("a b c - d + / e a - * c *", p);
        p = e.infixToPostfix("a / b - c + d * e - a * c");
        assertEquals("a b / c - d e * + a c * -", p);
       
    }
    @Test
    public void infixToPostixTestMyCases(){
        ExpressionEvaluator e = new ExpressionEvaluator();
        String p = e.infixToPostfix("10 * -50");
        assertEquals("10 0 50 - *", p);
        p = e.infixToPostfix("4 *(-7)");
        assertEquals("4 0 7 - *", p);
        p = e.infixToPostfix("10-5*8+9/4");
        assertEquals("10 5 8 * - 9 4 / +", p);
        p = e.infixToPostfix("my/k+3*(-2)");
        assertEquals("my k / 3 0 2 - * +", p);
       
    }
    
    @Test
    public void evaluateTest(){
        ExpressionEvaluator e = new ExpressionEvaluator();
        int result = e.evaluate("8 5 * 2 4 * +");
        assertEquals(48, result);
        result = e.evaluate("2 3 9 * 7 3 * / +");
        assertEquals(3, result);
        result = e.evaluate("2 8 * 4 4 * -");
        assertEquals(0, result);
        result = e.evaluate("1 1 - 2 + 2 - 3 + 3 -");
        assertEquals(0, result);
        result = e.evaluate("10 0 8 - *");
        assertEquals(-80, result);
        result = e.evaluate("7 7 * 7 * 7 * 7 *");
        assertEquals(16807, result);
        result = e.evaluate("2 4 * 4 / 2 -");
        assertEquals(0, result);
        result = e.evaluate("8 5 * 2000 * 20 / 600 7 * + 9 - 6 80 * +");
        assertEquals(8671, result);
        result = e.evaluate("8 8 * 8 / 8 /");
        assertEquals(1, result);
    }
    
       
        
    }
   
    
