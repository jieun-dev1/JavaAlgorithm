package Inflearn.DFSBFSProb;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 전체 탐색을 통해서 순회 후 0이 하나라도 있으면 -1을 출력한다.
 * 2. 전체 탐색을 통해 순회 할 때, 처음부터 모두 1이면 0을 출력한다.
 * 3. 사방 탐색 시, index 가 넘어가는 부분을 처리해주지 않으면 ArrayIndexOutOfBounds 에러
 * * 주어진 n,m 으로 범위 한정할 것.
 *
 * 소요시간 2시간
 * (막힌 부분)- 구현.
 * Queue 가 poll 을 하고 나서 바로 offer를 해서 완전 탐색을 하기 전까지는 queue가 비어있으면 안되는데, 한번 탐색하고 채우고 끝남.
 * main 함수에서 queue 에 offer 한 채로 할 수도 있을까?
 *
 * 시간 차이:
 * (1) class Main +  Queue = new LinkedList<>()에 <>를 붙여주었을 때 시간이 20ms 더 줄었다. 1986ms
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
    //main 에서도 Queue 에 시작점을 넣어야 하기 때문에, static 설정
    static Queue<TomatoPoint> q = new LinkedList<>();

    //BFS 함수를 돌리는 것은 BFS() 내에서만 진행하고,
    //FLAG 여부를 체크하고 (FLAG 가 FALSE 이면 다 익지 않았다는 뜻. FLAG 가 TRUE이면 처음부터 익었거나/ 시간이 지나면서 익혔거나)
    //answer를 프린트 하는 건 main
    public void BFS() {
        //배열을 순회하면서, 1이 있는 지점을 파악한다.
        while (!q.isEmpty()) {
// 이미 while 문이 원소 만큼 반복하기 때문에 len 체크 필요 없음.
//            int len = q.size(); //q 의 사이즈 만큼 반복 - 1이 있는 모든 지점 탐색 후 answer ++ 가능.
//            for (int i = 0; i < len; i++) {
            TomatoPoint tmp = q.poll();
            //Queue의 가장 첫 원소를 꺼내서 사방 탐색
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
        m = sc.nextInt(); //열(column)
        n = sc.nextInt(); //행(row)
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
            //탐색을 다 돌았는데도, arr 에 0인 게 하나라도 있으면 flag가 false 인것 (다 익지 않았다 -1 출력)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == 0) {
                        flag = false;
                        ;
                    }
                }
            }
            //flag 가 있는 경우만
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
