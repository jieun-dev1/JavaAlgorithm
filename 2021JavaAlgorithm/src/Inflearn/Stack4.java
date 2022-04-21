package Inflearn;

import java.util.Scanner;
import java.util.Stack;

//Character.isDigit(x)==true 이면 숫자.
//false 이면 문자임.
public class Stack4 {

    public int solution(String str){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(char x:str.toCharArray()){
            if (Character.isDigit(x)==true) {
                stack.push(x-48);
            }

            else {
                int rt = stack.pop();
                int lt = stack.pop();

                if (x =='+') {
                    stack.push(lt+rt);
                }

                if (x =='*') {
                    stack.push(lt*rt);
                }

                if (x =='-') {
                    stack.push(lt-rt);
                }

                if (x =='/') {
                    stack.push(lt/rt);
                }
            }

        }

        return stack.pop();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack4 T = new Stack4();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));

    }
}
