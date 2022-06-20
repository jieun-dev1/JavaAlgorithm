package Inflearn.DFSBFSProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Queue �� �����ϴ� ����: L0�� ��带 poll() �ϰ�, L1�� ��带 PUSH()�ϴ� ���̾.
 * ���� �� �ָ� ���� ������ ���ؼ�.
 *
 * �ݺ����� 2���� (1) Queue�� ������ ��ŭ �ݺ�. �׸�ŭ q.poll()�� �Ǿ�� �ϴ� (2)
 */

public class CalfV2 {
    int[] ch = new int[10001];
    int[] dis = {1,-1,5};

    public int BFS(int start, int dest) {
        Queue<Integer> q = new LinkedList<>();
        ch[start] = 1;
        q.offer(start);
        int L = 0;

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++) {
                int tmp = q.poll();
                for(int j=0;j<3;j++) {
                    int nx = tmp+dis[j];
                    if(nx>=1&&nx<=10000&&ch[nx]==0) {
                        q.offer(nx);
                        ch[nx] = 1;
                    }
                    if(nx == dest) {
                        return L+1; //L�� �������� ���� ������ �Ǵϱ�, ������ ä�� ����ؾ� ��
                    }
                }
            }
            L++;
        }
        //q�� empty���� �ʴٸ�, �� Ž���ߴٴ� ��.
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalfV2 T = new CalfV2();
        int start = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println(T.BFS(start, dest));
    }
}
