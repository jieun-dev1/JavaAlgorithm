package Programmers;

import java.util.*;

class Dev {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>(); 
     
        for(int i=0;i<progresses.length;i++) {
        	double remain = (100-progresses[i]) / (double) speeds[i];
        	int date = (int) Math.ceil(remain); //보다 크거나 같은 가장 작은 정수 값. 
        	
        	if(!q.isEmpty()&& q.peek()< date) {
        		answerList.add(q.size());
        		q.clear(); 
        	}
        	q.offer(date);
        }
       answerList.add(q.size());//for 문 마지막으로 끝날 때. 
       int[] answer = new int[answerList.size()];
       for(int i=0;i<answer.length; i++) {
    	   answer[i] = answerList.get(i); //ArrayList의 get() 는 리스트에서 어떤 객체를 가져오는데 사용되는 메소드
       }
       return answ
    }
        
}