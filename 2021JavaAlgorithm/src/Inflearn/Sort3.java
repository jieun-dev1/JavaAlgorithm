package Inflearn;

import java.util.Scanner;

//���� ���� ���� - ���߿� �ٽ� �غ���. ��ƴ�.
public class Sort3 {
    public int[] solution(int num, int[] input) {
//        int temp = 0;
//j+1�� i �̱� �ѵ�, j �� �ȿ��� ���ϱ� j+1 �� ���ֱ�.
        for (int i = 1; i < num; i++) {
            int temp = input[i]; //temp �� 4�� �����صξ��� ������, �Ű��� �ʿ䰡 ����.
            int j = i - 1; //j�� ���⼭ �����ؾ� input[j+1] = temp; ���� ����.
            for (j = i - 1; j >= 0; j--) {
                if (temp < input[j]) input[j + 1] = input[j]; //ex 5��°(i) < 4��°(j)���, 5��°(j+1)�� ���� 4��° ���� �־���.;//
                else break;
            }
            //j for���� ���߰� ���� temp�ֱ�.

            input[j + 1] = temp;
        }
        return input;

    }


        public static void main(String[] args) {
            // TODO Auto-generated method stub
            Sort3 T = new Sort3();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int[] input = new int[num];
            for (int i = 0; i < num; i++) {
                input[i] = sc.nextInt();
            }
            for (int x : T.solution(num, input)) {
                System.out.print(x + " ");
            }
        }
    }
