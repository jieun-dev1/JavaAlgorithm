package Inflearn.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * 연속 부분 수열의 합
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * 소요시간: 2시간
 */
public class Subsequence {
  public int solution(int[] elements) {
    int answer = 0;
    Set<Integer> result = new HashSet<>();
    for(int i=1;i<=elements.length;i++){
      int val = 0;
      //시작점을 세팅
      for(int j=0;j<i;j++){
        val+= elements[j];
      }

      for(int j=0;j<elements.length;j++){
        val-=elements[j];
        //i가 1로 시작하는 이유
        val+=elements[(i+j)%elements.length];
        result.add(val);
      }
    }

    return result.size();
  }

  public static void main(String[] args) {
    Subsequence T = new Subsequence();
    T.solution(new int[]{7,9,1,1,4});
  }
}
