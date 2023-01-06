package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644 {

  public int solution(int n, int x, int y, ArrayList<ArrayList<Integer>> list){
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    int[] ch = new int[n+1];
    queue.add(x);
    ch[x] = 1;
    while(!queue.isEmpty()){
      int len = queue.size();
      //i는 현재 queue의 크기 만큼 순회하는 len이다.
      for(int i=0;i<len;i++){
        int temp = queue.poll();
        // 방법 1: 우선은 넣고 queue로 뽑았을 때 확인
        if(temp==y){
              return answer;
            }
        //j: temp 와 연결된 리스트의 사이즈
        ArrayList<Integer> tempList = list.get(temp);
        for(int j=0;j<tempList.size();j++){
          if(ch[tempList.get(j)]==0){
            queue.offer(tempList.get(j));
            ch[tempList.get(j)]=1;
// 방법 2: 더 효율적
//            if(tempList.get(j)==y){
//              answer++;
//              return answer;
//            }
          }
        }
//        answer++;
      }
      answer++;

    }
    //목표 지점이 방문이 되어 있다면 answer 리턴.
    if(ch[y]==1){
      return answer;
    } else {
      return -1;
    }
  }
  public static void main(String[] args) throws IOException {
    BJ2644 T = new BJ2644();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    StringTokenizer st2= new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st2.nextToken());
    int y = Integer.parseInt(st2.nextToken());
    StringTokenizer st3= new StringTokenizer(br.readLine());
    int pair = Integer.parseInt(st3.nextToken());
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    //인접 리스트는 지점마다 만들어지니, n 만큼 만들자.
    for(int i=0;i<=n;i++){
      list.add(new ArrayList<Integer>()); //특정 위치에 ArrayList를 초기화 한다.
//      list.add(1, new ArrayList<Integer>()); //특정 위치에 ArrayList를 초기화 한다.
      //0을 건너 뛰고 1부터 넣으니까 넣어지지 않고 IndexOutOfArray 에러가 남. list는 순차적으로 더해서 그런가보다.
      //그냥 1개 더 만들어주자.
    }

    //인접리스트 설정 시 양방향인지 확인 필요
    for(int i=1;i<=pair;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);

    }
    System.out.println(T.solution(n, x, y, list));
  }
}
