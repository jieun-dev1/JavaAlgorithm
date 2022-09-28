package Programmers.Level2;

/**
 * 이전에 시도한 방식: 1이 나올 때까지 깊이 탐색을 하고 1을 더함. 현재 방식 문제: 123456 등 큰 수를 넣으면, 중복 호출이 많음. 원인: 일부 언어는 재귀 호출을
 * 할 수 있는 횟수가 정해져 있고, 횟수를 넘어 재귀 호출을 하면 런타임 에러를 내도록 설계되어 있습니다. 모든 순회에서 f(0) f(1) 까지 가야하는데, 이 문제는
 * 50이상부터만 확인해도 엄청난 중복 호출이 생긴다. 실행속도가 느려서 안됨. 해결: 메모이제이션: 결과가 배열에 있으면 (이미 연산한 결과가 있으면) 이 값을 가져온다 (계속
 * 재귀하면서 탐색하는 것x 0
 *
 * 문제의 조건: 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567로 나눈 나머지를 리턴 - 즉 2 부터는 계속 나머지를 리턴하는 것이다.
 * 이유: 피보나치 수는 쉽게 int 범위를 넘어 버리기 때문에. 자료형 범위에서 존재하게 하기 위해서 임의 수를 나눠주는 것이다 (즉 수는 123457보다는 항상 작을 수 밖에 없다)
 * 숫자 A, b, c가 있을 때, (A+B)%C 의 값은 ((A%C)+(B%C))%C 와 같다.
 *
 * 나머지 값을 구하니까 %c를 해야한다고 생각해서 마지막 결과값에 fibArr[n]을 1234567로 나누었다. 참고로 나누던 나누지 않던, 정답이다.
 */
public class FibonacciNumbers {

  public int solution(int n) {
    int fibArr[] = new int[n + 1];

    for (int i = 0; i <= n; i++) {
      if (i < 2) {
        fibArr[i] = i;
      } else {
        int sum = fibArr[i - 1] + fibArr[i - 2];
        fibArr[i] = sum % 1234567;

      }
    }
    return fibArr[n] % 1234567;

  }

  public static void main(String[] args) {
    FibonacciNumbers T = new FibonacciNumbers();
    System.out.println(T.solution(5));
//    System.out.println(T.solution(123456));
  }
}


