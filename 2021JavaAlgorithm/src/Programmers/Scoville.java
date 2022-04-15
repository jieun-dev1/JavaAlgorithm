package Programmers;

import java.util.PriorityQueue;

public class Scoville {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		// (1) int 배열의 스코빌 지수를 PriorityQueue 에 정렬함.
		// Queue 는 FIFO 인 반면, Priority Queue 는 우선 순위 높은 element 가 먼저 나간다.
		// peek 은 Queue 도, stack 도 맨 위의 객체를 반환한다.
		for (int i = 0; i < scoville.length; i++)
			q.add(scoville[i]);

		int count = 0;
		// q.peek() 첫 peek 이 K이상이 될 때까지 반복문을 도는 것이 핵심.
		while (q.size() > 1 && q.peek() < K) {
			int weakHot = q.poll();
			int secondWeakHot = q.poll();
			int mixHot = weakHot + (secondWeakHot * 2);
			q.add(mixHot);
			count++;
		}

		if (q.size() <= 1 && q.peek() < K)
			count = -1;

		return count;
	}
}