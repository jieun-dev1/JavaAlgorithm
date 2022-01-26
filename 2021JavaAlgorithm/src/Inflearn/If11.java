package Inflearn;

import java.util.Scanner;

//헤멘 포인트: charArray를 생성하려고 했는데 append가 안됨. 
//for 문을 돌리려고 하면, 0번째와 1번째가 같을 때 넘어가고 1번째와 2번째 비교할 것. 이때 다르면, 여기서 첫 글자와 숫자를 answer에 append
//-> 여기서 형변환.. char-> String이 안됨. 

//답안 포인트
//cnt를 초기화하자. 
//마지막 글자에는 빈 문자를 넣어주기  (마지막 글자E도 그 다음 글자와 비교하고 끝내기 위함)+ length()-1을 해서 빈 문자 E까지만 읽히도록 하기. 
//int를 String으로 바꿀 때는 String.valueOf 혹은 Integer.toString을 쓴다. 
public class If11 {

	public String solution(String input) {
		String answer = "";
		input = input + " ";
		int cnt = 1;

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1))
				cnt++;
			else {
				answer += input.charAt(i);
				if (cnt > 1)
					answer += String.valueOf(cnt);
				cnt = 1;
			}

		}
		return answer;

	}
//	for(int i=0; i<input.length(); i++) {
//		while(input.charAt(i) == input.charAt(i+1)) 
//		{
//			p +=1;
//			
//		} if (input.charAt(i) != input.charAt(i+1))
//			answer+=Character.toString(input.charAt(i-1));
//			
//		return answer;		
//	}
//
//		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If11 T = new If11();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.print(T.solution(input));
	}

}
