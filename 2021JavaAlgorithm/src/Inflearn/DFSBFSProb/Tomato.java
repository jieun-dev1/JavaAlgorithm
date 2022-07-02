package Inflearn.DFSBFSProb;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. ��ü Ž���� ���ؼ� ��ȸ �� 0�� �ϳ��� ������ -1�� ����Ѵ�.
 * 2. ��ü Ž���� ���� ��ȸ �� ��, ó������ ��� 1�̸� 0�� ����Ѵ�.
 * 3. ��� Ž�� ��, index �� �Ѿ�� �κ��� ó�������� ������ ArrayIndexOutOfBounds ����
 * * �־��� n,m ���� ���� ������ ��.
 *
 * �ҿ�ð� 2�ð�
 * (���� �κ�)- ����.
 * Queue �� poll �� �ϰ� ���� �ٷ� offer�� �ؼ� ���� Ž���� �ϱ� �������� queue�� ��������� �ȵǴµ�, �ѹ� Ž���ϰ� ä��� ����.
 * main �Լ����� queue �� offer �� ä�� �� ���� ������?
 *
 * �ð� ����:
 * (1) class Main +  Queue = new LinkedList<>()�� <>�� �ٿ��־��� �� �ð��� 20ms �� �پ���. 1986ms
 * (2) public class Main + Queue = new LinkedList<>(): 1961ms
 * (3) public class Main + Queue = new LinkedList(): 2013MS
 * (4) class Main + Queue = new LinkedList(): 2000MS
 */


class TomatoPoint {
    int x;
    int y;

    TomatoPoint(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

class Tomato {

    static int[][] arr;
    static int[][] dis;
    static int m;
    static int n;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};
    //main ������ Queue �� �������� �־�� �ϱ� ������, static ����
    static Queue<TomatoPoint> q = new LinkedList<>();

    //BFS �Լ��� ������ ���� BFS() �������� �����ϰ�,
    //FLAG ���θ� üũ�ϰ� (FLAG �� FALSE �̸� �� ���� �ʾҴٴ� ��. FLAG �� TRUE�̸� ó������ �;��ų�/ �ð��� �����鼭 �����ų�)
    //answer�� ����Ʈ �ϴ� �� main
    public void BFS() {
        //�迭�� ��ȸ�ϸ鼭, 1�� �ִ� ������ �ľ��Ѵ�.
        while (!q.isEmpty()) {
// �̹� while ���� ���� ��ŭ �ݺ��ϱ� ������ len üũ �ʿ� ����.
//            int len = q.size(); //q �� ������ ��ŭ �ݺ� - 1�� �ִ� ��� ���� Ž�� �� answer ++ ����.
//            for (int i = 0; i < len; i++) {
            TomatoPoint tmp = q.poll();
            //Queue�� ���� ù ���Ҹ� ������ ��� Ž��
            for (int j = 0; j < 4; j++) {
                int nx = tmp.x + dx[j];
                int ny = tmp.y + dy[j];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    q.offer(new TomatoPoint(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Tomato T = new Tomato();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //��(column)
        n = sc.nextInt(); //��(row)
        arr = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 1) {
                    q.offer(new TomatoPoint(i, j));
                }
            }
        }

            T.BFS();
            boolean flag = true;
            int answer = Integer.MIN_VALUE;
            //Ž���� �� ���Ҵµ���, arr �� 0�� �� �ϳ��� ������ flag�� false �ΰ� (�� ���� �ʾҴ� -1 ���)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        flag = false;
                        ;
                    }
                }
            }
            //flag �� �ִ� ��츸
            if (flag) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        answer = Math.max(answer, dis[i][j]);
                    }
                }
                System.out.println(answer);

            } else {
                System.out.println(-1);

            }
        }
    }
