package Programmers;

import java.util.PriorityQueue;

public class Scoville {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		// (1) int �迭�� ���ں� ������ PriorityQueue �� ������.
		// Queue �� FIFO �� �ݸ�, Priority Queue �� �켱 ���� ���� element �� ���� ������.
		// peek �� Queue ��, stack �� �� ���� ��ü�� ��ȯ�Ѵ�.
		for (int i = 0; i < scoville.length; i++)
			q.add(scoville[i]);

		int count = 0;
		// q.peek() ù peek �� K�̻��� �� ������ �ݺ����� ���� ���� �ٽ�.
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