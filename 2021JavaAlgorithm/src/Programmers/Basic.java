package Programmers;

import java.util.ArrayList;

/*
1. ���ĺ��� ��� �迭�� ����Ѵ�.
2.
 */
public class Basic {

    public static void main(String[] args) {
//ArrayList ����


// ���1: z�θ� �����. �ٽ� �ϱ�.
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
