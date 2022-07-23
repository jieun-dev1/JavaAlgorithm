package Programmers.Prac;

import java.util.Scanner;

//n에 3을 곱하는 걸 생각할 때, int 가 아닌 long변환이 맞다.
//int범위: ?2,147,483,648 ~ 2,147,483,647
//long 범위:223,372,036,854,775,808 ~ 223,372,036,854,775,807
public class Collatz {
        public int solution(int num) {
            int answer = 0;
            //1이 주어졌을 떄.
            long n = (long) num;
            if (n == 1) {
                return answer;
            } else {
                //1이 주어지지 않았을 때.
                for(int i=0;i<500;i++) {
                    if (n == 1) {
                        return answer;
                    }
                    else if((n%2) ==0) {
                        n = n/2;
                    } else if ((n%2) ==1) {
                        n = (n*3) + 1;
                    }
                    answer++;
                }

                if(n!=1) {
                    answer = -1;
                }
            }

            return answer;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collatz T = new Collatz();
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
