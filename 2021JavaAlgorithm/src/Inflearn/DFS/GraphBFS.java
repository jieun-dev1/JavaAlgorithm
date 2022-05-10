package Inflearn.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 다시 풀 것.
 *
 * BFS최단거리 (최단거리 구할 때는 BFS!)
 * 문득 재귀는 bfs, dfs 중에 뭐지? 싶었는데,
 * 둘다 재귀함수 쓸 수 있다. 다만 bfs 에서는 Queue 로 구현하고,
 * DFS 는 스택 프레임 기반으로 동작한다.
 * BFS 는 Queue 클래스를 쓰지만, DFS는 스택 프레임을 쓰기 때문에 Stack 클래스를
 * 생성하지 않고도 풀리는 경우가 많다. 이거는 풀면서 더 파악해보기.
 *
 * 그래프와 트리의 차이점?
 * 트리는 두 개의 정점 사이 하나의 경로.
 * 그래프 단방향/양방향이 가능.
 * 트리는 하나의 루트 노드. 모든 자식은 단 하나의 부모만 갖는다.
 * 그래서 그래프랑 트리는 다른 구조.
 * 그래프는 인접 행렬/인접 리스트로 품.
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
            for(int nv: graph.get(cv)){ //cv의 인접 리스트들을 가봄. 어떻게 가장 짧은 거리가 되지? 인접 리스트 = 바로 연결.
                // 이미 더 짧은 배열에서 1을 지정하면, 체크 배열 [4]가 1 처리가 됨. 1-3-4를 굳이 길게 갈 필요 x
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
        n = sc.nextInt(); //노드의 갯수.
        m = sc.nextInt(); //간선의 갯수.
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
        ch[1] = 1; //1부터 시작하기 떄문에.
        T.BFS(1);
        for(int i=2;i<=n;i++){
            System.out.println(i +" : "+dis[i]); //1-2, 1-3 등으로 가는 최단 거리. dis 배열을 인쇄해주면 됨.
        }
    }
}
