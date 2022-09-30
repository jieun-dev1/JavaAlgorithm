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
 * -> ������ ������ ���� ������ ��Ÿ��.
 */

public class Shiritori {

  public int[] solution(int n, String[] words) {
    int[] answer = {0, 0};
    //������ ������ ����Ʈ�� ������ �޶����� �������� �ߺ� ���� ���� - ��+1: ���� ������: ����
    //Arrays.asList(�迭) = Returns a fixed-size list
//    List<String> list = Arrays.asList(words);
//    Set<String> set = new HashSet<>(list);
    List<String> list = new ArrayList<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < words.length; i++) {
      list.add(words[i]);
      set.add(words[i]);
      if (set.size() != list.size()) {
        answer[0] = 3- ((i + 1) % n);//��ȣ
        answer[1] = (int)Math.ceil((i + 1) / n); //����
        return answer;
      }
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < words.length; i++) {
      if (i == 0) {
        stack.push(words[i].charAt(words[i].length()-1));
      } else if ((i != 0) && (i == words.length - 1) && (stack.peek() != words[i].charAt(
          0))) { //stack �� �� �� ���� == ���� ������ ù ���ڰ� ��ġ���� ������
        answer[0] = (i + 1) % n;//��ȣ
        answer[1] = (i + 1) / n; //����
        return answer;
      } else if ((i != 0) && (i != words.length - 1) && (stack.peek() == words[i].charAt(0))) { //stack �� �� �� ���� == ���� ������ ù ���ڰ� ��ġ�ϸ� stack�� �� �� ���Ҹ� pop�ϰ�, ���� ������ ���� �ֱ�.
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