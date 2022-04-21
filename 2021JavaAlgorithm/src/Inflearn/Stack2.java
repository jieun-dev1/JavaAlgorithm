package Inflearn;

import java.util.*;

//이 문제는 괄호가 무조건 성립한다는 전제로 시작.
//sc.pop()과 get(i)를 활용할 수 있는지.
public class Stack2 {

    public String solution(String str) {
        String answer = ""; //answer도 String이어서. 그냥 + 연산으로 넣어줘도 될 듯하다.
        Stack<Character> sc = new Stack<>(); //Generic 꼭 넣어주자.
        //for문 안에 while문을 넣기.

        for(char x: str.toCharArray()) {
            if(x == ')'){
                while(sc.pop()!='('); // pop으로 꺼낸 다음, 리턴된 값과 '('를 비교하는 것. 그러니까 pop()된게 '(' 더라도, pop이 된 후에 while 문이 종료된다.
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
