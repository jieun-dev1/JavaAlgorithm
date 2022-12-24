package Programmers.Level2.implementation;

/**
 * �迭 �ڸ���
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 *
 * �ٽ�: 2���� �迭�� �����ؼ� Ǯ �� ���� (n�� 10�� 7���̱� �����̴�)  10�� 14���̸� ���� 100����.
 * �迭�� ��Ģ�� ã�ƺ���, (n�� ���� ��, n�� ���� ������)�� ��ġ �� ū ���� n-1�� ����. .
 * ���� �κ�: left, right�� long���ε�, �̸� int�迭�� �ٲ㼭 ��ȯ �ʿ�.
 *
 */
public class array {
    //left, right�� �ִ��� 10�� 14���̴�. long
    //long�� ��� int�� ��ȯ?
    public int[] solution(int n, long left, long right) {
      int[] answer = new int[(int)(right-left+1)];
      //size ���� int���� �Ѵ�. int �迭�� �ִ� ũ��� 21���ε�, right-left�� �ִ� long �� ũ���̱� ����.
      // long���� int�� ���� ��.
      for(long i=left;i<=right;i++){
        long x = i/n; //�� ���� �ִ� 10�� 7��������. long/int �� long�̴�.
        long y = i % n; //������ �������� �ִ� n-1�̾ 10�� 14�¿� �����.
        long temp = Math.max(x,y); //�� �� �� ū ���� �������� ���� ã�´�.
        long element = temp+1;
        answer[(int)(i-left)] = (int)element; //i-left�� ��� ������� �Ѵ�. �׷��� ���� ������ i �� int�� ��ȯ�Ǳ� ����.
      }
      return answer;
    }
  }

