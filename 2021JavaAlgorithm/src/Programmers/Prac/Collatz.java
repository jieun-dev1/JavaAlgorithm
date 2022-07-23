package Programmers.Prac;

import java.util.Scanner;

//삼항 연산자를 사용한 풀이
public class Collatz {
    //num이 8000000 미만인 정수이기 때문에, long 으로 변환한 것 같다.

    public int solution(int num) {
        long n = (long)num;
        for(int i=0;i<500;i++) {
            if(n == 1) return i; //1이 될때까지의 횟수 == 반복문을 돌린 횟수 //return 은 반복문 포함된 메스드를 종료함.
            n = (n%2 == 0) ? n/2 :n*3+1;
        }
        return -1; //에 해당하지 않는다면, -1을 반환.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collatz T = new Collatz();
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
