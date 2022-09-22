package Programmers.Level1;

import java.util.HashMap;

public class Indicator {
  /**
   * i 1-3 ������ ��ȣ�� �ش�. i+1: 4-7 ������ ��ȣ�� �ش�.
   * ���� ���� ���� choice: i: 3-1 / i+1: 1-3 ����
   * score = {3,2,1,0,1,2,3
   *
   */

  public String solution(String[] survey, int[] choices) {
    int[] score = {3,2,1,0,1,2,3};
    String[] indicator = {"RT","CF","JM","AN"};
    HashMap<Character, Integer> answerMap = new HashMap<>();
    //�ʱ�ȭ�� ���ؼ� ��� ��ǥ�� 0�� �ִ� ������ ����
    for(int i=0;i<indicator.length;i++) {
      answerMap.put(indicator[i].charAt(0), 0);
      answerMap.put(indicator[i].charAt(1), 0);
    }

    //choices �迭�� ��ȸ�ϸ鼭, �ش��ϴ� character�� ã�Ƽ� �־���.
    for(int i=0;i<choices.length;i++) {
      char type1 = survey[i].charAt(0);
      char type2 = survey[i].charAt(1);
      char key;

      if(choices[i]>=1&&choices[i]<=3) {
        key = type1;
      }else if (choices[i]>=5&&choices[i]<=7) {
        key = type2;
      } else {
        continue;
      }

      int b = score[choices[i]-1];

      /**
       * ���� ������ �������� ���� �� ���� ���, put���� �ٷ� ���°� �ƴ϶� ���� ���� ���´�.
       */
      if(answerMap.get(key) == 0) {
        answerMap.put(key, b);
      } else {
        int temp = answerMap.get(key);
        answerMap.put(key, temp+b);
      }
    }

    String answer = "";

    for(int i=0;i<indicator.length;i++) {
      char indicatorA = indicator[i].charAt(0);
      char indicatorB = indicator[i].charAt(1);
      if(answerMap.get(indicatorA) >=answerMap.get(indicatorB)) {
        answer+=indicatorA;
      } else {
        answer+=indicatorB;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Indicator a = new Indicator();
    System.out.println(a.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));
  }
}
