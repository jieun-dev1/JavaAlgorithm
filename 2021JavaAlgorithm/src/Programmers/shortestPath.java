package Programmers;

/**
 * 무한 반복 해결.
 * 목표 지점이 막혀있는 것에 대한 예외 처리를 안해주면 int 의 최대값인 2147483647 반환
 */

public class shortestPath {

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[][] ch;
  static int answer = Integer.MAX_VALUE;

  public int solution(int[][] maps) {
    ch = new int[maps.length][maps[0].length];
    if (maps[maps.length - 2][maps[0].length - 1]==0 && maps[maps.length - 1][maps[0].length - 2]==0) {
      answer = -1;
      return answer;
    }
    ch[0][0] = 1;
    DFS(0, 0, 1, maps);
    return answer;
  }


  public void DFS(int x, int y, int distance, int[][] maps) {
    //목표점이 닫힌 경우 answer = -1 리턴.
    if (x == (maps.length - 2) && y == (maps[0].length - 1)) {

    }

    //목표 지점에 도달했을 때.
    if (x == (maps.length - 1) && y == (maps[0].length - 1)) {
      answer = Math.min(answer, distance);
    }



    for (int i = 0; i < 4; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      //ch 조건을 넣어줘야 루프를 돌지 않는다. 테두리를 벗어나지 않도록 0과 maps 길이를 벗어나지 않도록 조건 넣어주자.
      if (nx >= 0 && nx<=maps.length-1 && ny >= 0 && ny<=maps[0].length - 1 && maps[nx][ny] == 1 && ch[nx][ny] == 0) {
        ch[nx][ny] = 1;
        DFS(nx, ny, distance + 1, maps);
        ch[nx][ny] = 0;
      }
    }
  }

  public static void main(String[] args) {
    shortestPath T = new shortestPath();
    System.out.println(T.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
  }
}


