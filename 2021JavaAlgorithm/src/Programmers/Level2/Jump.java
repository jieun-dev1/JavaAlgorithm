package Programmers.Level2;

//2000을 넣어서 1234567 나머지를 구하면 -236727이 나오기에 미리 1234567 나눠서 넣어줘야 함.


// * 숫자 A, b, c가 있을 때, (A+B)%C 의 값은 ((A%C)+(B%C))%C 와 같다.
public class Jump {

  static int[] fibo;

  public long solution(int n) {
    fibo = new int[n + 1];
    if (n <= 2) {
      fibo[n] = n;

    }
//    if (n==1){
//      fibo[n] = 1%1234567;
//    } else if (n==2) {
//      fibo[n] = 2%1234567;
//    }

    else if (n >= 3) {
      fibo[1] = 1 % 1234567;
      fibo[2] = 2 % 1234567;
      for (int i = 3; i <= n; i++) {
        fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
      }
    }

    return fibo[n];
  }


  public static void main(String[] args) {
    Jump T = new Jump();
//    System.out.println(T.solution(4));
//    System.out.println(T.solution(3));
    System.out.println(T.solution(2000));

  }
}
