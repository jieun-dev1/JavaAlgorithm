package Inflearn.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * ���� �κ� ������ ��
 * https://school.programmers.co.kr/learn/courses/30/lessons/131701
 * �ҿ�ð�: 2�ð�
 */
public class Subsequence {
  public int solution(int[] elements) {
    int answer = 0;
    Set<Integer> result = new HashSet<>();
    for(int i=1;i<=elements.length;i++){
      int val = 0;
      //�������� ����
      for(int j=0;j<i;j++){
        val+= elements[j];
      }

      for(int j=0;j<elements.length;j++){
        val-=elements[j];
        //i�� 1�� �����ϴ� ����
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
