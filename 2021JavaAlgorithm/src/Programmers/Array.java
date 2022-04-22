package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

//index ������ ���� ����: answer[pi] ó�� �ε����� ã�Ƽ� ���� �Է����־��µ�, 
//�˰��� �迭 �ʱ�ȭ �� �ƿ� ����� �������� �ʾҴ�. 

class Array {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		// int[] answer = {};
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int pi = 0; pi < commands.length; pi++) {
			int pj = commands[pi][2] - 1;
			int[] answer1 = Arrays.copyOfRange(array, commands[pi][0] - 1, commands[pi][1]);
			Arrays.sort(answer1);
			answer[pi] = answer1[pj];
		}
		return answer;
	}
}