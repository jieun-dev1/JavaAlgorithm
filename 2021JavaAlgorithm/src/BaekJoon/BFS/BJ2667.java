package BaekJoon.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * (1) 출력은 오름차 순으로
 * (2) 건물이 한 개만 있어도 단지다 (연결이 안되어 있어도 됨)
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
    count++;
    ch[x][y]=true;
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

    //단지인 경우만, 답에 추가 되어야 한다. 단지이려면 최소 2개 이상으로 연결되어 있어야 한다 (count가 1이상). 이 경우 시작점은 포함이 안되었으니, 마지막에 추가해준다.
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
    Collections.sort(answerArr);
    System.out.println(answerArr.size());
    for(int i=0;i<answerArr.size();i++){
      System.out.println(answerArr.get(i));
    }
  }
}
