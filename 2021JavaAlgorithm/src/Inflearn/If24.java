package Inflearn;

import java.util.Scanner;

//arr[k][s] == i �̸�, ���⼭�� ����� �ʿ��ϴϱ� s �� �־�� �Ѵ� (�ప) 
//(����, ��Ƽ �� ������ pi�� ū������ �ϵ� ����� ���� ¦�� ������ ���ϴ� ���̱� ������ 
//pi�� pj�� test���� �񱳵Ǿ�� �ϴ� ���̴� (s�� �� ���� ���� ��� ��)
public class If24 {

	public int solution(int[][] arr, int n, int t) {
		int answer = 0;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int cnt = 0;
				for (int k = 0; k < t; k++) {
					int pi = 0;
					int pj = 0;
					for (int s = 0; s < n; s++) {
						if (arr[k][s] == i)
							pi = s;
						if (arr[k][s] == j)
							pj = s;
					}
					if (pi < pj)
						cnt++;
				}
				if (cnt == t)
					answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If24 T = new If24();
		Scanner sc = new Scanner(System.in);
		// �л���
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[][] arr = new int[t][n];
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();
		}
		System.out.println(T.solution(arr, n, t));
	}

}
