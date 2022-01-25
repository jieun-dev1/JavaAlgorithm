package Inflearn;

import java.util.Scanner;

//parseInt: 문자열을 숫자로 변환. 
//valueOf(): Integer 필요 시 / parseInt(): 원시 데이터 Int 필요 시. 
//Int: (1) 산술 연산 가능 (2) primitive 자료형 (3) 
//Integer: (1) wrapper 클래스 (2) null 처리 가능 (3) unboxing (wrapper class -> primitive 자료형) 하지 않으면 산술 연산 불가. 
//parseInt: int 형 리턴해서 산술 연산이 가능. Value Of는 integer 형 리턴해서 산술 연산이 불가. 
//Integer.parseInt: String타입으로 된 숫자를 primitive 타입의 숫자로 변환시켜줌. 
//isDigit(): 명시된 char 값이 숫자인지 판단 -> return true/false 
public class If09_v3 {

	public int solution(String str) {
		String answer = "";
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x))
				answer += x;
		}

		return Integer.parseInt(answer);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If09_v3 t = new If09_v3();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(t.solution(str));
	}

}
