package Programmers;

import java.util.ArrayList;

/*
1. 알파벳이 담긴 배열을 출력한다.
2.
 */
public class Basic {

    public static void main(String[] args) {
//ArrayList 적용


// 방법1: z로만 저장됨. 다시 하기.
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();

        //['A',....'Z']
        for (char i ='A'; i<='Z';i++) {
            upper.add(i);
        }
        //['a',....'z']
        for (char i ='a'; i<='z';i++) {
            lower.add(i);
        }

        for(int i=0;i<upper.size();i++) {
            System.out.println(upper.get(i));
        }
    }
}
