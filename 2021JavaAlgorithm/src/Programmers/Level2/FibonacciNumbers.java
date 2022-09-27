package Programmers.Level2;

public class FibonacciNumbers {
  static int answer;
  public int solution(int n) {

    if(n>=2) {
      solution(n-2);
      solution(n-1);
    }

    if(n==1) {
      answer+=n;
      return 1;
    }
    if(n==0) return 0;
    //DFS(3)+DFS(4)
    return answer;
  }

  public static void main(String[] args) {
    FibonacciNumbers T = new FibonacciNumbers();
    System.out.println(T.solution(3));
  }
  }


