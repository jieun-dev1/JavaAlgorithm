package Programmers;

import java.util.ArrayList;
import java.util.Arrays;

/*
3차: 프로그래머스 정답
(1) 활용: 아스키 코드
아스키 코드를 구하고 (char)를 해주면 다시 캐릭터 변환이 가능하다.
char 는, 'c'-2 = 2; 로 계싼이 된다. char타입은 문자가 저장된다기보다, 2byte크기의 양의정수를 저장한다
(대응하는 유니코드 문자가 출력한다고 생각하기)

연산할 때도, 정수값이 사용된다. https://devlog-wjdrbs96.tistory.com/76
'ㅁ' sms
(2) 스트링은 += 로 더해줘도 된다.
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

        //주어진 String 을 배열로 변환.
        ArrayList<Character> answerChar = new ArrayList<>(); //길이가 8000까지 있는데 어떤 자료구조를 만들지?
        char[] givenChar = s.toCharArray();

        //char[Array]의 i 번째 원소를 찾고.
        //if 소문자라면, lower를 / 대문자라면 upper 참조
        //charArray에서 주어진 값의 upper 배열 내 위치를 찾는다. 인덱스를 n 추가해서 다시 할당한다.
        //만약 n+인덱스가 26이상이라면, 26을 빼서 반환한다.
        for (int i = 0; i < givenChar.length; i++) {
            //현재 인덱스부터 찾기 (temp)
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
        //char 배열을 String 으로 변환해서 반환.
        return answer;
    }
}

