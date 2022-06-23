package Inflearn.DFSBFSProb;

//�� �������� int �迭�� int[] ch = new int[target+1]; target ��ŭ �ָ�, Runtime Error �� ����.
//ch[]=1�� ch ���θ� ǥ������ ��, nx>=1&&nx<=target �̶�� ������ �־��ִ���, Runtime Error�� ��
//ch �迭�� ���� �־��� ��, ���� ���� üũ�ؾ� ������ ���� �ʴ´�. Time �� target ���� Ǯ���� �� 10ms ª��.
//��Ÿ�� ������ �迭 �ε����� �߸� �������� ��, �ַ� ��������ٰ� �Ѵ�. �Է��� �޾Ƶ��̴� �迭�� ũ�⸦ �ʹ� �۰� �༭ ä�� �� ������ ���⵵ �Ѵٰ� �ϴ� ����.
// ��ó: https://www.acmicpc.net/board/view/22980

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinV2 {

    public int solution(int cnt, int[] opt, int target) {
//        int[] ch = new int[500]; //1 - ��ǥ �ݾ�(EX.1500) check �迭.
        int[] ch = new int[target+1];
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ch[0] = 1;

        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                int x = q.poll();
                for(int j=0;j<cnt;j++) {
                    int nx = x+opt[j];
                    if(ch[nx] == 0&&nx>=1&&nx<=target) {
                        q.offer(nx);
                        ch[nx] = 1;
                    }
//                    q.offer(nx);//�Ǽ�. �̷��� �ϸ� �ߺ� üũ ���� q�� ��.
                    if(nx == target) {
                        return answer + 1;
                    }
                }
            }
            answer++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoinV2 T = new CoinV2();
        int cnt = sc.nextInt();
        int[] opt = new int[cnt];
        for(int i=0;i<cnt;i++) {
            opt[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(T.solution(cnt, opt, target));
    }
}
