package Programmers.Level2.implementation;

/**
 * 배열 자르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
 *
 * 핵심: 2차원 배열을 구현해서 풀 수 없음 (n이 10의 7승이기 때문이다)  10의 14승이면 거의 100조다.
 * 배열의 규칙을 찾아보면, (n을 나눈 몫, n을 나눈 나머지)의 위치 중 큰 값이 n-1과 같다. .
 * 막힌 부분: left, right이 long형인데, 이를 int배열로 바꿔서 반환 필요.
 *
 */
public class array {
    //left, right의 최댓값은 10의 14승이다. long
    //long을 어떻게 int로 변환?
    public int[] solution(int n, long left, long right) {
      int[] answer = new int[(int)(right-left+1)];
      //size 역시 int여야 한다. int 배열의 최대 크기는 21억인데, right-left는 최대 long 형 크기이기 때문.
      // long에서 int로 배꿔야 함.
      for(long i=left;i<=right;i++){
        long x = i/n; //몫 몫은 최대 10의 7승이지만. long/int 는 long이다.
        long y = i % n; //나머지 나머지는 최대 n-1이어서 10의 14승에 가까움.
        long temp = Math.max(x,y); //둘 중 더 큰 것을 기준으로 수를 찾는다.
        long element = temp+1;
        answer[(int)(i-left)] = (int)element; //i-left를 모두 감싸줘야 한다. 그렇게 하지 않으면 i 만 int로 변환되기 때문.
      }
      return answer;
    }
  }

