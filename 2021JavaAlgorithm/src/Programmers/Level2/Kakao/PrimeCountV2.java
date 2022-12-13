package Programmers.Level2.Kakao;

//�ҿ�ð�: 1�ð�
public class PrimeCountV2 {

  public int solution(int n, int k) {
    //������ȯ: O(logN) O(Log1000000:�鸸)
    String temp = Integer.toString(n, k);
    String[] arr = temp.split("[0]+"); //0�� ������ ���� ��� ó�������� ������ "" �� ��Ʈ���� �迭�� ���. ["11,"", 11]

    int answer = 0;
    //1000000�� 3������ �ٲپ��� �� �ִ� ����..? 13. O(13)
    System.out.println(Integer.toString(1000000, 3));
    for (int i = 0; i < arr.length; i++) {
      Long x = Long.parseLong(arr[i]);
      if (x == 1) {
        continue;
      }

      if (x == 2) {
        answer++;
        continue;
      }
      if (prime(x) == true) {
        answer++;
      }
    }
    return answer;
  }

  //num �ִ�: 1212210202001 �� 1��. root 1�� = 100��. 3������ �� ���. O(100��)
  public boolean prime(Long num) {
    boolean answer = true;
    for (long i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        answer = false;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    PrimeCountV2 T = new PrimeCountV2();
//    System.out.println(T.solution(437674, 3));
    System.out.println(T.solution(110011, 10));

  }
}
