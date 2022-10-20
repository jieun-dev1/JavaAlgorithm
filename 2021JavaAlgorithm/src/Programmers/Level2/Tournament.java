package Programmers.Level2;

/**
 * 오답 이유:
 * answer가 3이어야 할 때, 결과값이 2가 나옴.
 */
public class Tournament {
  public int solution(int n, int a, int b)
  {
    int answer = 1;

    // 2의 제곱이기 때문에 지수승을 구하고 싶었지만, 이는 math 함수에서 제공하지 않음. 20이하라고 조건을 주었으니, 20까지만 반복하면 된다.
    for(int i=0;i<20;i++) {

      if(a%2 != 0) {
        a = (a+1)/2;
      } else {
        a = a/2;
      }

      if(b%2 != 0) {
        b = (b+1)/2;
      } else {
        b = b/2;
      }

      if(a==b) {
        return answer;
      }

      answer++;

    }

    return answer;
  }

  public static void main(String[] args) {
    Tournament T = new Tournament();
    System.out.println(T.solution(8,4,7));
  }
  }
