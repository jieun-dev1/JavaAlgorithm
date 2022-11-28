package Programmers.Study;

/**
 * StringBuffer 와 String Builder
 * String Builder:
 * (1) 동기화를 지원하지 않는 반면, 속도면에선 StringBuffer 보다 성능이 좋습니다.
 * (2) 단일 스레드 환경 과 문자열의 추가, 수정, 삭제 등이 빈번히 발생하는 경우
 * StringBuffer: 멀티스레드 환경 시, 문자열 추가/삭제/수정이 빈번히 발생할 때
 *
 * n = 16. 16x16 = 256 미미함.
 *
 * Integer.toString시 01001 형태. 아닐 경우 1001로 저장. 앞에 0을 따로 넣어줘야 함.
 * 2진수 변환 시, 9 -> "1001", 30 -> "11110"
 * Or 연산 시 11111 (즉, 자릿수가 맞지 않아도 0으로 계산해줌.
 *
 * \00000
 */
public class SecretMap {

  //우선 Binary으로 변환. 우선은 char 로 변환.

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for(int i=0;i<n;i++){
      String tempA = Integer.toBinaryString(arr1[i]);
      String tempB = Integer.toBinaryString(arr2[i]);
      answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);//1이 하나라도 있으면, 1을 반환 (논리 연산)
      while(answer[i].length()<n){
        answer[i]+=" ";
      } //길이가 n이 안된다는 것 == 앞에 둘다 0인 케이스가 있을 경우.
    }

    return answer;
  }

  //변환 후 둘다 영인 경우 찾기.


  public static void main(String[] args) {
    SecretMap T = new SecretMap();
    System.out.println(T.solution(5, new int[]{9,20,28,18,11},new int[]{30, 1, 21, 17, 28}));
  }
}
