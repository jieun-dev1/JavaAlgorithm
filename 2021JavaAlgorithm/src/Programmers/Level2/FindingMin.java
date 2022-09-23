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

    // V2
    Arrays.sort(B);
    int len = B.length;
    // Integer 형 변환하지 않고, 같은 크기의 배열에 순서를 뒤집어서 넣어준다.
    int[] reverseB = new int[len];
    for(int i=0;i<len;i++) {
      reverseB[i] = B[len-1-i];
    }

    //순회 하면서 A와 B를 곱해서 더하기.
    for(int i=0;i<A.length;i++) {
      int temp = A[i]*reverseB[i];
//      int temp = A[i]*arrB[i];
      answer+=temp;
    }
    return answer;
  }

}
