package Programmers.Prac;

import java.util.Arrays;

public class Keypad {

    public String solution(int[] numbers, String hand) {
        String answer = "";
//        int[] leftLoc = new int[numbers.length+1];
//        int[] rightLoc = new int[numbers.length+1];
        String[] answerArr = new String[numbers.length];

//        leftLoc[0] = -2; //*:-2 라고 임의 지정
//        rightLoc[0] = -3; //#:-3 라고 임의 지정.
        int left = 10;
        int right = 12;
        int leftDist = 0;
        int rightDist = 0;

        for(int i=0;i<numbers.length;i++) {
            int temp = numbers[i];
            if (temp==1||temp==4||temp==7) {
                answerArr[i] = "L";
                left = temp;
            }
            else if (temp==3||temp==6||temp==9) {
                answerArr[i] = "R";
                right = temp;
            } else if(temp==2||temp==5||temp==8||temp==0) {
                /*
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
                    if(hand == "left") {
                        left = temp;
                        answerArr[i] = "L";
                    } else {
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
}
