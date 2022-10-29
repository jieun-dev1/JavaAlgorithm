package Programmers;

/**
 * 값이 오버플로 되기 전에 나눠줌.
 * 오버플로 나면 값이 아예 달라 지는 경우가 많다.
 * 그 전에 미리미리 나눠서 숫자를 작게 유지하는 것.
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
