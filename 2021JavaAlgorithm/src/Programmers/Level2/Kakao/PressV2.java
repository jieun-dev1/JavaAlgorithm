package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    /**
     * 명구님 코드 참고 - substring()을 안쓰는 코드.
     */
    int len = s.length();
    int answer = len;

    //1. i가 길이가 잘리는 단위다. i마다length 를 재본다.
    for(int i=1;i<=len/2;i++){
      String[] results = s.split("(?<=\\G.{" + i + "})");
      StringBuilder sb = new StringBuilder();
      String str = results[0]; //시작 값
      int count = 1;
      for(int j=1;j<=results.length-1;j++){ //results의 length는 가변적. len 이라고 실수함.
        if (str.equals(results[j])){
          count++;
        } else {
          if(count!=1){
            sb.append(count);
            count = 1;
          }
          sb.append(str);
          str = results[j]; //현재 값으로 위치 바꿔주기.
        }

        if(j == results.length-1){
          if(count!=1){
            sb.append(count);
          }
          sb.append(str);
        }
      }

      //count만 ++되고, 마지막 남은 수들이 더해지지 않는다.
      answer = Math.min(answer, sb.length());
    }

    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("aabbaccc"));
    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
