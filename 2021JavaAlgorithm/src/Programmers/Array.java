package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

//index 에러가 났던 이유: answer[pi] 처럼 인덱스를 찾아서 값을 입력해주었는데, 
//알고보니 배열 초기화 시 아예 사이즈를 정해주지 않았다. 

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