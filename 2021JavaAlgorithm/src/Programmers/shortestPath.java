package Programmers;

/**
 * ���� �ݺ� �ذ�.
 * ��ǥ ������ �����ִ� �Ϳ� ���� ���� ó���� �����ָ� int �� �ִ밪�� 2147483647 ��ȯ
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
    //��ǥ���� ���� ��� answer = -1 ����.
    if (maps[mapsX - 2][mapsY - 1]==0 && maps[mapsX - 1][mapsY - 2]==0) {
      answer = -1;
      return answer;
    }
    ch[0][0] = 1;
    DFS(0, 0, 1, maps);
    return answer;
  }


  public void DFS(int x, int y, int distance, int[][] maps) {

    //��ǥ ������ �������� ��.
    if (x == (mapsX - 1) && y == (mapsY - 1)) {
      answer = Math.min(answer, distance);
    }

    for (int i = 0; i < 4; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      //ch ������ �־���� ������ ���� �ʴ´�. �׵θ��� ����� �ʵ��� 0�� maps ���̸� ����� �ʵ��� ���� �־�����.
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


