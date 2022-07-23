package Programmers.Prac;

import java.util.Scanner;

//���� �����ڸ� ����� Ǯ��
public class Collatz {
    //num�� 8000000 �̸��� �����̱� ������, long ���� ��ȯ�� �� ����.

    public int solution(int num) {
        long n = (long)num;
        for(int i=0;i<500;i++) {
            if(n == 1) return i; //1�� �ɶ������� Ƚ�� == �ݺ����� ���� Ƚ�� //return �� �ݺ��� ���Ե� �޽��带 ������.
            n = (n%2 == 0) ? n/2 :n*3+1;
        }
        return -1; //�� �ش����� �ʴ´ٸ�, -1�� ��ȯ.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Collatz T = new Collatz();
        int n = sc.nextInt();
        System.out.println(T.solution(n));
    }
}
