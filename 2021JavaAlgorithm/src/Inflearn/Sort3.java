package Inflearn;

import java.util.Scanner;

//삽입 정렬 구현 - 나중에 다시 해보기. 어렵다.
public class Sort3 {
    public int[] solution(int num, int[] input) {
//        int temp = 0;
//j+1이 i 이긴 한데, j 문 안에서 도니까 j+1 로 써주기.
        for (int i = 1; i < num; i++) {
            int temp = input[i]; //temp 는 4로 복사해두었기 때문에, 옮겨줄 필요가 없음.
            int j = i - 1; //j를 여기서 선언해야 input[j+1] = temp; 선언 가능.
            for (j = i - 1; j >= 0; j--) {
                if (temp < input[j]) input[j + 1] = input[j]; //ex 5번째(i) < 4번째(j)라면, 5번째(j+1)에 기존 4번째 값을 넣어줌.;//
                else break;
            }
            //j for문이 멈추고 나면 temp넣기.

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
