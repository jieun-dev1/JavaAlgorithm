package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * 오답 이유: 인덱스. input.length()-target.length()+1 을 해줘야 함. -> 처음부터 꼼꼼히 계산할 것. 예시에 맞는지 확인할 것.
 * 시간 복잡도:
 * 난이도 실버 4
 *
 */
public class BJ1543 {
  public int solution(String input,String target){
    int answer = 0;
    int len = target.length();
    //substring의 시간 복잡도 o(n)
    //equals의 시간 복잡도 o(n) 따라서 o(n) * o(2n) = 2n^2. n은 2500. 최대 약 1000만.
    for(int i=0;i<input.length()-target.length()+1;i++){
      String temp = input.substring(i, i+len);
      if(temp.equals(target)){
        i+=len-1;//반복문을 도는 이상, i++가 되기에 -1을 해준다.
        answer++;
      } else {
        continue;
      }
    }
    return answer;
  }
  public static void main(String[] args) {
    BJ1543 T = new BJ1543();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine(); //공백까지 받으려면.
    String target =  sc.nextLine();//공백까지 받을 때
    System.out.println(T.solution(input, target));
  }
}
