package Inflearn.DFSBFSProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Queue 로 구현하는 이유: L0의 노드를 poll() 하고, L1의 노드를 PUSH()하는 식이어서.
 * 먼저 들어간 애를 먼저 빼내기 위해서.
 *
 * 반복문이 2개다 (1) Queue의 사이즈 만큼 반복. 그만큼 q.poll()이 되어야 하니 (2)
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
                        return L+1; //L이 더해져야 현재 레벨이 되니까, 더해진 채로 출력해야 함
                    }
                }
            }
            L++;
        }
        //q가 empty하지 않다면, 다 탐색했다는 것.
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
