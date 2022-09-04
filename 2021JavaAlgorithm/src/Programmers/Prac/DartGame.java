package Programmers.Prac;

import java.util.Stack;

/*
��Ʈ����

(1) Stack�� ���ڿ� �ٷ��.

4,5,6,7 �׽�Ʈ ���̽� ����

 */
public class DartGame {

  /*
  1. DartResult���� S,D,T ���� ã�� ��� ���ؿ� �°� ���� ���ڸ� ����, ������ �ؼ� �־��ش�.
  2. #, * ���� ã�� ��� ���� �Ľ��ؼ� �迭�� �ִ´�.
   */
  public int solution(String dartResult) {

    /*
    ó������ ������ �ѱ��ھ� ��ȸ�ϱ�.
    ����, Ʈ���� ����� �Ϸ��� ���ڷ� �׾ƾ� ��. ��� String �� '1'�� ���ڷ� �ٲ���?
    '1'�� �ƽ�Ű �ڵ�� 49��. 49���� 1�� �Ƿ��� 48�� ����� �ؼ� -'0'�� �Ѵ�.
     */

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < dartResult.length(); i++) {
      if (dartResult.charAt(i) == 'S') {
        continue;
      } else if (dartResult.charAt(i) == 'D') {
        stack.add((int) Math.pow(stack.pop(), 2));
      } else if (dartResult.charAt(i) == 'T') {
        stack.add((int) Math.pow(stack.pop(), 3));
      } else if (dartResult.charAt(i) == '*') {
        int temp1 = stack.pop();
        if (!stack.isEmpty()) {
          stack.add(2 * stack.pop());
        }
        stack.add(2 * temp1);
      } else if (dartResult.charAt(i) == '#') {
        stack.add(-1 * stack.pop());
        //10�� ���
      } else if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
        stack.add(10);
        i++; //i++�� �� ����� �Ѵ�. �ƴϸ� 0�� ���� ��ȸ���� add �Ǳ� �����̴�.
      }  // 11�� ���
      else {
        stack.add(dartResult.charAt(i) - '0');
      }
    }

    int answer = 0;

    for (int i = 0; i < stack.size(); i++) {
      answer += stack.get(i);
    }

    return answer;

  }

}

