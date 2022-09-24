package Programmers.Level2;

import java.util.Stack;

/**
 * charAt(n) returns a char and not a String -> equals �� Object���� ��� �����ϱ� ������ == �� ����.
 * <p>
 * Java String charAt method throws IndexOutOfBoundsException, charAt(i)���� i�� 0 ���ϰų�, string�� ���̿�
 * ������.
 */

public class Parentheses {

  boolean solution(String s) {
    boolean answer = true;
    int len = s.length();

    if (s.charAt(0) == ')' || s.charAt(len - 1) == '(' || (len % 2) == 1) {
      answer = false;
    }

    Stack<Character> stack = new Stack<>();
//  �Ʒ� �ڵ嵵 ���.
//    for (int i = 0; i < s.length(); i++) {
//      if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
//        stack.pop();
//        continue;
//      } else if (s.charAt(i) == '(') {
//        stack.push(s.charAt(i));
//      }
//    }

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(s.charAt(i));
      }
      else if (s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') {
        stack.pop();
        continue;
      }
    }


    if (!stack.isEmpty()) {
      answer = false;
    }
    return answer;
  }

  public static void main(String[] args) {
    Parentheses T = new Parentheses();
    System.out.println(T.solution("()()"));
  }

}

