package Programmers.Level2;

public class Jump {

  static int n;
  static long answer = 0;
  static int[] ch = new int[]{1,2}; //0번째 원소 -1 , 첫 번째 원소 - 2로 생각.

  public long solution(int n) {
    this.n = n;
    DFS(0, ch[0]);
    DFS(0, ch[1]);
    return answer%1234567;
  }

  public void DFS(int sum, int current){
    sum = sum+current;
    if(sum == n) {
      answer++;
      return;
    } else if(sum>n) {
      return;
    } else if (sum<n){
      DFS(sum, ch[0]);
      DFS(sum, ch[1]);
    }
  }

  public static void main(String[] args) {
    Jump T = new Jump();
//    System.out.println(T.solution(4));
//    System.out.println(T.solution(3));
    System.out.println(T.solution(2000));

  }
}
