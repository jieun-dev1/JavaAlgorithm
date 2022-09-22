package Programmers.Level1;

import java.util.Arrays;

/*
2���� �迭�� �о�´�. 2���� �迭�� i��° ���Ҹ� ������.
1��° ������ i(first)�� j(second)�� �о�´�. array[i-1:j-1] �� �����´�.
������ ������ �����Ѵ�.
k��° ���ڸ� �μ��Ѵ�.
int[] result = new int[commands.length]. result �迭�� �ϳ��� �ֱ�.

����
(1) Arrays.asList;//�迭�� ArrayList �� ��ȯ���ִ� �� (ȥ���ؼ� ����� ���)
(2) Arrays.copyOfRange(array, ����, �� +1); �ε����� 0���� �����ϴϱ�, (�־��� ���� ����-1, �� ����)


 */
public class NumK {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; //�־��� Commands �� ����(����)��ŭ return ���� ����.

        for(int i=0;i<commands.length;i++) {
            int first = commands[i][0];
            int second = commands[i][1];
            int k = commands[i][2];
            int[] arr2 = Arrays.copyOfRange(array, first-1, second);
            Arrays.sort(arr2);//������������ ��������.
//            for(int j=0;i<arr2.length;i++) {
//                System.out.println(arr2[i]);
//            }
            answer[i] = arr2[k-1]; //arr2�� �ε����� �ؼ�, answer�� ���� �־���� ��.
        }
            return answer;
    }

}
