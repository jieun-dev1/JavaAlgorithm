package Inflearn;

import java.util.Scanner;

//nextLine이 아니라 next로 받아온다 (nextLine은 띄어쓰기까지 하나로 받아오는것) 
//replace는 ""이 아닌, ''을 쓴다. 
public class If12 {
	// (1) #을 1로 *를 0으로 변환한다
	// (2) 글자를 7개씩 끊는다
	// (3) Integer.parseInt(tmp, 2)은 num 과 같이 다른 string으로 값을 줘야함. 아니면 2진수가 그대로 출력된다.
	// 2진수 -> 10진수 Integer.parseInt(1001,2); 10진수 -> 2진수는
	// Integer.toBinaryString(77);
	public String solution(String str, int b) {

		String answer = "";
		for (int i = 0; i < b; i++) {
			String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(tmp, 2);
			char ch = (char) num;
			str = str.substring(7);
			answer += ch;
		}

		// 숫자를 ascii 코드로 전환

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If12 T = new If12();
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		String str = sc.next();
		System.out.println(T.solution(str, b));

	}

}
