package Inflearn;

import java.util.Scanner;

//lt �� rt �� �ٷ� ������, �������� ���� �������� tmp �� ���� �Ҵ�������. 
//lt �� rt�� ��� ���ĺ��̾�� ��. if lt == Ư������, elif rt  == Ư������, else (���⼭ �ٲٱ�)
public class If05 {

	public String solution(String input) {

		char[] inputArray = input.toCharArray();
		int lt = 0, rt = inputArray.length - 1;

		while (lt < rt) {
			if (!Character.isAlphabetic(inputArray[lt]))
				lt++;
			else if (!Character.isAlphabetic(inputArray[rt]))
				rt--;
			else {
				char tmp = inputArray[lt];
				inputArray[lt] = inputArray[rt];
				inputArray[rt] = tmp;
				lt++;
				rt--;
			}
		}
		String answer = String.copyValueOf(inputArray);
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If05 T = new If05();
		Scanner kb = new Scanner(System.in);
		String input = kb.next();

		System.out.println(T.solution(input));
	}

}
