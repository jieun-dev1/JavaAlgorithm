package Programmers.Level2;

/**
 * 최소 공배수의 특징
 * 최소 공배수는 네 수의 공통 배수보다(네 수를 모두 곱한 값)보다 작거나 같다.
 * arr의 길이 = 15 이하이고, 원소는 100 이하인 자연수.
 * 원소가 100임을 가정할 때 이중 for문으로 풀면 시간초과가 날 수 있을 것 같다.
 *
 * i를 순회할 때, 1부터 하기 때문에 multiple+1 을 해줘야 함.
 */
public class LeastCommon {
  public int solution(int[] arr) {
    int answer = 0;
    long multiple = 1; //배수를 초기화
    for(int i=0;i<arr.length;i++) {
      multiple = multiple*arr[i];
    }

    for(int i=1;i<multiple+1;i++) {
      for(int j=0;j<arr.length;j++) {
        if(i%arr[j] != 0) {
          break;
        } else if((i%arr[j]==0) && (j==arr.length-1)) { //마지막 원소라면
          answer = i;
          return answer;
        }
        else if(i%arr[j]==0 && (j!=arr.length-1)) {
          continue;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    LeastCommon T = new LeastCommon();
    System.out.println(T.solution(new int[] {2,6,8,14}));

  }
}
