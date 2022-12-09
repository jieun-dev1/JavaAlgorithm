package Programmers.Level2;

/**
 * ó�� ���� ����.
 * �Ű� ������ ���� ������ �Ҵ������� ��.
 * this.target = target; �̷���. �ݴ�� �ؼ� target�� 0�� �Ҵ��.
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

    //ã�ƺ� ��. if{} else �� �� �� �ϳ��� �����ϰ�,  if{} �׳� �̸�, �Ѵ� ������ �� ����.
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
