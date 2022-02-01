package Inflearn;

import java.util.Scanner;

//�ַ���� ��ü�� �����ؼ� �����ϱ⿡, �ν��Ͻ� �����迭 ������ ������. �׷��� ���� static ���� ������ �ʿ䰡 ����.  
//continue�� break���� 
public class If22_v2 {
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };

	public int solution(int[][] arr, int n) {
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = true;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[i][j] <= arr[nx][ny]) {
						flag = false;
						break;
					}
				}
				if (flag)
					answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If22_v2 T = new If22_v2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(T.solution(arr, n));

	}

}
