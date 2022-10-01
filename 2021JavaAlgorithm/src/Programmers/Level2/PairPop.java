package Programmers.Level2;

import java.util.Stack;

public class PairPop {
  public int solution(String s) {
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    int answer = 0;
    for(int i=0;i<arr.length;i++) { //
      if(stack.isEmpty()){
        stack.push(arr[i]);
        continue;
      } else if((!stack.isEmpty())&&(stack.peek()==arr[i])){
        stack.pop();
        continue;
      } else if((!stack.isEmpty())&&(stack.peek()!=arr[i])){
        stack.push(arr[i]);
      }
    }

    if(stack.isEmpty()) //배열을 다 순회하고 나서,
    { answer = 1;
    } else {
      answer = 0;
    }
    return answer;
  }
}
