package Programmers.Level2;


/**
 * end-begin이 10,000을 넘지 않기 때문에 int[] answer의 길이는 10,000 넘지 않음.
 * 자기 자신이 아닌 약수 중 가장 큰 약수.
 */
public class NumberBlock {

  public int[] solution(long begin, long end) {


    //1 - end 까지를 만들고, begin-end 는 따로.
    int answer[] = new int[(int) end-(int) begin+1]; //

    for(long i=begin;i<end+1;i++) {
      if(i%2 == 0) {
        answer[((int)i-(int)begin)] = (int)i/2; ///2의 배수인 경우 2로 나눈 값이 약수 중 가장 큰 수. 2의 배수면 순회할 필요 x.
      } else {
        for(long j=(int)i/2;j>=1;j--) {
          if(i%j==0) {
            answer[((int)i-(int)begin)] = (int) j;
            break;
          }
        }
      }
    }
    return answer;
  }
}
