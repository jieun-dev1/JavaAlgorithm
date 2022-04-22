package Inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue2_v2 {
    public String solution(String given, String my){
        String answer = "YES";
        Queue<Character> q1 = new LinkedList();
        for (char x:given.toCharArray()){
            q1.offer(x);
        }
        for (char x:my.toCharArray()){
            if(q1.contains(x)){ //���� x�� q1�� ���ԵǴ� ���Ұ� �ִٸ�,
                if(x!=q1.poll()) //�̷��� �о ������, Character�� �־���� ��. �׷��� ������ Operator '!=' cannot be applied to 'char' ����.
                {
                    return "NO";
                }
            }
        }

        if(!q1.isEmpty())
        {
            return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue2_v2 T = new Queue2_v2();
        Scanner sc = new Scanner(System.in);
        String given = sc.next();
        String my = sc.next();
        System.out.println(T.solution(given,my));

    }
}
