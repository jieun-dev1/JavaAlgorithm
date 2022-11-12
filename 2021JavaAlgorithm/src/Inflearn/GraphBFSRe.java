package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 14. 그래프 최단거리
 * GRAPH BFS 문제 다시 풀기
 * <p>
 * 6 9
 * <p>
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 */

public class GraphBFSRe {

  static int n;
  static int m;
  static ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
  static int[] dis;
//  static int[] ch = new int[n+1];
  static Queue<Integer> queue = new LinkedList<>();

  public void BFS(int point){
      for(int i=0;i<graphList.get(point).size();i++){
        int a = graphList.get(point).get(i);
        if(dis[a]==0){
          queue.offer(a);
          dis[a] = dis[point]+1;
        }
      }
    }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GraphBFSRe T = new GraphBFSRe();
    n = sc.nextInt(); //정점의 수
    m = sc.nextInt(); // 간선의 수
    dis  = new int[n+1]; //check배열과 비슷한 역할을 함. n 이 초기화 되지 않았으니까 여기서 배열 할당해주기
    for(int i=0;i<n+1;i++){
      graphList.add(i, new ArrayList<Integer>());
    }

    //연결 리스트로 풀기.
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graphList.get(a).add(b);
    }

    queue.offer(1);
    while(!queue.isEmpty()){
      T.BFS(queue.poll()); //1을 직접 넣는 게 아니라 pueue에서 poll()을 넣기.
    }

    //i까지 가는 최단거리 인쇄 숫자 2-6까지 가는 길이 인쇄.
    for (int i = 2; i <= n; i++) {
      System.out.println(i + " : "+ dis[i]);
    }
  }
}
