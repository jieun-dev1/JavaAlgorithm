package Inflearn;

import java.util.Scanner;

//lt 에 rt 를 바로 넣으면, 한쪽으로 값이 같아지니 tmp 로 값을 할당해주자. 
//lt 와 rt가 모두 알파벳이어야 함. if lt == 특수문자, elif rt  == 특수문자, else (여기서 바꾸기)
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
