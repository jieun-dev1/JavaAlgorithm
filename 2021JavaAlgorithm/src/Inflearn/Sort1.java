package Inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Sort1 {
    public int[] solution(int num, int [] input){
        int temp = 0;
        for(int i=0;i<input.length-1;i++){
            int indexMin = i; //다시 i가 증가하면서 indexMin 도 앞으로 감.
            for(int j=i+1;j<input.length;j++){
                if (input[j] < input[indexMin] ) {
                    indexMin = j;
//                    input[i] = temp;
//                    temp = input[j];
//                    input[j] = input[i];
                }
            }

            //indexMin을 구한 다음 i가 바뀌기 전에 값을 바꿔야 함.

            temp = input[i];
            input[i] = input[indexMin];
            input[indexMin] = temp;

// 아래도 가능.
//            temp = input[indexMin]; //최소 인덱스의 위치에 임시값을 넣어줌.
//            input[indexMin] = input[i]; //맨 앞자리로 가야하니까, 현재의 맨 앞값을 indexMin에 할당.
//            input[i] = temp; //앞자리에는 최소 temp를 넣어서 최소 값이 들어가게 함.
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
