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
  static int mapsX;
  static int mapsY;

  public int solution(int[][] maps) {
    ch = new int[maps.length][maps[0].length];
    mapsX = maps.length;
    mapsY = maps[0].length;
    //목표점이 닫힌 경우 answer = -1 리턴.
    if (maps[mapsX - 2][mapsY - 1]==0 && maps[mapsX - 1][mapsY - 2]==0) {
      answer = -1;
      return answer;
    }
    ch[0][0] = 1;
    DFS(0, 0, 1, maps);
    return answer;
  }


  public void DFS(int x, int y, int distance, int[][] maps) {

    //목표 지점에 도달했을 때.
    if (x == (mapsX - 1) && y == (mapsY - 1)) {
      answer = Math.min(answer, distance);
    }

    for (int i = 0; i < 4; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      //ch 조건을 넣어줘야 루프를 돌지 않는다. 테두리를 벗어나지 않도록 0과 maps 길이를 벗어나지 않도록 조건 넣어주자.
      if (nx >= 0 && nx<=mapsX-1 && ny >= 0 && ny<=mapsY - 1 && maps[nx][ny] == 1 && ch[nx][ny] == 0) {
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


