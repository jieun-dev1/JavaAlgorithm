package BaekJoon.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * StackOverFlow 원인: DFS 할 떄, 한번 방문한 것은 CH를 해줘야, ch==false 만 dfs 하는 게 의미가 있음.
 * 그래프 유의점: 사방 탐색을 할 때, 주어진 범위를 벗어나서는 안됨.
 * 처음에 solution 함수에서 DFS 를 호출하는 방법을 썼으나, 그렇게 하면 StackFrame 에 쌓이지 않는다.*
 * DFS가 안쌓임.
 *
 * Count를 매번 초기화 해야 하는데, 초기화가 안됐었음.
 * 이유: main 스택 프레임에는 count가 1이라는 변수로 저장되어 있기 때문이다.
 * dfs에서 return 하는 것이 필요하다.
 *
 * static 메서드와 일반 메서드 차이
 *
 * VOID로 풀고 싶다면, ApartNum을 저장해야 한다. (즉 첫 번째 단지 - count가 7로 동일할 때에는,
 * DFS 가 반복되는 동안 동일한 ApartNum (순서) 에 업데이트 되도록 한다.
 * 현재 코드는 main 메서드의 DFS pop 되기 전의 상태를 저장할 방법이 없음.
 */
public class BJ2667 {
  static ArrayList<Integer> answerArr = new ArrayList<>();
  static boolean[][] ch;
  static int[][] arr;
  static int n;
  static int count;
  //사방
  static int[] disX = {0, -1, 0, 1};
  static int[] disY = {-1, 0, 1, 0};
  //

  public static void DFS(int x, int y) {
    //사방 탐색 - 0부터 배열을 채웠으니 0-3 을 탐색.
    ch[x][y]=true;
    count++;
    for(int i=0;i<=3;i++){
      int nx = x+ disX[i];
      int ny = y+ disY[i];
      //arr가 1이고 ch가 false인 것을 DFS
      //사방 탐색을 할 때, 주어진 범위를 벗어나서는 안됨.
      if(nx>=1&&nx<=n&&ny>=1&&ny<=n&&ch[nx][ny]==false&&arr[nx][ny]==1){
        DFS(nx, ny);
      }
    }
  }
  public static void main(String[] args) throws IOException {
    BJ2667 T = new BJ2667();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new int[n+1][n+1];
    ch = new boolean[n+1][n+1];
    for(int i=1;i<=n;i++){
      String st = br.readLine();
      for(int j=1;j<=n;j++){
        arr[i][j] = Character.getNumericValue(st.charAt(j-1));//바뀌는 값이 j임을 기억한다.
//        System.out.println(arr[i][j]);
      }
    }

    //기존 solution으로 따로 나눴던 것을 main 에서 해도 ok.

    count = 0;
    for(int x=1;x<=n;x++) {
      for (int y=1; y<=n;y++) {
        if(ch[x][y]==false&&arr[x][y]==1){
          DFS(x, y);
          answerArr.add(count);
          count= 0;
        }
      }
    }
    System.out.println(answerArr.size());
    for(int i=0;i<answerArr.size();i++){
      System.out.println(answerArr.get(i));
    }
  }
}
