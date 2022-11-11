package Inflearn;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 인프런  - 경로탐색 인접 리스트 문제. 모든 정점을 탐색하는 거라서 DFS 써야 하는 것 같다.
 *
 * IndexOutOfBoundsException: Index: 1, Size: 0
 * ->0번째에 null이 들어간 경우에는 1번에 데이터를 넣을 수 없기 때문이다.
 *
 */
public class Navigating {

  static int n; //주어진 Number의 개수
  static int m; //주어진 경로의 수
  static ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
  static int answer;
  static int[] ch; //n이 정해지지 않았기 때문에, n은 정해지고 나서 할당해줘야 함.

  public void DFS(int point){
    //목표 지점에 도달했다면, answer를 추가하고
    if(point==n){
      answer++;
    } else {
//      ch[point] = 1; //방문한 point는 check 배열에 표시. 이거 필요 없지 않나?
      for(int i=0;i<graphList.get(point).size();i++){
        int temp = graphList.get(point).get(i);
        if(ch[temp]==0){
          ch[temp] = 1;
          DFS(temp);
          ch[temp] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Navigating T = new Navigating();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    ch = new int[n+1];
    //n까지 도달하니까, n이 어디로 이어지는 지는 ArrayList로 표현할 필요x
    for(int i=0;i<n;i++){
      graphList.add(i, new ArrayList<Integer>());
    }
    for(int i=0;i<m;i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      graphList.get(a).add(b);
    }
    ch[1] = 1; //DFS를 시작하기 전에, 1을 CH 배열에서 체크하는 게 핵심임.
    T.DFS(1);
    System.out.println(answer);
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

}

