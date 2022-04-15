package Inflearn;

import java.util.HashMap;
//����: https://dev-note-97.tistory.com/267
//enroll, referral, answer length 

class Solution {

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		HashMap<String, Person> people = new HashMap<>();

		int[] answer = new int[enroll.length];
		// int[] answer = {}; �� �ƴ϶�, �迭�̴ϱ� ���� �־����� ��.
		for (int i = 0; i < enroll.length; i++) {
			people.put(enroll[i], new Person(enroll[i]));
		}

		for (int i = 0; i < referral.length; i++) {
			people.get(enroll[i]).parent = people.get(referral[i]);
			// �̷��� �ϸ�, referral[i]�� key�� �ǰ�(������), �̿� ���� value ���� (����) ������ �� ����.
			// mary��(referral[i]�� ����Ű�� value ���� Edward�� Value�� Person ��ü�� Parent �� ����.
		}

		for (int i = 0; i < seller.length; i++) {
			addProfit(people.get(seller[i]), amount[i] * 100);
		}

		for (int i = 0; i < enroll.length; i++) {
			answer[i] = people.get(enroll[i]).profit;
		}
		return answer;
	}

	public void addProfit(Person person, int profit) {
		int profit_for_parent = profit / 10;
		if (person.parent != null && profit_for_parent != 0) {
			person.profit += profit - profit_for_parent;
			addProfit(person.parent, profit_for_parent);
		} else {
			person.profit = profit;
		}
	}

	public class Person {
		String name;
		Person parent;
		int profit;

		public Person(String name) {
			this.name = name;
			this.parent = null;
			this.profit = 0;
		}
	}

}
