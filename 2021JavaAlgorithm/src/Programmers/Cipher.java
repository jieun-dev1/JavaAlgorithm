package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
3��: ���α׷��ӽ� ����
(1) Ȱ��: �ƽ�Ű �ڵ�
�ƽ�Ű �ڵ带 ���ϰ� (char)�� ���ָ� �ٽ� ĳ���� ��ȯ�� �����ϴ�.
char ��, 'c'-2 = 2; �� ����� �ȴ�. charŸ���� ���ڰ� ����ȴٱ⺸��, 2byteũ���� ���������� �����Ѵ�
(�����ϴ� �����ڵ� ���ڰ� ����Ѵٰ� �����ϱ�)

������ ����, �������� ���ȴ�. https://devlog-wjdrbs96.tistory.com/76
'��' sms
(2) ��Ʈ���� += �� �����൵ �ȴ�.
*/


public class Cipher {
    public String solution(String s, int n) {
//        String answer = "";
        ArrayList<Character> upper = new ArrayList<>();
        ArrayList<Character> lower = new ArrayList<>();

        //['A',....'Z']
        for (char i = 'A'; i <= 'Z'; i++) {
            upper.add(i);
        }
        //['a',....'z']
        for (char i = 'a'; i <= 'z'; i++) {
            lower.add(i);
        }

        //�־��� String �� �迭�� ��ȯ.
        ArrayList<Character> answerChar = new ArrayList<>(); //���̰� 8000���� �ִµ� � �ڷᱸ���� ������?
        char[] givenChar = s.toCharArray();

        //char[Array]�� i ��° ���Ҹ� ã��.
        //if �ҹ��ڶ��, lower�� / �빮�ڶ�� upper ����
        //charArray���� �־��� ���� upper �迭 �� ��ġ�� ã�´�. �ε����� n �߰��ؼ� �ٽ� �Ҵ��Ѵ�.
        //���� n+�ε����� 26�̻��̶��, 26�� ���� ��ȯ�Ѵ�.
        for (int i = 0; i < givenChar.length; i++) {
            //���� �ε������� ã�� (temp)
            if (Character.isUpperCase(givenChar[i])) {
                int temp = upper.indexOf(givenChar[i]);
                if (temp + n < 26) {
                    answerChar.add(upper.get(temp + n));
                } else {
                    answerChar.add(upper.get(temp + n - 26));
                }
            }
//
            else if (Character.isWhitespace(givenChar[i])) {
                answerChar.add(givenChar[i]);
            } else {
                int temp = lower.indexOf(givenChar[i]);
                if (temp + n < 26) {
                    answerChar.add(lower.get(temp + n));
                } else {
                    answerChar.add(lower.get(temp + n - 26));
                }
            }
        }
        String answer = "";
        for (int i = 0; i < answerChar.size(); i++) {
            answer += answerChar.get(i);
        }
        //char �迭�� String ���� ��ȯ�ؼ� ��ȯ.
        return answer;
    }
}

