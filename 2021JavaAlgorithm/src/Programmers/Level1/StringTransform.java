package Programmers.Level1;

import java.util.Scanner;

/*
구분자(띄어쓰기)기준으로 String을 Split 으로 쪼개서 배열에 넣는다.
String 을 글자별로 읽고 변환한다. (CharacterArray로 바꾸고 다시 String으로 변환 )

주의
(1) 예시는 소문자로 주어졌지만, 소문자가 주어지지 않을 수도 있음. 대->소, 소->대 두가지를 처리해야 함.
String[] strArray = s.split(" ", -1);
(2) Split limit에 -1을 넣지 않을 경우. 마지막에 공백이 생기면 처리가 안됨. -1을 넣으면 후행까지 공백으로 인식해서 원소로 삼는다.
해결 필요 - 왜 String을 구분하고나서도, " "를 다시 넣어줄까? 여러개가 공백인 경우는 어떻게 하지?
 */
public class StringTransform {

    public String solution(String s) {
        String answer = "";
        String[] strArray = s.split(" ", -1); //모든 구분값을 배열 반환.
        for(int i=0;i<strArray.length;i++) {
            String str = strArray[i];//str 는 공백도 인식한다.
            System.out.println(strArray[i]);
            if(str == " ") {
                answer+= str;
            }
            else {
                char[] charArr = str.toCharArray(); //charArr는 공백을 인식하지 않는다.
//            for(int k=0;k< charArr.length;k++) {
//                System.out.println(charArr[k]);
//            }
                for(int j=0;j<str.length();j++) {
                    if(j%2 == 0) {
                        //대문자로 변환. (아스키?)
                        charArr[j] = Character.toUpperCase(charArr[j]);
                    } else {
                        charArr[j] = Character.toLowerCase(charArr[j]);
                    }
                }
                answer+= String.valueOf(charArr);//harArr.toString();//이렇게 하면 객체 번호(?) 가 나옴.
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTransform T = new StringTransform();
        String input = sc.nextLine();
        System.out.println(T.solution(input));

    }
}
