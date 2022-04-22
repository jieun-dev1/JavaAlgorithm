package Inflearn;

import java.util.*;

public class Sort2 {
    public int[] solution(int num, int[] input){
        int n = input.length;
        //0부터 이어지는 j의 범위가 줄어드는 것.
        //i가 j의 범위를 조절하는 데 쓰일 수도 있구나.
        for (int i=0;i<n-1;i++) {
            for (int j=0;j<n-i-1;j++){
                int temp = 0;
                if(input[j]>input[j+1]) {
                    temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }
        }

        return input;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sort2 T = new Sort2();
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
