package Inflearn;

import java.util.*;

//�� ������ ��ȣ�� ������ �����Ѵٴ� ������ ����.
//sc.pop()�� get(i)�� Ȱ���� �� �ִ���.
public class Stack2 {

    public String solution(String str) {
        String answer = ""; //answer�� String�̾. �׳� + �������� �־��൵ �� ���ϴ�.
        Stack<Character> sc = new Stack<>(); //Generic �� �־�����.
        //for�� �ȿ� while���� �ֱ�.

        for(char x: str.toCharArray()) {
            if(x == ')'){
                while(sc.pop()!='('); // pop���� ���� ����, ���ϵ� ���� '('�� ���ϴ� ��. �׷��ϱ� pop()�Ȱ� '(' ����, pop�� �� �Ŀ� while ���� ����ȴ�.
            }
            else sc.push(x);
        }

        for(int i=0;i<sc.size();i++) {
            answer += sc.get(i);
        }
        return answer;
    }

        public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack2 T = new Stack2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));

    }

}
