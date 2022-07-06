package Inflearn.DFSBFSProb;

import java.util.Scanner;

/**
 * �̷� ã�� ������ ���
 * 1�� �߰��ϸ� 0���� �ٲ� ��.
 * 1�� �ִ� ������ DFS ��͸� ���ٰ�, ���̻� 1�� ������ ���� ȣ����ġ��.
 *
 * DFS �޼��� �ϳ��� �־�����, D
 * DFS(8������ ��͸� �ϸ鼭 Ȯ���ϰ� 0���� �ٲ�)
 * �� SOLUTION �� �и��ؾ� �� (ó�� ȣ��� arr[i][j]�� 0���� �ٲ���)
 * DFS �� DX, DY�� INT �迭�� ���־��� ������ FOR���� 1�����ε�,
 * �켱 Ž���� �Ϸ��� 2���� FOR���� �ʿ��ϱ� ����.
 *
 * ���⼭ arr�� ��� �ٲ�� ���̴ϱ�, static ���� �ϱ⺸�� �־��ִ� �� �� ���� �� ����.
 */
class IslandDFS {

    static int answer = 0;
    static int n;
    static int[] dx = {-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,-1,1,-1,-1,1,1};
    //�̷ο� �޸� 8�� ���� Ž��.

    public void DFS(int x, int y, int[][] arr) {

        for(int i=0;i<8;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx>=1&&nx<=n&&ny>=1&&ny<=n&&arr[nx][ny] == 1) {
                arr[nx][ny]=0;
                DFS(nx,ny,arr); //1�̾����� 0���� �ٲ� �� �ٽ� 8�� Ž���� �Ѵ�.
            }
        }
        //�迭 ���� ������ �о�� ��.
    }

    public void solution(int[][] arr) {
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++){
                if(arr[i][j] == 1) {
                    answer ++; //1�� �ε����� �߰��ϸ� �켱 answer�� �����ְ�
                    DFS(i,j, arr) ; //8�� Ž���� �ϸ鼭 ����Ѵ�.
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IslandDFS T = new IslandDFS();
        n = sc.nextInt();
        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }
}
