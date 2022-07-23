package Programmers.Prac;

import java.util.Scanner;

//n�� 3�� ���ϴ� �� ������ ��, int �� �ƴ� long��ȯ�� �´�.
//int����: ?2,147,483,648 ~ 2,147,483,647
//long ����:223,372,036,854,775,808 ~ 223,372,036,854,775,807
public class Collatz {
        public int solution(int num) {
            int answer = 0;
            //1�� �־����� ��.
            long n = (long) num;
            if (n == 1) {
                return answer;
            } else {
                //1�� �־����� �ʾ��� ��.
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
