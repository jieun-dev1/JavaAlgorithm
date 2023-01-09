package BaekJoon.BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * (1) ����� ������ ������
 * (2) �ǹ��� �� ���� �־ ������ (������ �ȵǾ� �־ ��)
 */
public class BJ2667 {
  static ArrayList<Integer> answerArr = new ArrayList<>();
  static boolean[][] ch;
  static int[][] arr;
  static int n;
  static int count;
  //���
  static int[] disX = {0, -1, 0, 1};
  static int[] disY = {-1, 0, 1, 0};
  //

  public static void DFS(int x, int y) {
    //��� Ž�� - 0���� �迭�� ä������ 0-3 �� Ž��.
    count++;
    ch[x][y]=true;
    for(int i=0;i<=3;i++){
      int nx = x+ disX[i];
      int ny = y+ disY[i];
      //arr�� 1�̰� ch�� false�� ���� DFS
      //��� Ž���� �� ��, �־��� ������ ������� �ȵ�.
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
        arr[i][j] = Character.getNumericValue(st.charAt(j-1));//�ٲ�� ���� j���� ����Ѵ�.
//        System.out.println(arr[i][j]);
      }
    }

    //������ ��츸, �信 �߰� �Ǿ�� �Ѵ�. �����̷��� �ּ� 2�� �̻����� ����Ǿ� �־�� �Ѵ� (count�� 1�̻�). �� ��� �������� ������ �ȵǾ�����, �������� �߰����ش�.
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
