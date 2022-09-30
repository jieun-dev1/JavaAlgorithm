package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * String index out of range
 * IndexOutOfBoundsException - if index is negative or not less than the length of the specified string
 * -> 음수를 넣으면 위의 에러가 나타남.
 */

public class Shiritori {

  public int[] solution(int n, String[] words) {
    int[] answer = {0, 0};
    //원소의 개수와 리스트의 개수가 달라지는 지점에서 중복 원소 등장 - 몫+1: 차례 나머지: 원소
    //Arrays.asList(배열) = Returns a fixed-size list
//    List<String> list = Arrays.asList(words);
//    Set<String> set = new HashSet<>(list);
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      list.add(words[i]);
      set.add(words[i]);
      if (set.size() != list.size()) {
        answer[0] = 3- ((i + 1) % n);//번호
        answer[1] = (int)Math.ceil((i + 1) / n); //차례
        return answer;
      }
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < words.length; i++) {
      if (i == 0) {
        stack.push(words[i].charAt(words[i].length()-1));
      } else if ((i != 0) && (i == words.length - 1) && (stack.peek() != words[i].charAt(
          0))) { //stack 의 맨 위 원소 == 현재 원소의 첫 글자가 일치하지 않으면
        answer[0] = (i + 1) % n;//번호
        answer[1] = (i + 1) / n; //차례
        return answer;
      } else if ((i != 0) && (i != words.length - 1) && (stack.peek() == words[i].charAt(0))) { //stack 의 맨 위 원소 == 현재 원소의 첫 글자가 일치하면 stack의 맨 위 원소를 pop하고, 현재 마지막 글자 넣기.
        stack.pop();
        stack.push(words[i].charAt(words[i].length()-1));
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Shiritori T = new Shiritori();
    System.out.println(T.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
  }

}