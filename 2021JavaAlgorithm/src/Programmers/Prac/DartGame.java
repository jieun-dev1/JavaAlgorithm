package Programmers.Prac;

import java.util.Stack;

/*
다트게임

(1) Stack과 문자열 다루기.

4,5,6,7 테스트 케이스 오류

 */
public class DartGame {

  /*
  1. DartResult에서 S,D,T 등을 찾을 경우 기준에 맞게 이전 숫자를 제곱, 세제곱 해서 넣어준다.
  2. #, * 등을 찾을 경우 따로 파싱해서 배열에 넣는다.
   */
  public int solution(String dartResult) {

    /*
    처음부터 끝까지 한글자씩 순회하기.
    더블, 트리플 계산을 하려면 숫자로 쌓아야 함. 어떻게 String 형 '1'을 숫자로 바꾸지?
    '1'은 아스키 코드로 49임. 49에서 1이 되려면 48을 빼줘야 해서 -'0'을 한다.
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
        //10일 경우
      } else if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
        stack.add(10);
        i++; //i++를 꼮 해줘야 한다. 아니면 0이 다음 순회에서 add 되기 때문이다.
      }  // 11일 경우
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

