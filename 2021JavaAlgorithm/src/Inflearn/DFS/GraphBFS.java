package Inflearn.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * �ٽ� Ǯ ��.
 *
 * BFS�ִܰŸ� (�ִܰŸ� ���� ���� BFS!)
 * ���� ��ʹ� bfs, dfs �߿� ����? �;��µ�,
 * �Ѵ� ����Լ� �� �� �ִ�. �ٸ� bfs ������ Queue �� �����ϰ�,
 * DFS �� ���� ������ ������� �����Ѵ�.
 * BFS �� Queue Ŭ������ ������, DFS�� ���� �������� ���� ������ Stack Ŭ������
 * �������� �ʰ� Ǯ���� ��찡 ����. �̰Ŵ� Ǯ�鼭 �� �ľ��غ���.
 *
 * �׷����� Ʈ���� ������?
 * Ʈ���� �� ���� ���� ���� �ϳ��� ���.
 * �׷��� �ܹ���/������� ����.
 * Ʈ���� �ϳ��� ��Ʈ ���. ��� �ڽ��� �� �ϳ��� �θ� ���´�.
 * �׷��� �׷����� Ʈ���� �ٸ� ����.
 * �׷����� ���� ���/���� ����Ʈ�� ǰ.
 */

public class GraphBFS {
    static int n,m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void BFS(int v){
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);
        while(!queue.isEmpty()){
            int cv = queue.poll();
            for(int nv: graph.get(cv)){ //cv�� ���� ����Ʈ���� ����. ��� ���� ª�� �Ÿ��� ����? ���� ����Ʈ = �ٷ� ����.
                // �̹� �� ª�� �迭���� 1�� �����ϸ�, üũ �迭 [4]�� 1 ó���� ��. 1-3-4�� ���� ��� �� �ʿ� x
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv]= dis[cv]+1;
                }
            }
        }
    }

    public static void main(String[] args){
        GraphBFS T = new GraphBFS();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //����� ����.
        m = sc.nextInt(); //������ ����.
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        dis = new int[n+1];
        for (int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1; //1���� �����ϱ� ������.
        T.BFS(1);
        for(int i=2;i<=n;i++){
            System.out.println(i +" : "+dis[i]); //1-2, 1-3 ������ ���� �ִ� �Ÿ�. dis �迭�� �μ����ָ� ��.
        }
    }
}
