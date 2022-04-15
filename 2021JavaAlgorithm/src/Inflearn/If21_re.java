package Inflearn;

//sum1, sum2를 초기화해줘야 함. 
//대각선은 초기화를 안에서 해줄 필요 없음. (행을 순차적으로 훑는게 아니어서) 
import java.util.Scanner;

public class If21_re {
	public int solution(int n, int[][] arr) {
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int sum1 = 0, sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}

		int sum1 = 0, sum2 = 0;

		for (int i = 0; i < n; i++) {

			sum1 += arr[i][i];
			sum2 += arr[n - i - 1][i];
		}

		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If21_re T = new If21_re();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(T.solution(n, arr));
	}

}
