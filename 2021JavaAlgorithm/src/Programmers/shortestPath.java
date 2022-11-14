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
    //��ǥ���� ���� ��� answer = -1 ����.
    if (x == (maps.length - 2) && y == (maps[0].length - 1)) {

    }

    //��ǥ ������ �������� ��.
    if (x == (maps.length - 1) && y == (maps[0].length - 1)) {
      answer = Math.min(answer, distance);
    }



    for (int i = 0; i < 4; i++) {
      int nx = dx[i] + x;
      int ny = dy[i] + y;
      //ch ������ �־���� ������ ���� �ʴ´�. �׵θ��� ����� �ʵ��� 0�� maps ���̸� ����� �ʵ��� ���� �־�����.
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


