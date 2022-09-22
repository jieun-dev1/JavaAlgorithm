package Programmers.Level2;

/**
 * Ǯ�̽ð�: 40�� s.split("\\s+") �� String �迭�� ��ȣ ���� �����ڷ� �����Ͽ� �����Ѵ�. NumberFormatException: ���ڰ� �ƴ� ����
 * ���������� ��ȯ�� �� ������ ���� (ex ���ĺ� O) parseInt vs valueOf �� valueOf�� �� ���� (ĳ�� ����) ��ȯ ��, digit �Ӹ� �ƴ϶� ������
 * ���� -���ε� �Բ� ��ȯ���ش�.
 */

public class MinMax {

  public String solution(String s) {
    String answer = "";
    String[] splited = s.split("\\s+");
    int[] arr = new int[splited.length];

    for (int i = 0; i < splited.length; i++) {
      arr[i] = Integer.valueOf(splited[i]);
    }

    //���Ƿ� �ּ�, �ִ� ���� �Ҵ�
    int minTemp = arr[0];
    int maxTemp = arr[0];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < minTemp) {
        minTemp = arr[i];
      }
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > maxTemp) {
        maxTemp = arr[i];
      }
    }

    answer += minTemp;
    answer += " ";
    answer += maxTemp;
    return answer;
  }

  public static void main(String[] args) {
    MinMax T = new MinMax();
//    String answer = T.solution("-1 -2 -3 -4");
    String answer = T.solution("-1 -1");
    System.out.println(answer);
  }
}
