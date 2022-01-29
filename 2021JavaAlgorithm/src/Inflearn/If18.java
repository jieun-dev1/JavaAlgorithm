package Inflearn;

import java.util.ArrayList;

//숫자 뒤집기 
//public int solution(int n) {
//    int answer = 0;
//    while (n != 0) {
//        answer = answer * 10 + n % 10;
//        n /= 10;
//    }
//    return answer;
//}

//배열이 아닌 ArrayList 로 answer를 찾자 (answer의 갯수가 동적고정이어서) 
import java.util.Scanner;

public class If18 {

	// res 가 소수인지 판별
	// false 인 경우의 수 걸러내고 아니면 true 로 출력.
	public Boolean isPrime(int res) {
		if (res == 1)
			return false;
		for (int i = 2; i < res; i++) {
			if (res % i == 0)
				return false;
		}
		return true;
	}

	// ArrayList 에 arr의 reverse 를 만들어줌.
	// tmp 가 0이 아닌동안 돌아감.
	public ArrayList<Integer> solution(int[] arr, int num) {
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int res = 0;
			int tmp = arr[i];
			while (tmp > 0) {
				res = res * 10 + tmp % 10;
				tmp /= 10;
			}
			if (isPrime(res) == true) {
				answer.add(res);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If18 T = new If18();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}

		for (int x : T.solution(arr, num)) {
			System.out.print(x + " ");
		}

	}

}
