package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * String index out of range IndexOutOfBoundsException - if index is negative or not less than the
 * length of the specified string -> 음수를 넣으면 위의 에러가 나타남.
 * <p>
 * (int) Math.ceil() 아무것도 하지 않음. (int)Math.ceil(double()) 이렇게 double 처리를 해주면, 소수점이 발생해서 정상적으로 ceil 이
 * 나온다. 자바의 정수 나누기  https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
 * 두 개의 정수를 나누면 정수가 출력되기 때문에, i가 4이고 n이 2일 때, 5/2 = 2가 되는 것이다. 2.5가 아닌. 따라서 double 로 형변환 필요
 * <p>
 * 문제 해결: Math.ceil 내부에 double 형 변환, if 문 내에 불필요한 words.length-1로직을 지웠고 (잘못 쓴 것. 이는 if 로 체크할 것이 아님)

 */

public class Shiritori {

  public int[] solution(int n, String[] words) {
    int[] answer = {0, 0};
    Stack<Character> stack = new Stack<>();
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      list.add(words[i]);
      set.add(words[i]);
      if (set.size() != list.size()) {
        answer[0] = (i % n) + 1; //번호
        answer[1] = (int) Math.ceil((double) (i + 1) / n); //차례
        return answer;
      }

      if (i == 0) {
        stack.push(words[i].charAt(words[i].length() - 1));
      } else if ((i != 0) && (stack.peek() != words[i].charAt(
          0))) { //stack 의 맨 위 원소 == 현재 원소의 첫 글자가 일치하지 않으면
        answer[0] = (i % n) + 1; //번호
        answer[1] = (int) Math.ceil((double) (i + 1) / n); //차례
        return answer;
      } else if ((i != 0) && (stack.peek() == words[i].charAt(
          0))) { //stack 의 맨 위 원소 == 현재 원소의 첫 글자가 일치하면 stack의 맨 위 원소를 pop하고, 현재 마지막 글자 넣기.
        stack.pop();
        stack.push(words[i].charAt(words[i].length() - 1));
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    Shiritori T = new Shiritori();
    System.out.println(
        T.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
  }

}