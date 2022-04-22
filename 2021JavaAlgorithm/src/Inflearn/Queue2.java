package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue2 {

    public String solution(String given, String my){
        String answer = "YES";
        Queue q1 = new LinkedList();
        for (char x:given.toCharArray()){
            q1.offer(x);
        }

        Queue q2 = new LinkedList();
        for(char x:my.toCharArray()){
            q2.offer(x);
        }

        //q2에서 필수 과목을 빼먹었다면 q1은 계속 empty가 아닐 것. q2 가 empty 라면 while 문 끝날 수 있도록 && 조건.
        //q2를 한번 돌고나서 q1이 empty라면, yes 아니면 No.
         while(!q1.isEmpty() && !q2.isEmpty()){
            if (q2.peek()==q1.peek()){
                q2.poll();
                q1.poll();
            } else {
                q2.poll();
            }
        }

        if(!q1.isEmpty()) {
            answer = "NO"; //return No 할수도 있는데, 왜인지 return 으로 했을 때 10분이 느림.
        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue2 T = new Queue2();
        Scanner sc = new Scanner(System.in);
        String given = sc.next();
        String my = sc.next();
        System.out.println(T.solution(given,my));

    }
}
