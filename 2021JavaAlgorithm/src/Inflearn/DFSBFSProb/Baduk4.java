package Inflearn.DFSBFSProb;

import java.util.Scanner;
//174ms - if (sum>max)가 10ms 쯤 단축시켜줌. an
//boolean flag 필요 x 유무와 상관없이 모두 돌기 때문. 답을 찾으면, return 해서 종료하는 경우가 아니고 모두 돌앗.
public class Baduk4 {

    static int answer = Integer.MIN_VALUE, max, L;
    public void DFS(int cl, int sum, int arr[]) {
        if(sum > max) return;
        if(cl == L){
            answer = Math.max(answer, sum);
        }
        else {
            DFS(cl+1, sum+arr[cl], arr);
            DFS(cl+1, sum, arr);
        }
    }

    public static void main(String[] args){
        Baduk4 T = new Baduk4();
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        L = sc.nextInt();
        int [] arr = new int[L];
        for(int i=0;i<L;i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}

//
//테스트 int max (한도), L(강아지 갯수) 를 매개변수로 바꿨을 때.
//176ms  - static 변수로 했을 떄 비교 2ms 느림.
