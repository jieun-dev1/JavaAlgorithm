package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Sort1 {
    public int[] solution(int num, int [] input){
        int temp = 0;
        for(int i=0;i<input.length-1;i++){
            int indexMin = i; //�ٽ� i�� �����ϸ鼭 indexMin �� ������ ��.
            for(int j=i+1;j<input.length;j++){
                if (input[j] < input[indexMin] ) {
                    indexMin = j;
//                    input[i] = temp;
//                    temp = input[j];
//                    input[j] = input[i];
                }
            }

            //indexMin�� ���� ���� i�� �ٲ�� ���� ���� �ٲ�� ��.

            temp = input[i];
            input[i] = input[indexMin];
            input[indexMin] = temp;

// �Ʒ��� ����.
//            temp = input[indexMin]; //�ּ� �ε����� ��ġ�� �ӽð��� �־���.
//            input[indexMin] = input[i]; //�� ���ڸ��� �����ϴϱ�, ������ �� �հ��� indexMin�� �Ҵ�.
//            input[i] = temp; //���ڸ����� �ּ� temp�� �־ �ּ� ���� ���� ��.
        }

        return input;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sort1 T = new Sort1();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] input = new int[num];
        for(int i=0;i<num;i++){
            input[i] = sc.nextInt();
        }
        for (int x: T.solution(num, input)){
            System.out.print(x+" ");
        }
    }
}
