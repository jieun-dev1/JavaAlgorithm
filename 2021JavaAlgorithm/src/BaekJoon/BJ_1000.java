package BaekJoon;

import java.util.Scanner;
//두 정수 A,B를 입력받음. A+B 출력 (, 가 아니라 엔터로 구분한다. )
//nextInt: Scanner 클래스의 메소드 중에 정수를 입력 받고 변수에 값을 넣음. 
//next: Scanner 클래스의 메소드 중에 공백 이전까지의 문자열을 입력받고, name 변수에 값을 넣ㄴ느다. 
// \n : 줄바꿈. 
//System.in 화면에서 입력을 받겠다는 의미. 
//hasNext() 읽어올 요소가 남아있는지 확인하는 메서드. 있으면 true 없으면 false. 
//next() 다음 데이터 반환.  nextLine()은 한 줄 단위로 입력받음. 
//remove() : next()로 읽어온 요소 삭제 

public class BJ_1000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Scanner 클래스 객체 생성
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a + b);
	}
}
