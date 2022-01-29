package Inflearn;

import java.util.ArrayList;

//���� ������ 
//public int solution(int n) {
//    int answer = 0;
//    while (n != 0) {
//        answer = answer * 10 + n % 10;
//        n /= 10;
//    }
//    return answer;
//}

//�迭�� �ƴ� ArrayList �� answer�� ã�� (answer�� ������ ���������̾) 
import java.util.Scanner;

public class If18 {

	// res �� �Ҽ����� �Ǻ�
	// false �� ����� �� �ɷ����� �ƴϸ� true �� ���.
	public Boolean isPrime(int res) {
		if (res == 1)
			return false;
		for (int i = 2; i < res; i++) {
			if (res % i == 0)
				return false;
		}
		return true;
	}

	// ArrayList �� arr�� reverse �� �������.
	// tmp �� 0�� �ƴѵ��� ���ư�.
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
