package Programmers.Level2.Kakao;

public class PressV2 {
  public int solution(String s) {
    int len = s.length();
    int answer = len; //처음에는 주어진 길이로 초기화.
    int size = len/2; //2부터 len의 절반 길이(==size) (홀수라면 17이라면 8까지) 순회하면됨.
    StringBuilder sb;
    //첫번째 for는 압축하는 길이.
    //두번째 for는 시작하는 인덱스.
      for(int i=2;i<=size;i++){
        sb = new StringBuilder(); //길이가 2 - size 까지. 여기서 sb는 j가 달라질 때마다, 초기화
        int count = 1;
        for(int j=0;j<=len-i;){
        if(i+j>len){
          sb.append(s, i, len-1); // 마지막 인덱스까지 더해주고 종료.
          break;
        }
        //i+j, i+2*j 가 길이에서 벗어나지 않는 한, i,j를 이동하면서 count를 세어준다.
        while((2*i+j<len)&&s.substring(j, i+j).equals(s.substring(i+j, 2*i+j))){ //여기서 앞의 조건문과, 뒤의 substring 끝 부분을 i+2*j라고 했는데, 간격은 i이다. 따라서 2*i+j가 맞음.
          count++;
          j+=i; //길이만큼 늘어남.
        }
        //더 이상 같은 문자가 없을 경우 count와 이전에 읽은 문자를 더한다. 그리고 j를 옮긴다.

        if(count!=1){
          sb.append(count);
          sb.append(s.substring(j, i+j)); //현재까지 더해주기
          j+=i;
          count = 1; // 다시 1로 초기화
          //j가 i만큼 이동할 때마다, len을 벗어나지 않았는지 확인 필요. 벗어난다면 len 전까지만 더할 것.
          if(i+j>len){
            sb.append(count);
            sb.append(s.substring(j, len)); // 마지막 인덱스까지 더해주고 종료. len-1이 아닌 len이다.
            break;
          }
        }
        //count가 1만 있어도 답은 같을 것 같지만.
        if(count==1 && 2*i+j<len &&!s.substring(j, i+j).equals(s.substring(i+j, 2*i+j))){ //&&!s.substring(j, i+j).equals(s.substring(i+j, 2*i+j) - 제거
          sb.append(s.substring(j, i+j));
          j+=i;
        }
      }
        answer = Math.min(sb.length(), answer);
      }
    //2부터,
    return answer;
  }
  public static void main(String[] args) {
    PressV2 T = new PressV2();
    System.out.println(T.solution("abcabcabcabcdededededede"));
  }
}
