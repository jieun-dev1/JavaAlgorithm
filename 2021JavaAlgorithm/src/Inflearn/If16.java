package Inflearn;

import java.util.Scanner;

//�Ǻ���ġ ����: ó�� �� ���� 1�� 1�� �� ��, �� ������ ���ʹ� ���� �� �� ���� ���ؼ� ����. 
//for each: iterate (����) �� ����� �� �ִ� �ڷ����� ������ ���� �� �ִ� �ڷ��� (�迭 �Ǵ� arrayList) ����: �ݺ�Ƚ���� ����ϴ� ���� �Ұ��ϴ�. 1���ܾ� �������� ���� ��� ����. 
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
