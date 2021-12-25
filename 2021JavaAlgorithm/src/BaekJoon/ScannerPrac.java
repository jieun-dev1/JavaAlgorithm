package BaekJoon;
//nextInt: Scanner 클래스의 메소드 중에 정수를 입력 받고 변수에 값을 넣음. 
//next: Scanner 클래스의 메소드 중에 공백 이전까지의 문자열을 입력받고, name 변수에 값을 넣ㄴ느다. 
//띄어쓰기 공백 이전의 문자만 읽는다. 처음으로 공백이 나오면 더 읽지 않는다. 
// \n : 줄바꿈. 

import java.util.Scanner;

public class ScannerPrac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in); //Scanner 클래스 객체 생성 
		String name; 
		int age;
		System.out.println("이름을 입력해 주세요");
		name = scanner.next();
		System.out.println("나이를 입력해 주세요");
		age = scanner.nextInt();
		
		System.out.println("\n이름"+  name + "\n");
		System.out.println("나이:"+  age + "살");


	}

}


