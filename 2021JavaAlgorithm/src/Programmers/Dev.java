package Programmers;

import java.util.*;

class Dev {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>(); 
     
        for(int i=0;i<progresses.length;i++) {
        	double remain = (100-progresses[i]) / (double) speeds[i];
        	int date = (int) Math.ceil(remain); //���� ũ�ų� ���� ���� ���� ���� ��. 
        	
        	if(!q.isEmpty()&& q.peek()< date) {
        		answerList.add(q.size());
        		q.clear(); 
        	}
        	q.offer(date);
        }
       answerList.add(q.size());//for �� ���������� ���� ��. 
       int[] answer = new int[answerList.size()];
       for(int i=0;i<answer.length; i++) {
    	   answer[i] = answerList.get(i); //ArrayList�� get() �� ����Ʈ���� � ��ü�� �������µ� ���Ǵ� �޼ҵ�
       }
       return answ
    }
        
}