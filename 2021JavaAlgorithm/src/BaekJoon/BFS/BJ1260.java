package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * �ҿ�ð�: �� 3�ð�.
 */
public class BJ1260 {
  static int point;
  //�ش� ������ �湮�ߴ��� �Ǻ��� - point ��ŭ üũ �迭. �迭�̶� answer�� dfs bfs ���� ����Ѵ�.
  static int[] ch;
  static int[] bfsCh;

  static int connect;
  static ArrayList<ArrayList<Integer>>  list = new ArrayList<>();;
  static ArrayList<Integer> dfsAnswer = new ArrayList<>();

  static Queue<Integer> bfsQueue = new LinkedList<>();
  static ArrayList<Integer> bfsAnswer = new ArrayList<>();


  public void DFS(int start){
    //exit ������ ������ ��� ��ȸ���� �� �� answer�� ����� point�� ���� ��.
    if(dfsAnswer.size()==point){
      return;
    }
   ArrayList<Integer> temp = list.get(start-1);
    for(int i=0;i<temp.size();i++){
      int x = temp.get(i);
      if(ch[x]==0){
        dfsAnswer.add(x);
        ch[x]=1;
        DFS(x);
      } else {
        continue;
      }
    }
  }

  public void BFS(){
    while(!bfsQueue.isEmpty()){
      if(bfsAnswer.size()==point){
        return;
      }
      int element = bfsQueue.poll();
      ArrayList<Integer> temp = list.get(element-1);
      for(int i=0;i<temp.size();i++){
        int x = temp.get(i);
        if(bfsCh[x]==0){
          bfsAnswer.add(x);
          bfsQueue.add(x);
          bfsCh[x]=1; //1�� �ٲ�� ���ѹݺ��� ���� �ʴ´�.
        }
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    point = Integer.parseInt(st.nextToken()); //������ ����
    ch = new int[point+1]; //������ ���߿� �־��� ���� ���Ŀ� �Ҵ��ؾ� ��. �ε��� ó���ϱ� �������� +1�� �����
    bfsCh = new int[point+1];
    connect = Integer.parseInt(st.nextToken()); // ������ ����
    int start = Integer.parseInt(st.nextToken()); //������

    //���� ����Ʈ �ʱ�ȭ�� �Ϸ��� �ѹ� for���� ���鼭 ���� ���Ҹ� ������� ��.
    for(int i=0;i<point;i++){
      list.add(new ArrayList<Integer>());
    }
    //����� ���� ����
    for(int i=0;i<connect;i++){
      st = new StringTokenizer(br.readLine());
      int pointS = Integer.parseInt(st.nextToken());
      int pointE = Integer.parseInt(st.nextToken());
      list.get(pointS-1).add(pointE);
      list.get(pointE-1).add(pointS);
    }

    //��ȣ�� ���� ���� ���� �湮�ϱ� ������ �� ���� �� ����Ʈ�� ������������ ����.
    for(int i=0;i< list.size();i++){
      Collections.sort(list.get(i)); //������������ ����.
    }

    //DFS �� �ֱ� (����) - �� ���Ϲޱ�
    BJ1260 T = new BJ1260();
    ch[start]=1;
    dfsAnswer.add(start); //����: ó���� add(1)�̾�����, ������ start�� 1������ �̴� �׻� ���ϴ� ���̴�.
    T.DFS(start);
    StringBuilder dfsSt = new StringBuilder("");
    for(int i=0;i<dfsAnswer.size();i++){
      dfsSt.append(dfsAnswer.get(i)+" ");
    }

    //BFS �� �ֱ� (����) - �� ���Ϲޱ�
    //���� start�� ���ؾ� BFS �� ���ư� �� ����. �׷��� ������ Queue�� �� ������
    //Queue��, answer�� �־��ٴ� �� �湮�ߴٴ� ���̱⵵ �ϴ�. ���� ch �� �� 1 ó�� ����� ��.
    bfsQueue.add(start);
    bfsAnswer.add(start);
    bfsCh[start] = 1;
    T.BFS();
    StringBuilder bfsSt = new StringBuilder("");
    for(int i=0;i<bfsAnswer.size();i++){
      bfsSt.append(bfsAnswer.get(i)+" ");
    }

    System.out.println(dfsSt+"\n"+bfsSt);
  }
}
