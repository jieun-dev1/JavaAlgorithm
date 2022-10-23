package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

/** (int) Math.ceil() �ƹ��͵� ���� ����. (int)Math.ceil(double()) �̷��� double ó���� ���ָ�, �Ҽ����� �߻��ؼ� ���������� ceil ��
    * ���´�. �ڹ��� ���� ������  https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
    * �� ���� ������ ������ ������ ��µǱ� ������, i�� 4�̰� n�� 2�� ��, 5/2 = 2�� �Ǵ� ���̴�. 2.5�� �ƴ�. ���� double �� ����ȯ �ʿ�

 * n�� h�� ���� �ʴ´�.
*/
public class HIndex {
  public int solution(int[] citations) {
    int n =citations.length;
    int answer= 0;
    Integer[] arr = new Integer[citations.length];
    for(int i=0;i<citations.length;i++) {
      arr[i] = citations[i];
    }
    Arrays.sort(arr, Collections.reverseOrder());

    for(int i=n;i>=1;i--) {
      if((arr[i-1])>=i) {
        answer = i;
        break; //break�� �ؾ� �ִ밪�� ���ϰ� �������´�
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    HIndex index = new HIndex();
    System.out.println(index.solution(new int[] {3,0,6,1,5}));
//    System.out.println(index.solution(new int[] {0, 0, 0, 0, 0}));
//    System.out.println(index.solution(new int[] {0, 0, 0, 0, 1})); //����: 1 �� ��: 1
//    System.out.println(index.solution(new int[] {9, 9, 9, 12})); //����: 4 �� ��: 9


  }
}
