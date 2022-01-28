package Inflearn;

import java.util.Scanner;

//피보나치 수열: 처음 두 항을 1과 1로 한 후, 그 다음항 부터는 앞의 두 개 항을 더해서 만듦. 
public class If16 {

	public int[] solution(int num) {
		int[] answer = new int[num];
		answer[0] = 1;
		answer[1] = 1;
		for (int i = 2; i < num; i++) {
			answer[i] = answer[i - 2] + answer[i - 1];
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If16 T = new If16();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int x : T.solution(num)) {
			System.out.print(x + " ");
		}
	}

}
