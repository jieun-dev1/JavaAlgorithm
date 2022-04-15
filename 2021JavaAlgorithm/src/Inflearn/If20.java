package Inflearn;

import java.util.Scanner;

//이중 for 문으로 풀어야 하는 문제 
//아래와 같이 하면, 92,92,92,0이 나왔을 때 안됨 (배열을 모두 돌며 계산을 못해주기 때문에 1,2,3,4 가 나온다) 
//i와 j가 겹쳐도 여기서는 <를 구하기 때문에 괜찮다. 
public class If20 {
	public int[] solution(int num, int[] arr) {
		int[] rank = new int[num];
		for (int i = 0; i < num; i++) {
			rank[i] = 1;
			for (int j = 0; j < num; j++)
				if (arr[i] < arr[j]) {
					rank[i] += 1;
				}
		}
		return rank;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If20 T = new If20();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		for (int x : T.solution(num, arr)) {
			System.out.print((x) + " ");
		}

	}

}
