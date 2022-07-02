package Inflearn.DFSBFSProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. ��ü Ž���� ���ؼ� ��ȸ �� 0�� �ϳ��� ������ -1�� ����Ѵ�.
 * 2. ��ü Ž���� ���� ��ȸ �� ��, ó������ ��� 1�̸� 0�� ����Ѵ�.
 * 3. ��� Ž�� ��, index �� �Ѿ�� �κ��� ó�������� ������ ArrayIndexOutOfBounds ����
 * 4.
 * �ҿ�ð� 2�ð�
 * (���� �κ�)- ����.
 * Queue �� poll �� �ϰ� ���� �ٷ� offer�� �ؼ� ���� Ž���� �ϱ� �������� queue�� ��������� �ȵǴµ�, �ѹ� Ž���ϰ� ä��� ����.
 * main �Լ����� queue �� offer �� ä�� �� ���� ������?
 */

class TomatoPoint {
    int x;
    int y;

    TomatoPoint(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Tomato {

    static int[][] arr;
    static int answer = 0;
    static int m;
    static int n;
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};

    public int BFS() {
        Queue<TomatoPoint> q = new LinkedList();
        //�迭�� ��ȸ�ϸ鼭, 1�� �ִ� ������ �ľ��Ѵ�.
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if (arr[i][j] == 1) {
                    q.offer(new TomatoPoint(i,j));
                }
                //1�� (�;��ִ� �丶�丸) ���� ��� 0�� ����Ѵ�.
                if (q.size() == m*n) {
                    answer = 0;
                    return answer;
                }
            }

        }

        while(!q.isEmpty()){
            int len = q.size(); //q �� ������ ��ŭ �ݺ� - 1�� �ִ� ��� ���� Ž�� �� answer ++ ����.
            for(int i=0; i<len;i++) {
                TomatoPoint tmp = q.poll();
                //Queue�� ���� ù ���Ҹ� ������ ��� Ž��
                for(int j=0;j<4;j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    if(nx>=1&&nx<=4&&ny>=1&&ny<=6&&arr[nx][ny]==0) {
                        arr[nx][ny] = 1;
                    }
                }
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Tomato T = new Tomato();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt(); //��(column)
        n = sc.nextInt(); //��(row)
        arr = new int[n+1][m+1];
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.BFS());
    }
}
