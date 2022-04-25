package Inflearn;

import java.util.Scanner;

public class Sort4 {

    public int[] solution(int cache ,int size, int[] input) {
        int[] arr = new int[cache];
        for(int x: input) {
            int pos = -1;
            for (int i=0;i<cache;i++){
                if (x == arr[i]) pos = i;}
            if (pos == -1) {
                for(int i=cache-1;i>=1;i--){
                    arr[i] = arr[i-1];
                }
            }
            else {
                for(int i=pos;i>=1;i--){
                    arr[i] = arr[i-1]; //ex. arr[1]에 arr[0]값을 넣는것.
                }
            }
            arr[0] = x; //맨 앞에다가는 x 를 넣음.
        }
        return arr;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Sort4 T = new Sort4();
        Scanner sc = new Scanner(System.in);
        int cache = sc.nextInt();
        int size = sc.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = sc.nextInt();
        }
        for (int x : T.solution(cache ,size, input)) {
            System.out.print(x + " ");
        }
    }
}
