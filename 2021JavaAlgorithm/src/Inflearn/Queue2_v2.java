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
            if(q1.contains(x)){ //원소 x중 q1에 포함되는 원소가 있다면,
                if(x!=q1.poll()) //이렇게 읽어서 쓰려면, Character를 넣어줘야 함. 그렇지 않으면 Operator '!=' cannot be applied to 'char' 에러.
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
