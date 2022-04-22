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

        //q2���� �ʼ� ������ ���Ծ��ٸ� q1�� ��� empty�� �ƴ� ��. q2 �� empty ��� while �� ���� �� �ֵ��� && ����.
        //q2�� �ѹ� ������ q1�� empty���, yes �ƴϸ� No.
         while(!q1.isEmpty() && !q2.isEmpty()){
            if (q2.peek()==q1.peek()){
                q2.poll();
                q1.poll();
            } else {
                q2.poll();
            }
        }

        if(!q1.isEmpty()) {
            answer = "NO"; //return No �Ҽ��� �ִµ�, ������ return ���� ���� �� 10���� ����.
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
