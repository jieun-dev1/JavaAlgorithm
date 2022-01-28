package Inflearn;

import java.util.Scanner;

//배열을 안쓴다면 
public class If16_v2 {

	public void solution(int num) {
		int a = 1;
		int b = 1;
		int c;
		System.out.print(a + " " + b + " ");
		for (int i = 2; i < num; i++) {
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If16_v2 T = new If16_v2();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		T.solution(num);
	}
}
