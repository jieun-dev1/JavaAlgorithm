package Inflearn.DFSBFSProb;

import Inflearn.DFS.DFS;

import java.util.Scanner;

//1. arr가 왜 들어가야 할까?
//2. 재귀함수를 쓸 때 static 의 의미 - ANSWER는 하나를 가리키니까, static 이어도 됨. arr, cnt, totalSum(배열 총 합) 등도 변하지 않는 값이니 static.
//3. answer 이 "No"로 시작하면, /2가 0이 아닌 경우 (총합이 홀수여서 탐색해도 답이 나오지 않을 경우)
//4. 답에서는 arr 가 인자로 들어갔지만, 안들어가도 무관하고 소요시간은 1ms 적다.

public class DFSSubset3 {
    static String answer = "NO";
    static int[] arr;
    static int cnt, totalSum = 0;
    boolean flag = false; // answer 인 지점을 찾았다면, 굳이 계속 탐색할 필요가 없다. 여부를 묻는 문제이기 때문.

    //깊이, 해당 index, sum
    public void DFS(int L,int sum) {
        if (flag == true) return; //이미 답을 찾았으니 더 진행하지 않음.
        if (sum > totalSum/2) return; //sum 이 더 크다면, 값이 절반 이상인 지점이니 return.
//        if(totalSum%2!=0) return; //더 이상 탐색 진행하지 않음. 짝수인 경우에만, else 에서 재귀함수 불러옴.
//        if (answer == "YES") return;

        if(L==cnt) {
            if(totalSum%2 ==0 && sum == totalSum/2) {
                answer = "YES";
                flag = true;
            }
        }

        else {
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }

        //L의 레벨이 곧 cnt 와 같다면, answer 를 출력해주기.

    }

    public static void main(String[] args) {
        DFSSubset3 T = new DFSSubset3();
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        arr = new int[cnt];
        for(int i=0;i<cnt;i++) {
            arr[i] = sc.nextInt();
            totalSum+=arr[i];
        }
        //출력해야 하는 값 (arr 랑 cnt 길이에 따라 다를 것)
        //T.DFS 를 System.out.println에 담음 (x) -> 재귀를 돌리면서 탐색한 후, 변경된/혹은 변경되지 않은 answer를 인쇄.
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
