package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

/*
�ð� �ʰ� ����:
 */
public class FindingMin {

  public int solution(int []A, int []B) {
    int answer = 0;

    //A�� �������� ����
    Arrays.sort(A);
    //B�� �������� ���� - Integer Ÿ�� �迭�� ���� �ʿ�
    Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
    Arrays.sort(arrB, Collections.reverseOrder());
    //��ȸ �ϸ鼭 A�� B�� ���ؼ� ���ϱ�.
    for(int i=0;i<A.length;i++) {
      int temp = A[i]*arrB[i];
      answer+=temp;
    }
    return answer;
  }

}
