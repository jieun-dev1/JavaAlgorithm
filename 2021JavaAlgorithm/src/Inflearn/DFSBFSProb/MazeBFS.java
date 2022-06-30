package Inflearn.DFSBFSProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * DFS ���� ������.
 * DIS[][] �迭�� ���� ������༭ ���� ���� ǥ�����ش�. q �� ��ٴ� �� - 7,7�� �����ؼ� �� ���� �� ���� ��.
 * ���� ���� ���� -1.
 */


class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
class MazeBFS {

    static int arr[][], dis[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public int BFS(int x, int y) {
        Queue<Point> q = new LinkedList();
        q.offer(new Point(x,y));
        //q�� �� �ִ� ���¶�� 1�� ǥ���ϱ�.
        arr[x][y] = 1;

        while(!q.isEmpty()) {
            Point tmp = q.poll();
            for(int i=0;i<4;i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx >=1&&nx<=7&&ny >=1&&ny<=7&&arr[nx][ny]==0) {
                    arr[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
            }

        if(dis[7][7]==0) {
            return -1;
        } else {
            return dis[7][7];
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MazeBFS T = new MazeBFS();
        arr = new int[8][8];
        dis = new int[8][8];
        for (int i=1; i<8;i++) {
            for(int j=1;j<8;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.BFS(1,1));
    }
}
