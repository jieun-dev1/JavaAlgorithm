package Inflearn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 14. �׷��� �ִܰŸ� GRAPH BFS ���� �ٽ� Ǯ�� queue�� while ���� BFS()�ȿ� �δ� �޼���
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
    n = sc.nextInt(); //������ ��
    m = sc.nextInt(); // ������ ��
    dis = new int[n + 1]; //check�迭�� ����� ������ ��. n �� �ʱ�ȭ ���� �ʾ����ϱ� ���⼭ �迭 �Ҵ����ֱ�
    for (int i = 0; i < n + 1; i++) {
      graphList.add(i, new ArrayList<Integer>());
    }

    //���� ����Ʈ�� Ǯ��.
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      graphList.get(a).add(b);
    }

    T.BFS(1);

    //i���� ���� �ִܰŸ� �μ� ���� 2-6���� ���� ���� �μ�.
    for (int i = 2; i <= n; i++) {
      System.out.println(i + " : " + dis[i]);
    }
  }
}
