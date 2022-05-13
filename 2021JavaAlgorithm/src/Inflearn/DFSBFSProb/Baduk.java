package Inflearn.DFSBFSProb;

import java.util.Scanner;

/**
 * StackOverFlow 원인.
 * flag 가 static 이면 안됨. 이전 문제에서는 answer 가 있으면 flag 가 true 고 return 으로 함수 종료했지만,
 * 여기서는 모든 경로를 돌고 값을 비교해 봐야한다. flag 가 전역으로 공유되면 안됨.
 */
public class Baduk {
    static int max;
    static int answer = Integer.MIN_VALUE; // 가장 작은값으로 초기화 가능.
    static int L;
    boolean flag = false;
    public void DFS(int cl, int sum, int arr[], Boolean flag){
        if (flag == true) return;
        if(cl == L){
//            if (sum<max && sum>answer)
//                answer = sum;
            if(sum<max)
                answer = Math.max(answer, sum);//코드가 좀더 짧다.
            flag = true;
        } else {
            DFS(cl+1, sum+arr[cl],  arr, false);
            DFS(cl+1, sum, arr, false);
        }

    }
    public static void main(String[] args){
        Baduk T = new Baduk();
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        L = sc.nextInt();
        int [] arr = new int[L];
        for(int i=0;i<L;i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0, arr, false);
        System.out.println(answer);
    }
}
