package Inflearn.DFSBFSProb;

import java.util.Scanner;
//테스트 int max (한도), L(강아지 갯수) 를 매개변수로 바꿨을 때.
//176ms  - static 변수로 했을 떄 비교 2ms 느림.

public class Baduk5 {

        static int answer = Integer.MIN_VALUE;
        public void DFS(int cl, int sum, int arr[], int max, int L) {
            if(sum > max) return;
            if(cl == L){
                answer = Math.max(answer, sum);
            }
            else {
                DFS(cl+1, sum+arr[cl], arr, max, L);
                DFS(cl+1, sum, arr, max, L);
            }
        }

        public static void main(String[] args){
            Baduk5 T = new Baduk5 ();
            Scanner sc = new Scanner(System.in);
            int max = sc.nextInt();
            int L = sc.nextInt();
            int [] arr = new int[L];
            for(int i=0;i<L;i++){
                arr[i] = sc.nextInt();
            }
            T.DFS(0, 0, arr, max, L);
            System.out.println(answer);
        }
    }
