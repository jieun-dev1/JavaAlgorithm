package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 1�ð� Ǯ����. Ʋ�� �κ�: 1-3�� ���̽��� ������. 4�ϼ��� 5�ϼ��� ����. A-Z : 65-90 (�ƽ�Ű�ڵ�)
 */
public class Press {

  public int[] solution(String msg) {
    //���ĺ� �ʱ�ȭ
    HashMap<String, Integer> hm = new HashMap<>();
    int len = 27; //z������ �� Ű ��.
    int index = 0;
    ArrayList<Integer> answerList = new ArrayList<>();
    int[] answer = {};
    //A-Z�� �ʱ�ȭ.
    for (int i = 1; i < 27; i++) {
      char temp = (char) (64 + i);
      hm.put(Character.toString(temp), i);
    }
//    System.out.println(hm.get("A"));F

    //�� ������ �ε��������� while �� �ش�.
    //O(1000)
    while (index <= msg.length() - 1) {
      //O(1000)
      //���ڿ� ���̰� 1�� ��� ����ó�� �ʿ�. �Ʒ� if ���� break ��, while ���� ���������� ������ index �߰��� �ʿ� ����. �ݸ�, �Ʒ� for���� �ݺ����� while ���� �� �� �ֱ� ������, while Ż�� �Ϸ��� index ���� �ʿ�.
      if (msg.length() == 1) {
        answerList.add(hm.get(msg.substring(index, index + 1)));
        break;
      }
      for (int j = 2; j < msg.length() + 1; j++) {
        //�� ������ �ε����� ����ų ��, ���⼭ exit.
        if (index == msg.length() - 1) {
          answerList.add(hm.get(msg.substring(index, index + 1)));
          index += 1;
          break;
        }
        //�ι�° �ε��� = ������ �ε����� ��. �׸��� MAP �� ������ ��.
        if (index + j == msg.length() && hm.get(msg.substring(index, index + j)) != null) {
          answerList.add(hm.get(msg.substring(index, index + j)));
          index += j;
          break;
        }
        //�ι�° �ε��� = ������ �ε����� ��. �׸��� MAP �� �������� ���� ��. HM�� �־��ֱ�. j-1������ �������Ƿ�, �ε����� j-1��ŭ ���Ѵ�.
        if (index + j == msg.length() && hm.get(msg.substring(index, index + j)) == null) {
          answerList.add(hm.get(msg.substring(index, index + j - 1)));
          hm.put((msg.substring(index, index + j)), len);
          len++;
          index += j - 1;
          break;
        }
        if (hm.get(msg.substring(index, index + j)) == null) { //�������� hashmap�� ���� ��� ++�� �ϰ� ��. �׷��� �� ���ڸ����� ++���Ǹ�, indexOutOfBounds�� ����
          answerList.add(hm.get(msg.substring(index, index + j - 1)));
          hm.put((msg.substring(index, index + j)), len);
          len++;
          index += j - 1;
          j = 1;//for���� ���鼭 j�� ++�Ǳ⿡, j�� 3�� �� ����. ���� for ���� �� ���� ���� �ʿ�. j=1�� �ؾ� 2�� �ʱ�ȭ.
        } else {
          continue;
        }
      }
    }
    answer = answerList.stream().mapToInt(i -> i.intValue()).toArray();
    return answer;
  }

  public static void main(String[] args) {
    Press T = new Press();
    System.out.println(T.solution("KAKAO"));
//    System.out.println(T.solution("TOBEORNOTTOBEORTOBEORNOT"));
//    System.out.println(T.solution("A"));
  }

}
