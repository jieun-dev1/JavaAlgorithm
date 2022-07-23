package Programmers.Prac;

import java.util.LinkedList;
import java.util.Queue;

public class NoDuplicates {
    public int[] solution(int []arr) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> secQue = new LinkedList<>();
        //queue에 모든 숫자를 넣음.
        for(int i:arr) {
            queue.add(i);
        }

        //Queue에서, 중복인 것들을 pop하자
        for(int i:queue) {
        if(!queue.isEmpty()) {
            int temp = queue.poll();
            secQue.offer(temp);
            if(queue.peek() == temp) {
                queue.poll();
            } else {
                secQue.offer(temp);
            }
        }
        }

        for(int i=0;i<secQue.size();i++) {
            answer[i] = secQue.poll();
        }

        return answer;
    }

}
