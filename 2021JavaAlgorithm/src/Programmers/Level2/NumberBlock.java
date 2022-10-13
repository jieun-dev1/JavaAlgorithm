package Programmers.Level2;


/**
 * end-begin이 10,000을 넘지 않기 때문에 int[] answer의 길이는 10,000 넘지 않음.
 * 자기 자신이 아닌 약수 중 가장 큰 약수.
 *
 * double을 int로 변환하면 내림으로 계산.
 * 제곱근이 정수가 아니라면, 어차피 상관 없음.
 */
public class NumberBlock {

  public int[] solution(long begin, long end) {
    //int 배열로 반환해야 하니, 초기에 long을 int 로 반환해주기.
    int beginPoint = (int) begin;
    int endPoint = (int) end;
    //1 - end 까지를 만들고, begin-end 는 따로.
    int answer[] = new int[endPoint-beginPoint+1]; //

    for(int i=beginPoint;i<endPoint+1;i++) {
        for(int j=i/2;j>=(int)Math.sqrt(i);j--) {
          if(j>=10000000) {
            continue;
          }
          else if((j<=10000000)&& (i%j==0)) {
            answer[(i-beginPoint)] = j;
            break;
          }
          else  if ((j<=10000000) && (j==(int) Math.sqrt(i)) && (i%j!=0)) {
            answer[(i-beginPoint)] = 1; //제곱근으로 나눠지지 않는다면,
            break;
          }
        }
      }
    return answer;
  }
}
