package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
1. 알파벳이 담긴 배열을 만든다. //알파벳은 총 26개이다.
2. 어떤 자료 구조? ArrayList 와 일반 배열 차이: arraylist는 배열의 길이를 조정 가능.
3. n 만큼 인덱스를 밀어서, 원소를 바꾸고, 다시 result 로 출력한다.
4. 공백은 continue로 다음을 읽는다.
5. z-> a 같은 경우는, 주어진 길이가 24였따면,
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

        //주어진 String 을 배열로 변환.
        ArrayList<Character> answerChar = new ArrayList<>(); //길이가 8000까지 있는데 어떤 자료구조를 만들지?
        char[] givenChar = s.toCharArray();

        //char[Array]의 i 번째 원소를 찾고.
        //if 소문자라면, lower를 / 대문자라면 upper 참조
        //charArray에서 주어진 값의 upper 배열 내 위치를 찾는다. 인덱스를 n 추가해서 다시 할당한다.
        //만약 n+인덱스가 26이상이라면, 26을 빼서 반환한다.
        for(int i=0;i<givenChar.length;i++) {
            //현재 인덱스부터 찾기 (temp)
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
        //char 배열을 String 으로 변환해서 반환.
        return answer;
    }

}
