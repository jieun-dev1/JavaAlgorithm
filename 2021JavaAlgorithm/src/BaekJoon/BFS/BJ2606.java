package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2606 {
  static List<Integer>[] list;
  static int[] ch;
  static int answer = 0;
  static Queue<Integer> queue = new LinkedList<>();

  public void DFS(int start){
    List<Integer> adjacent = list[start];
    //adjacent가 빈 배열인지 확인해주지 않으면 NullPointer가 남
    if(adjacent!=null){
      //isEmpty가 아님. 연결이 안되어 있을 경우 list[start]에 원소가 없음. 2) while -> if 로 변경
      // (while 이라면 무한 반복이라 못빠져나옴, if는 한번만 체크함)
      //o(100)
      for(int i=0;i<adjacent.size();i++){
        int temp = adjacent.get(i); //temp는 인접리스트를 차례로 읽어오는 값이다. 모르고 ch[adjacent.get(i)]를 했는데, 이러면 0 혹은 1이 나옴
        if(ch[temp]==0){
          ch[temp]=1;
          DFS(temp); //static이 아니기 때문에 객체 생성해서 T 로 접근하지 않아도 됨.
//          ch[temp]=0;
        }
      }
    }
  }

  public void BFS(){
    while(!queue.isEmpty()){
      int x = queue.poll();
      for(int i=0;i<list[x].size();i++){
        int temp = list[x].get(i);
        if(ch[temp]==0){
          queue.offer(temp);
          ch[temp]=1;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BJ2606 T = new BJ2606();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //각 정점의 여부 ch 에서 파악. 연결 리스트도 정점 만큼 만들어줌.
    StringTokenizer st = new StringTokenizer(br.readLine());
    int computer = Integer.parseInt(st.nextToken());
    list = new ArrayList[computer+1];
    ch = new int[computer+1];
    //연결 리스트 초기화 pair 개수 +1 만큼 만들어서, 인덱스신경 안쓰도록.
    st = new StringTokenizer(br.readLine());
    int pair = Integer.parseInt(st.nextToken());
    //O(100)
    for(int i=1;i<computer+1;i++) { //pair+1로 만드는 실수.
    list[i] = new ArrayList<>();
    }
      //원소에 하나씩 ArrayList 넣어줘야. 양쪽에 만들어준다 양방향연결이니까.
    //pair는 최대 10000개.
    for(int i=0;i<pair;i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[x].add(y);
      list[y].add(x);
    }
//  T.DFS(1); //DFS 는 NON STATIC 메서드라서, NON-STATIC에서 REFER 불가.
//  해당 메서드에서는 queue에 원소를 넣어야, BFS 가 시작될 수 있다. 그렇지 않으면 LIST 가 EMPTY이기에
    queue.add(1);
    T.BFS();

    //o(100)
    for(int i=0;i<ch.length;i++){
      if(ch[i]==1){
        answer++;
      }
    }
    System.out.println(answer-1);
  }
}
