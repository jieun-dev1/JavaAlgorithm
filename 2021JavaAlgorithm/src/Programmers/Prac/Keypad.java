package Programmers.Prac;

import java.util.Arrays;
import java.util.Scanner;

/*
수정
(1) 0을 11로 바꿈
(2) String 문자열을 비교할 때는 == 이 아닌, equal()를 쓴다.
 */
public class Keypad {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        String[] answerArr = new String[numbers.length];

        int left = 10;
        int right = 12;
        int leftDist = 0;
        int rightDist = 0;

        for(int i=0;i<numbers.length;i++) {
            int temp = numbers[i];
            //아래의 계산법을 쓰려면, 0의 위치는 11의 값을 가져야 함.
            if(temp == 0) {
                temp = 11;
            }
            //키패드 왼쪽 수에는 "L"을
            if (temp==1||temp==4||temp==7) {
                answerArr[i] = "L";
                left = temp;
            }
            //키패드 오른쪽 넘버에는 "R"을
            else if (temp==3||temp==6||temp==9) {
                answerArr[i] = "R";
                right = temp;
            //키패드 가운데 수는
            } else if(temp==2||temp==5||temp==8||temp==11) {
                /*
                (1)
                distance 를 구한다.
                3을 나눈 몫이 1이라면 같은 열에 있는 것이다.
                Dist가 더 작은 값이 답이 된다.
                절댓값을 반환한다.
                 */
                leftDist = (int) Math.abs(temp-left)/3 + (int) Math.abs(temp-left)%3;
                rightDist = (int) Math.abs(temp-right)/3 + (int) Math.abs(temp-right)%3;

                if (leftDist>rightDist) {
                    right = temp;
                    answerArr[i] = "R";
                } else if (leftDist < rightDist){
                    left = temp;
                    answerArr[i] = "L";
                } else if (leftDist == rightDist) {
                    //자바에서는 string이 아니라 equals()로 문자열 비교
                    if(hand.equals("left")) {
                        left = temp;
                        answerArr[i] = "L";
                    } else if (hand.equals("right")) {
                        right = temp;
                        answerArr[i] = "R";
                    }
                }
            }
        }
        for(int i=0;i<answerArr.length;i++) {
            answer+=answerArr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Keypad T = new Keypad();
        int numbersLen = sc.nextInt();
        int[] numbers = new int[numbersLen];
        for(int i=0;i<numbersLen;i++) {
            numbers[i] = sc.nextInt();
        }
        String hand = sc.next();
        System.out.println(T.solution(numbers, hand));
    }
}
