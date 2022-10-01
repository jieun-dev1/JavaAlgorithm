package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * String index out of range IndexOutOfBoundsException - if index is negative or not less than the
 * length of the specified string -> ������ ������ ���� ������ ��Ÿ��.
 * <p>
 * (int) Math.ceil() �ƹ��͵� ���� ����. (int)Math.ceil(double()) �̷��� double ó���� ���ָ�, �Ҽ����� �߻��ؼ� ���������� ceil ��
 * ���´�. �ڹ��� ���� ������  https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
 * �� ���� ������ ������ ������ ��µǱ� ������, i�� 4�̰� n�� 2�� ��, 5/2 = 2�� �Ǵ� ���̴�. 2.5�� �ƴ�. ���� double �� ����ȯ �ʿ�
 * <p>
 * ���� �ذ�: Math.ceil ���ο� double �� ��ȯ, if �� ���� ���ʿ��� words.length-1������ ������ (�߸� �� ��. �̴� if �� üũ�� ���� �ƴ�)

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
        answer[0] = (i % n) + 1; //��ȣ
        answer[1] = (int) Math.ceil((double) (i + 1) / n); //����
        return answer;
      }

      if (i == 0) {
        stack.push(words[i].charAt(words[i].length() - 1));
      } else if ((i != 0) && (stack.peek() != words[i].charAt(
          0))) { //stack �� �� �� ���� == ���� ������ ù ���ڰ� ��ġ���� ������
        answer[0] = (i % n) + 1; //��ȣ
        answer[1] = (int) Math.ceil((double) (i + 1) / n); //����
        return answer;
      } else if ((i != 0) && (stack.peek() == words[i].charAt(
          0))) { //stack �� �� �� ���� == ���� ������ ù ���ڰ� ��ġ�ϸ� stack�� �� �� ���Ҹ� pop�ϰ�, ���� ������ ���� �ֱ�.
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