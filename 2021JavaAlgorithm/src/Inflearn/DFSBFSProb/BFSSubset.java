package Inflearn.DFSBFSProb;

import java.util.Scanner;
//쌓여있는 Queue 를 일일이 호출하지 않고, flag 가 yes 이면 바로 return 할 수 있도록.

//return을 한다는 것은 굳이 실행시키지 않고, 넘어간다는 것.

/**
 * 만약 total이 125이면 125/2==62가 참이 됩니다. 이런 경우를 방지하기 위하여
 * if(total%2==0 && (total / 2) == sum)
 */

public class BFSSubset {
    static String answer="NO";
    static int n,total=0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr){
        if(flag) return;
        if(sum>total/2) return;
        if(L==n){
            if(total/2 == sum) {
                answer = "YES";
                flag = true;
            }

        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }

    }

    public static void main(String[] args) {
        BFSSubset T = new BFSSubset();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //해당 값을 n이 아니라 int n을 해버리면 static 의 변수를 바꾸는 게 아니어서. 재귀가 돌지 않는다. L=n=0에서 끝나버린다. n을 매개변수로 넘겨주던가, static 으로 선언해야 함.
        int[] arr = new int[n];
        for(int i=0; i<n;i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}
