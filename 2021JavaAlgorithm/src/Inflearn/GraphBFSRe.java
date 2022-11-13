package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 14. 그래프 최단거리 GRAPH BFS 문제 다시 풀기 queue와 while 룹을 BFS()안에 두는 메서드
 * <p>
 * 6 9
 * <p>
 * 1 3 1 4 2 1 2 5 3 4 4 5 4 6 6 2 6 5
 */

public class GraphBFSRe {

  static int n;
  static int m;
  static ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
  static int[] dis;

  public void BFS(int point) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(point);
    while (!queue.isEmpty()) {
      int temp = queue.poll();
      for (int i = 0; i < graphList.get(temp).size(); i++) {
        int a = graphList.get(temp).get(i);
        if (dis[a] == 0) {
          queue.offer(a);
          dis[a] = dis[temp] + 1;
        }
      }
    }
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GraphBFSRe T = new GraphBFSRe();
    n = sc.nextInt(); //정점의 수
    m = sc.nextInt(); // 간선의 수
    dis = new int[n + 1]; //check배열과 비슷한 역할을 함. n 이 초기화 되지 않았으니까 여기서 배열 할당해주기
    for (int i = 0; i < n + 1; i++) {
      graphList.add(i, new ArrayList<Integer>());
    }

    //연결 리스트로 풀기.
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graphList.get(a).add(b);
    }

    T.BFS(1);

    //i까지 가는 최단거리 인쇄 숫자 2-6까지 가는 길이 인쇄.
    for (int i = 2; i <= n; i++) {
      System.out.println(i + " : " + dis[i]);
    }
  }
}
