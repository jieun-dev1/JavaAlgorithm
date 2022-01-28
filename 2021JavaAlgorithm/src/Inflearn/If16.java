package Inflearn;

import java.util.Scanner;

//피보나치 수열: 처음 두 항을 1과 1로 한 후, 그 다음항 부터는 앞의 두 개 항을 더해서 만듦. 
//for each: iterate (후자) 로 사용할 수 있는 자료형은 루프를 돌릴 수 있는 자료형 (배열 또는 arrayList) 단점: 반복횟수를 명시하는 것이 불가하다. 1스텝씩 순차적일 때만 사용 가능. 
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
