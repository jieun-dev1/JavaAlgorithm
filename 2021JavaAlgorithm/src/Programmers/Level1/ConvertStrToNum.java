package Programmers.Level1;


/*
���ڸ� String ���� ��ȯ: Integer.toString�� toString(), Integer.toString(int i)���� ���·� ��� ����. �Ѵ� ��ȯ ����� �Ȱ���.
String�� ���ڷ� ��ȯ Integer.parseInt() [primitive int type]  or Integer.valueOf()[Integer object]
replaceAll �δ� ���Խ��� ����� �� �ִ�.

�׳� s�� ���� numberformatException ������ ��(replace �Լ��� ����� ���� �ʾұ� ������)
numberformatException�� ���ڸ� �־����� �ƴ϶�, ����+���ڿ� ����, ���ڿ� ���� �־����� ��, ���ڿ��� ���������� �ٲ� �� ��� ���� ������.
S = s.replace()�� ȣ���ؼ� ���Ҵ������ ��.

����� ��
�Է�: "one4seveneight"
���: 1478
 */

import java.util.Scanner;

public class ConvertStrToNum {
    public int solution(String s) {
        int answer = 0;
        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0;i<arr.length;i++) {
            //���� zero == 0 . arr[i]�� �����ϸ� ��ü���شٴ� ��.
           s = s.replace(arr[i],Integer.toString(i));
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConvertStrToNum T = new ConvertStrToNum();

        String s = sc.nextLine();
        System.out.println(T.solution(s));
    }
}
