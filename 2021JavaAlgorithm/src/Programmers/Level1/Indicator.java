package Programmers.Level1;

import java.util.HashMap;

public class Indicator {
  /**
   * i 1-3 선택지 번호에 해당. i+1: 4-7 선택지 번호에 해당.
   * 실제 성격 유형 choice: i: 3-1 / i+1: 1-3 점수
   * score = {3,2,1,0,1,2,3
   *
   */

  public String solution(String[] survey, int[] choices) {
    int[] score = {3,2,1,0,1,2,3};
    String[] indicator = {"RT","CF","JM","AN"};
    HashMap<Character, Integer> answerMap = new HashMap<>();
    //초기화를 위해서 모든 지표에 0을 넣는 것으로 시작
    for(int i=0;i<indicator.length;i++) {
      answerMap.put(indicator[i].charAt(0), 0);
      answerMap.put(indicator[i].charAt(1), 0);
    }

    //choices 배열을 순회하면서, 해당하는 character를 찾아서 넣어줌.
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
       * 같은 유형의 설문지가 여러 개 있을 경우, put으로 바로 덮는게 아니라 기존 값에 덮는다.
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
