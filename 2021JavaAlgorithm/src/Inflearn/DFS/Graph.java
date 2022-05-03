package Inflearn.DFS;

import java.util.Scanner;

/**
 * �׷������� �ѹ� �湮�� ������ �ٽ� �湮�ϸ� �ȵ�. check �迭 �����.
 * ����Լ��� �湮�� �Լ��� �׻� üũ�����.
 * back �� ���� check Ǯ����� ��.
 *
 * ��� �ߺ� ȣ�� �߻����� �ʴ°���? 5�� üũ �迭���� ����� 4�� ���ƿ��� �� �ٽ� 5�� ���ư��� ���(?) �� �Ͼ�� �ʴ°���.. �𸣰ڴ�.
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
                    DFS(i);
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