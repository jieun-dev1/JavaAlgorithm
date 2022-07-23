package Programmers.Prac;

import java.util.Scanner;

public class Collatz {
        public int solution(int num) {
            int answer = 0;
            //1이 주어졌을 떄.
            if (num == 1) {
                return answer;
            } else {
                //1이 주어지지 않았을 때.
                for(int i=0;i<500;i++) {
                    if (num == 1) {
                        return answer;
                    }
                    else if((num%2) ==0) {
                        num = num/2;
                    } else if ((num%2) ==1) {
                        num = (num*3) + 1;
                    }
                    answer++;
                }

                if(num!=1) {
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
