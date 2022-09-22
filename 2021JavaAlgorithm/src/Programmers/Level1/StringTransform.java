package Programmers.Level1;

import java.util.Scanner;

/*
������(����)�������� String�� Split ���� �ɰ��� �迭�� �ִ´�.
String �� ���ں��� �а� ��ȯ�Ѵ�. (CharacterArray�� �ٲٰ� �ٽ� String���� ��ȯ )

����
(1) ���ô� �ҹ��ڷ� �־�������, �ҹ��ڰ� �־����� ���� ���� ����. ��->��, ��->�� �ΰ����� ó���ؾ� ��.
String[] strArray = s.split(" ", -1);
(2) Split limit�� -1�� ���� ���� ���. �������� ������ ����� ó���� �ȵ�. -1�� ������ ������� �������� �ν��ؼ� ���ҷ� ��´�.
�ذ� �ʿ� - �� String�� �����ϰ�����, " "�� �ٽ� �־��ٱ�? �������� ������ ���� ��� ����?
 */
public class StringTransform {

    public String solution(String s) {
        String answer = "";
        String[] strArray = s.split(" ", -1); //��� ���а��� �迭 ��ȯ.
        for(int i=0;i<strArray.length;i++) {
            String str = strArray[i];//str �� ���鵵 �ν��Ѵ�.
            System.out.println(strArray[i]);
            if(str == " ") {
                answer+= str;
            }
            else {
                char[] charArr = str.toCharArray(); //charArr�� ������ �ν����� �ʴ´�.
//            for(int k=0;k< charArr.length;k++) {
//                System.out.println(charArr[k]);
//            }
                for(int j=0;j<str.length();j++) {
                    if(j%2 == 0) {
                        //�빮�ڷ� ��ȯ. (�ƽ�Ű?)
                        charArr[j] = Character.toUpperCase(charArr[j]);
                    } else {
                        charArr[j] = Character.toLowerCase(charArr[j]);
                    }
                }
                answer+= String.valueOf(charArr);//harArr.toString();//�̷��� �ϸ� ��ü ��ȣ(?) �� ����.
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
