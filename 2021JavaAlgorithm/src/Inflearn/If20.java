package Inflearn;

import java.util.Scanner;

//���� for ������ Ǯ��� �ϴ� ���� 
//�Ʒ��� ���� �ϸ�, 92,92,92,0�� ������ �� �ȵ� (�迭�� ��� ���� ����� �����ֱ� ������ 1,2,3,4 �� ���´�) 
//i�� j�� ���ĵ� ���⼭�� <�� ���ϱ� ������ ������. 
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
