package BaekJoon.BFS;

import BaekJoon.Format;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 */

class Node {
  int x;
  int y;
  Node (int x, int y){
    this.x = x;
    this.y = y;
  }
}
public class BJ2178 {

  public int solution(int row ,int col, int[][] conn){
    int answer = 0;
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(1,1));
    answer+=1; //Node 가 들어갈 때마다, (혹은 queue가 한 번 돌때마다, answer+=1

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    while(!queue.isEmpty()){
      int len = queue.size();
      for(int i=0;i<len;i++){
        Node temp = queue.poll();
        //사방 탐색
        for(int j=0;j<=3;j++){
          int nx = temp.x+dx[j];
          int ny = temp.y+dy[j];

          if(nx==row&&ny==col){
            answer+=1;
            return answer;
          }

          if(nx>=1&&nx<=row&&ny>=1&&ny<=col&&conn[nx][ny]==1){
            queue.add(new Node(nx, ny));
          }
        }
      }
      answer+=1;
    }

    return answer;
  }
  public static void main(String[] args) throws IOException {
    BJ2178 T = new BJ2178();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int row = Integer.parseInt(st.nextToken());
    int col = Integer.parseInt(st.nextToken());
    int[][] conn = new int[row+1][col+1];

    for(int i=1;i<=row;i++) {
      String line = br.readLine();
      //line을 읽는 인덱스는 0부터 시작하기 때문이다.
      for (int j=0; j <col; j++) {
        conn[i][j+1]= Character.getNumericValue(line.charAt(j));
      }
    }
    System.out.println(T.solution(row,col, conn));
  }
}
