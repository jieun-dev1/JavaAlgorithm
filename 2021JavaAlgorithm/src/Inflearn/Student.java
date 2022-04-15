package Inflearn;

import java.util.HashMap;
//참고: https://dev-note-97.tistory.com/267
//enroll, referral, answer length 

class Solution {

	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		HashMap<String, Person> people = new HashMap<>();

		int[] answer = new int[enroll.length];
		// int[] answer = {}; 가 아니라, 배열이니까 길이 주어져도 됨.
		for (int i = 0; i < enroll.length; i++) {
			people.put(enroll[i], new Person(enroll[i]));
		}

		for (int i = 0; i < referral.length; i++) {
			people.get(enroll[i]).parent = people.get(referral[i]);
			// 이렇게 하면, referral[i]가 key가 되고(오른쪽), 이에 대한 value 값을 (왼쪽) 정해줄 수 있음.
			// mary가(referral[i]가 가리키는 value 값이 Edward의 Value인 Person 객체의 Parent 로 연결.
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
