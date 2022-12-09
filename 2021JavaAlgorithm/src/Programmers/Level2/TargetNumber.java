package Programmers.Level2;

/**
 * 처음 오답 원인.
 * 매개 변수를 지역 변수에 할당해줬어야 함.
 * this.target = target; 이렇게. 반대로 해서 target이 0이 할당됨.
 */
public class TargetNumber {
  int target;
  int[] numbers;
  int answer;

// v2
  public int solution(int[] numbers, int target) {
    this.target = target;
    this.numbers = numbers;
    DFS(0, 0);
    return answer;
  }

  public void DFS(int L, int sum){
    if(L==numbers.length){
      if(sum == target) answer++;
      return;
    }

    //찾아볼 것. if{} else 면 둘 중 하나만 수행하고,  if{} 그냥 이면, 둘다 수행할 것 같다.
    else {
      DFS(L+1, sum+numbers[L]);
      DFS(L+1, sum-numbers[L]);
    }
  }

  public static void main(String[] args) {
    TargetNumber T = new TargetNumber();
    System.out.println(T.solution(new int[]{1, 1, 1, 1, 1}, 3));
  }

}
