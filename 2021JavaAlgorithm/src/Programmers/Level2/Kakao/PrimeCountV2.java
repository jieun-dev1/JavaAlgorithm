package Programmers.Level2.Kakao;

//소요시간: 1시간
public class PrimeCountV2 {

  public int solution(int n, int k) {
    //진수변환: O(logN) O(Log1000000:백만)
    String temp = Integer.toString(n, k);
    String[] arr = temp.split("[0]+"); //0이 여러개 오는 경우 처리해주지 않으면 "" 빈 스트링이 배열에 담김. ["11,"", 11]

    int answer = 0;
    //1000000을 3진수로 바꾸었을 때 최대 길이..? 13. O(13)
    System.out.println(Integer.toString(1000000, 3));
    for (int i = 0; i < arr.length; i++) {
      Long x = Long.parseLong(arr[i]);
      if (x == 1) {
        continue;
      }

      if (x == 2) {
        answer++;
        continue;
      }
      if (prime(x) == true) {
        answer++;
      }
    }
    return answer;
  }

  //num 최대: 1212210202001 약 1조. root 1조 = 100만. 3진수가 들어갈 경우. O(100만)
  public boolean prime(Long num) {
    boolean answer = true;
    for (long i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0) {
        answer = false;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    PrimeCountV2 T = new PrimeCountV2();
//    System.out.println(T.solution(437674, 3));
    System.out.println(T.solution(110011, 10));

  }
}
