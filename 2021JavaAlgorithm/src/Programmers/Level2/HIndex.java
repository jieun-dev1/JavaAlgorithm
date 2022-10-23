package Programmers.Level2;

import java.util.Arrays;
import java.util.Collections;

/** (int) Math.ceil() 아무것도 하지 않음. (int)Math.ceil(double()) 이렇게 double 처리를 해주면, 소수점이 발생해서 정상적으로 ceil 이
    * 나온다. 자바의 정수 나누기  https://stackoverflow.com/questions/3144610/integer-division-how-do-you-produce-a-double
    * 두 개의 정수를 나누면 정수가 출력되기 때문에, i가 4이고 n이 2일 때, 5/2 = 2가 되는 것이다. 2.5가 아닌. 따라서 double 로 형변환 필요

 * n이 h를 넘지 않는다.
*/
public class HIndex {
  public int solution(int[] citations) {
    int n =citations.length;
    int answer= 0;
    Integer[] arr = new Integer[citations.length];
    for(int i=0;i<citations.length;i++) {
      arr[i] = citations[i];
    }
    Arrays.sort(arr, Collections.reverseOrder());

    for(int i=n;i>=1;i--) {
      if((arr[i-1])>=i) {
        answer = i;
        break; //break를 해야 최대값을 구하고 빠져나온다
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    HIndex index = new HIndex();
    System.out.println(index.solution(new int[] {3,0,6,1,5}));
//    System.out.println(index.solution(new int[] {0, 0, 0, 0, 0}));
//    System.out.println(index.solution(new int[] {0, 0, 0, 0, 1})); //정답: 1 내 답: 1
//    System.out.println(index.solution(new int[] {9, 9, 9, 12})); //정답: 4 내 답: 9


  }
}
