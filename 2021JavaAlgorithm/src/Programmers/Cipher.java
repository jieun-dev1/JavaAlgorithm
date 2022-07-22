package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. ���ĺ��� ��� �迭�� �����. //���ĺ��� �� 26���̴�.
2. � �ڷ� ����? ArrayList �� �Ϲ� �迭 ����: arraylist�� �迭�� ���̸� ���� ����.
3. n ��ŭ �ε����� �о, ���Ҹ� �ٲٰ�, �ٽ� result �� ����Ѵ�.
4. ������ continue�� ������ �д´�.
5. z-> a ���� ����, �־��� ���̰� 24������,
 */
public class Cipher {

    public String solution(String s, int n) {
//        String answer = "";
        char[] upper = new char[26];
        char[] lower = new char[26];

        //['A',....'Z']
        for (char i ='A'; i<='Z';i++) {
            for(char j=0;j<26;j++) {
                upper[j] = i;
            }
        }
        //['a',....'z']
        for (char i ='a'; i<='z';i++) {
            for(char j=0;j<26;j++) {
                lower[j] = i;
            }
        }

        //�־��� String �� �迭�� ��ȯ.
        ArrayList<Character> answerChar = new ArrayList<>(); //���̰� 8000���� �ִµ� � �ڷᱸ���� ������?
        char[] givenChar = s.toCharArray();

        //char[Array]�� i ��° ���Ҹ� ã��.
        //if �ҹ��ڶ��, lower�� / �빮�ڶ�� upper ����
        //charArray���� �־��� ���� upper �迭 �� ��ġ�� ã�´�. �ε����� n �߰��ؼ� �ٽ� �Ҵ��Ѵ�.
        //���� n+�ε����� 26�̻��̶��, 26�� ���� ��ȯ�Ѵ�.
        for(int i=0;i<givenChar.length;i++) {
            //���� �ε������� ã�� (temp)
            if(Character.isUpperCase(givenChar[i])) {
                int temp = Arrays.asList(upper).indexOf(givenChar[i]);
                if(temp+n<26) {
                    answerChar.add(upper[temp+n]);
                } else {
                    answerChar.add(upper[temp+n-26]);
                }
            }
//
//            else if (Character.isWhitespace(givenChar[i])) {
//                answerChar.add(givenChar[i]);
//            }
            else {
                int temp = Arrays.asList(lower).indexOf(givenChar[i]);
                if(temp+n<26) {
                    answerChar.add(lower[temp+n]);
                } else {
                    answerChar.add(lower[temp+n-26]);
                }
            }
        }
        String answer = answerChar.toString();
        //char �迭�� String ���� ��ȯ�ؼ� ��ȯ.
        return answer;
    }

}
