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
        String answer = "";
        n = n%26; //26이 넘을 때, -26을 해주는 것보다 나머지로 계산하기.

//        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            char temp = s.charAt(i); // String 을 charArray로 바꾸지 않고도, charAt을 쓰면 특정 인덱스의 Character 반환 가능.
            if(Character.isLowerCase(temp)) {
                temp = (char) ((temp -'a'+n) % 26 +'a');
            } else if(Character.isUpperCase(temp)){
                temp = (char) ((temp -'A'+n) % 26 +'A');
            }
            answer += temp; //공백일 경우 분기처리 없이 그대로 더해주자.
        }
        return answer;

        }
    }
