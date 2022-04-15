//package Programmers;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//class Solution {
//	public int[] solution(int[] progresses, int[] speeds) {
//		Queue<Integer> q = new LinkedList<>();
//		List<Integer> answerList = new ArrayList<>();
//
//		for (int i = 0; i < speeds.length; i++) {
//			double remain = (100 - progresses[i]) / (double) speeds[i];
//			int date = (int) Math.ceil(remain);
//
//			if (!q.isEmpty() && q.peek() < date) { // Queue �� ������� �ʰ� ���� �� �տ� ����� �����Ͱ� date ���� �۴ٸ�.
//				answerList.add(q.size()); // answerList�� q�� size ���ϱ�.
//				q.clear(); // queue ���� ����� ����.
//			}
//
//			q.offer(date);
//		}
//
//		answerList.add(q.size());
//
//		int[] answer = new int[answerList.size()];
//
//		for (int j = 0; j < answer.length; j++) {
//			answer[j] = answerList.get(j);
//		}
//
//		return answer;
//	}
//
//}
