package Programmers;

/**
 * ���� �����÷� �Ǳ� ���� ������.
 * �����÷� ���� ���� �ƿ� �޶� ���� ��찡 ����.
 * �� ���� �̸��̸� ������ ���ڸ� �۰� �����ϴ� ��.
 */
public class Tiles {

  public int solution(int n) {
    int[] arr = new int[n];
    arr[0] = 1%1000000007 ;
    arr[1] = 2%1000000007;
    for(int i=2;i<n;i++) {
      arr[i] = (arr[i - 1]+arr[i-2])%1000000007;
    }
    return arr[n-1]%1000000007;
  }
}
