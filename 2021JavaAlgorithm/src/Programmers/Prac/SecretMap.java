package Programmers.Prac;


/*
https://school.programmers.co.kr/learn/courses/30/lessons/17681

Integer.toBinaryString: ���� ���ڿ��� 2���� �������� �ٲ�.
Integer.parseInt: ���� ���ڿ��� ���������� �ٲ�.
%5d - 5�ڸ� ǥ�� -> �ڿ����� 5�ڸ� �̸��̶�� �������� ǥ��
Integer.parseInt ���� �ʰ� -> Long.parseLong();
int ������ �ʰ��Ǹ� �ڵ����� Long���� promote �ȴ�. https://stackoverflow.com/questions/24590725/java-parseint-vs-parselong
 */

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {

        String [] answer = new String[n];
        //���ڸ� ��ȯ.String���� �ٲ㼭.
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i]; //1�� �ϳ��� ������ 1�� ��ȯ. ��� �迭�� �ش��ϴ� ���� ����.
//            String tempBinary = Integer.toBinaryString(temp); �������� ��ȯ�� ��������, 5�ڸ��� �°� 0�� �ٿ����� �ʴ´�.
            String tempBinary = String.format("%0"+n+"d", Long.parseLong((Integer.toBinaryString(temp))));
            String answer1 = new String();
            for (int j = 0; j < tempBinary.length(); j++) {
                if(tempBinary.charAt(j) == '1') {
                    answer1+='#';
                } else {
                    answer1+= ' ';
                }
            }
            answer[i] = answer1;
        }
            //��� �迭�� �����������,
        return answer;
    }

}
