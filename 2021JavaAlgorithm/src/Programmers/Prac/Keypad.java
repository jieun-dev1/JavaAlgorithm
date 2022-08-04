package Programmers.Prac;

import java.util.Arrays;
import java.util.Scanner;

/*
����
(1) 0�� 11�� �ٲ�
(2) String ���ڿ��� ���� ���� == �� �ƴ�, equal()�� ����.
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
            //�Ʒ��� ������ ������, 0�� ��ġ�� 11�� ���� ������ ��.
            if(temp == 0) {
                temp = 11;
            }
            //Ű�е� ���� ������ "L"��
            if (temp==1||temp==4||temp==7) {
                answerArr[i] = "L";
                left = temp;
            }
            //Ű�е� ������ �ѹ����� "R"��
            else if (temp==3||temp==6||temp==9) {
                answerArr[i] = "R";
                right = temp;
            //Ű�е� ��� ����
            } else if(temp==2||temp==5||temp==8||temp==11) {
                /*
                (1)
                distance �� ���Ѵ�.
                3�� ���� ���� 1�̶�� ���� ���� �ִ� ���̴�.
                Dist�� �� ���� ���� ���� �ȴ�.
                ������ ��ȯ�Ѵ�.
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
                    //�ڹٿ����� string�� �ƴ϶� equals()�� ���ڿ� ��
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
