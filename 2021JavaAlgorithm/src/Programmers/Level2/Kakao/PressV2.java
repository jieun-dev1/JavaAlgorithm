package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    /**
     * 지웅님 코드 참고.
     *
     * 핵심 구현
     * -j에서 출발하여, i간격으로 늘어난다. 간격 i< length/2+1
     *
     * -시작점은 i가 바뀌어도 늘 0이다
     */
    int len = s.length();
    int answer = len;
    //길이가 1인 글자가 동일하게 주어질 수도 있음. - 테스트 1 제대로 보기. 따라서 1부터 길이/2까지 간다.
    for(int i=1;i<=len/2;i++){
      //j가 len이랑 같아지는 순간 == 범위에서 벗어나면 exit 됨. substring을 쓸 것이므로 ==로 함. 현재 == str. 다음 == compare.
      String str = s.substring(0, i);
      //i+j가 len을 넘을 때/넘지않을 때 분기.
      StringBuilder sb = new StringBuilder();
      int count = 1;

      for(int j=i;j<=len;j+=i){
        int limit = 0;
        //i+j == len 일 때 (i간격으로 딱 나눠질 때. 이때, 마지막 compare는 빈 string이다.
        //나눠지지 않을 때만 compare 값이 존재한다.
        if(j+i>len) {
        limit = len; //
      } else {
        limit = j+i;
      }
        String compare = s.substring(j, limit);
        if(str.equals(compare)){
          count++;
          //동일한 숫자가 없어서, sb에 더해줄 때 count를 다시 1로 초기화한다.
        } else {
         if(count>=2){
           sb.append(count);
         }
         sb.append(str);
         count = 1;

          /**
           * str =compare 를 해야하는 이유
           * str = s.substring(j, i+j); //i+j 가 범위 밖이어서 에러 남.
           * 여기서 s.substring(j, i+j)를 하게 되면, i+j가 limit을 넘어서는 경우를 반영하지 못한다.
           * ex. 길이가 5인 경우.
           * limit이 len인 경우까지 str = compare 로 할당해 주는 게 무의미해도, j+=i가 되었을 때 (j==25여서 j>len임. 따라서 for 문에서 바로 나옴)
           *
           */

         str = compare;
        }
      }
      sb.append(str); //마지막 수는 범위에 해당되지 않아서 for 문에서 빠져나갈 수 있다. 이 경우, 더해줘야 함.
      answer = Math.min(answer, sb.length());
    }

    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("aabbaccc"));
//    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
