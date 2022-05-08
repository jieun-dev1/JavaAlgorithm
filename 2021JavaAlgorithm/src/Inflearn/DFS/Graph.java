package Inflearn.DFS;

import java.util.Scanner;

/**
 * 그래프에서 한번 방문한 지점은 다시 방문하면 안됨. check 배열 만들기.
 * 재귀함수는 방문한 함수는 항상 체크해줘야.
 * back 할 떄는 check 풀어줘야 함.
 *
 * 어떻게 중복 호출 발생하지 않는건지? 5를 체크 배열에서 지우고 4로 돌아오면 왜 다시 5로 돌아가는 재귀(?) 가 일어나지 않는건지.. 모르겠다.
 * ch[i]가 DFS(i) 뒤에 있기 때문이다. 1-2를 거치고 다시 1로 돌아왔을 때, ch[2]는 1이다. 그러니 다시 ch[i]=1하는 무한반복이 일어나지 x.
 * 2차원 배열은 100개라고 하면 10000개 이기 떄문에 데이터 소모가 크고 비효율적. 인접 리스트 방식: 리스트 길이만큼만 돈다.
 */

public class Graph {
    static int n, m;
    static int[][] route;
    static int[] ch;
    static int answer = 0;

    public void DFS(int v){
        if (v == n) answer ++;
        else {
             for(int i=1;i<=n;i++){
                if (route[v][i] == 1 && ch[i]!=1) {
                    ch[i] = 1;
                    DFS(i); //재귀가 끝나면 CH[i] = 0으로 넘어갈 수 있음.
                    ch[i] = 0;
                }
        }
        }
    }

    public static void main(String[] args){
        Graph T = new Graph();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        route = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            route[a][b] = 1;
        }

        ch[1] = 1;
        T.DFS(1);
        System.out.println(answer);
    }
}

/**
 * input
 *
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */