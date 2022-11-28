package Programmers.Study;

/**
 * StringBuffer 와 String Builder
 * String Builder:
 * (1) 동기화를 지원하지 않는 반면, 속도면에선 StringBuffer 보다 성능이 좋습니다.
 * (2) 단일 스레드 환경 과 문자열의 추가, 수정, 삭제 등이 빈번히 발생하는 경우
 * StringBuffer: 멀티스레드 환경 시, 문자열 추가/삭제/수정이 빈번히 발생할 때
 */
public class SecretMap {

  public String[] solution(int n, int[] arr1, int[] arr2) {

  }

  public int[][] convertToBinary(int[] arr, int n){
    int[][] intArr  = new int[n][n];
    for (int i = 0; i < n; i++) {
      String s = Integer.toString(arr[i], 2);
      if (s.length() < n) {
        int tempLen = n - s.length();
        StringBuffer tempS = new StringBuffer(s); //1001 -> 01001
        for (int j = 0; j < tempLen; j++) {
          tempS.insert(0, "0");
        }
        s = tempS.toString();
      }
      for (int j = 0; j < n; j++) {
        intArr[i][j] = s.charAt(j) - '0';
      }
    }
    return intArr;
  }


  public static void main(String[] args) {
    SecretMap T = new SecretMap();
    System.out.println(T.solution(5, new int[]{9,20,28,18,11},new int[]{30, 1, 21, 17, 28}));
  }
}
