package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

/*
시간 초과 이유:
 */
public class FindingMin {

  public int solution(int []A, int []B) {
    int answer = 0;

    //A를 오름차순 정렬
    Arrays.sort(A);
    //B를 내림차순 정렬 - Integer 타입 배열로 변경 필요
    Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
    Arrays.sort(arrB, Collections.reverseOrder());
    //순회 하면서 A와 B를 곱해서 더하기.
    for(int i=0;i<A.length;i++) {
      int temp = A[i]*arrB[i];
      answer+=temp;
    }
    return answer;
  }

}
