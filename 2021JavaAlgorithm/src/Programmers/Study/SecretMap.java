package Programmers.Study;

/**
 * StringBuffer �� String Builder
 * String Builder:
 * (1) ����ȭ�� �������� �ʴ� �ݸ�, �ӵ��鿡�� StringBuffer ���� ������ �����ϴ�.
 * (2) ���� ������ ȯ�� �� ���ڿ��� �߰�, ����, ���� ���� ����� �߻��ϴ� ���
 * StringBuffer: ��Ƽ������ ȯ�� ��, ���ڿ� �߰�/����/������ ����� �߻��� ��
 *
 * n = 16. 16x16 = 256 �̹���.
 *
 * Integer.toString�� 01001 ����. �ƴ� ��� 1001�� ����. �տ� 0�� ���� �־���� ��.
 * 2���� ��ȯ ��, 9 -> "1001", 30 -> "11110"
 * Or ���� �� 11111 (��, �ڸ����� ���� �ʾƵ� 0���� �������.
 *
 * \00000
 */
public class SecretMap {

  //�켱 Binary���� ��ȯ. �켱�� char �� ��ȯ.

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for(int i=0;i<n;i++){
      String tempA = Integer.toBinaryString(arr1[i]);
      String tempB = Integer.toBinaryString(arr2[i]);
      answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);//1�� �ϳ��� ������, 1�� ��ȯ (�� ����)
      while(answer[i].length()<n){
        answer[i]+=" ";
      } //���̰� n�� �ȵȴٴ� �� == �տ� �Ѵ� 0�� ���̽��� ���� ���.
    }

    return answer;
  }

  //��ȯ �� �Ѵ� ���� ��� ã��.


  public static void main(String[] args) {
    SecretMap T = new SecretMap();
    System.out.println(T.solution(5, new int[]{9,20,28,18,11},new int[]{30, 1, 21, 17, 28}));
  }
}
