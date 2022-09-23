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

    // V2
    Arrays.sort(B);
    int len = B.length;
    // Integer �� ��ȯ���� �ʰ�, ���� ũ���� �迭�� ������ ����� �־��ش�.
    int[] reverseB = new int[len];
    for(int i=0;i<len;i++) {
      reverseB[i] = B[len-1-i];
    }

    //��ȸ �ϸ鼭 A�� B�� ���ؼ� ���ϱ�.
    for(int i=0;i<A.length;i++) {
      int temp = A[i]*reverseB[i];
//      int temp = A[i]*arrB[i];
      answer+=temp;
    }
    return answer;
  }

}
