package Inflearn;

import java.util.ArrayList;
//�޼���: StringBuilder�� Reverse
// String�� ��ü�� ��� ���� /StringBuilder �� ������ �Ϳ� ������ ��.
//��� ����Ʈ
//(1) �迭�� �Ķ���ͷ� ���� ���� String[] str �ڷ���[] �̸� 
//(2) �ַ���� �ٷ� �μ��ϴ� �� �ƴ϶�, �ַ���� ArrayList�� �����, forEach ������ ���Ҹ� ����Ѵ�. 
//Array�迭�� ����, answer[i] = tmp. ArrayList �� add �� ���°� �� ���ϴ�. 
//(3) reverse ��� �Ŀ� Stringȭ�� �ؾ� String ��ü�� ����. 
//string.valueof() ()�ȿ� �� ���� ���ڿ� ����ȯ. 
import java.util.Scanner;

public class If04 {

	public ArrayList<String> solution(int number, String[] array) {
		ArrayList<String> answer = new ArrayList<>();

		for (String x : array) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If04 T = new If04();
		Scanner kb = new Scanner(System.in);
		int number = kb.nextInt();

		String[] array = new String[number];
		for (int i = 0; i < number; i++) {
			array[i] = kb.next();
		}

		for (String x : T.solution(number, array)) {
			System.out.println(x);
		}

	}

}
