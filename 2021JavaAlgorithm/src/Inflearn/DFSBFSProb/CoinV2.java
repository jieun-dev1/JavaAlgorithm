package Inflearn.DFSBFSProb;

//이 문제에서 int 배열을 int[] ch = new int[target+1]; target 만큼 주면, Runtime Error 가 난다.
//ch[]=1로 ch 여부를 표시해줄 때, nx>=1&&nx<=target 이라는 조건을 넣어주더라도, Runtime Error가 남
//ch 배열에 값을 넣어줄 때, 범위 먼저 체크해야 에러가 나지 않는다. Time 은 target 으로 풀었을 때 10ms 짧다.
//런타임 에러는 배열 인덱스를 잘못 참조했을 떄, 주로 만들어진다고 한다. 입력을 받아들이는 배열의 크기를 너무 작게 줘서 채점 시 오류가 나기도 한다고 하니 참고.
// 출처: https://www.acmicpc.net/board/view/22980

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CoinV2 {

    public int solution(int cnt, int[] opt, int target) {
//        int[] ch = new int[500]; //1 - 목표 금액(EX.1500) check 배열.
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
//                    q.offer(nx);//실수. 이렇게 하면 중복 체크 없이 q에 들어감.
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
