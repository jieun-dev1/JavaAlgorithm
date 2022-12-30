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
 * 소요시간: 약 3시간.
 */
public class BJ1260 {
  static int point;
  //해당 정점을 방문했는지 판별함 - point 만큼 체크 배열. 배열이랑 answer는 dfs bfs 별로 사용한다.
  static int[] ch;
  static int[] bfsCh;

  static int connect;
  static ArrayList<ArrayList<Integer>>  list = new ArrayList<>();;
  static ArrayList<Integer> dfsAnswer = new ArrayList<>();

  static Queue<Integer> bfsQueue = new LinkedList<>();
  static ArrayList<Integer> bfsAnswer = new ArrayList<>();


  public void DFS(int start){
    //exit 기준은 정점을 모두 순회했을 때 즉 answer의 사이즈가 point와 같을 때.
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
          bfsCh[x]=1; //1로 바꿔야 무한반복이 돌지 않는다.
        }
      }
    }
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    point = Integer.parseInt(st.nextToken()); //정점의 개수
    ch = new int[point+1]; //갯수가 나중에 주어질 때는 이후에 할당해야 함. 인덱스 처리하기 귀찮으니 +1로 만들기
    bfsCh = new int[point+1];
    connect = Integer.parseInt(st.nextToken()); // 간선의 개수
    int start = Integer.parseInt(st.nextToken()); //시작점

    //인접 리스트 초기화를 하려면 한번 for문을 돌면서 내부 원소를 더해줘야 함.
    for(int i=0;i<point;i++){
      list.add(new ArrayList<Integer>());
    }
    //양방향 연결 설정
    for(int i=0;i<connect;i++){
      st = new StringTokenizer(br.readLine());
      int pointS = Integer.parseInt(st.nextToken());
      int pointE = Integer.parseInt(st.nextToken());
      list.get(pointS-1).add(pointE);
      list.get(pointE-1).add(pointS);
    }

    //번호가 작은 것을 먼저 방문하기 때문에 각 정점 별 리스트를 오름차순으로 정렬.
    for(int i=0;i< list.size();i++){
      Collections.sort(list.get(i)); //오름차순으로 정렬.
    }

    //DFS 값 넣기 (시작) - 답 리턴받기
    BJ1260 T = new BJ1260();
    ch[start]=1;
    dfsAnswer.add(start); //오답: 처음에 add(1)이었으나, 예제의 start가 1이지만 이는 항상 변하는 수이다.
    T.DFS(start);
    StringBuilder dfsSt = new StringBuilder("");
    for(int i=0;i<dfsAnswer.size();i++){
      dfsSt.append(dfsAnswer.get(i)+" ");
    }

    //BFS 값 넣기 (시작) - 답 리턴받기
    //먼저 start를 더해야 BFS 가 돌아갈 수 있음. 그렇지 않으면 Queue가 빈 상태임
    //Queue에, answer에 넣었다는 건 방문했다는 뜻이기도 하다. 따라서 ch 도 꼭 1 처리 해줘야 함.
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
