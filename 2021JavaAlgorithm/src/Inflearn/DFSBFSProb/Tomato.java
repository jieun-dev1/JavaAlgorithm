package Inflearn.DFSBFSProb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1. 전체 탐색을 통해서 순회 후 0이 하나라도 있으면 -1을 출력한다.
 * 2. 전체 탐색을 통해 순회 할 때, 처음부터 모두 1이면 0을 출력한다.
 * 3. 사방 탐색 시, index 가 넘어가는 부분을 처리해주지 않으면 ArrayIndexOutOfBounds 에러
 * 4.
 * 소요시간 2시간
 * (막힌 부분)- 구현.
 * Queue 가 poll 을 하고 나서 바로 offer를 해서 완전 탐색을 하기 전까지는 queue가 비어있으면 안되는데, 한번 탐색하고 채우고 끝남.
 * main 함수에서 queue 에 offer 한 채로 할 수도 있을까?
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
        //배열을 순회하면서, 1이 있는 지점을 파악한다.
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                if (arr[i][j] == 1) {
                    q.offer(new TomatoPoint(i,j));
                }
                //1만 (익어있는 토마토만) 있을 경우 0을 출력한다.
                if (q.size() == m*n) {
                    answer = 0;
                    return answer;
                }
            }

        }

        while(!q.isEmpty()){
            int len = q.size(); //q 의 사이즈 만큼 반복 - 1이 있는 모든 지점 탐색 후 answer ++ 가능.
            for(int i=0; i<len;i++) {
                TomatoPoint tmp = q.poll();
                //Queue의 가장 첫 원소를 꺼내서 사방 탐색
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
        m = sc.nextInt(); //열(column)
        n = sc.nextInt(); //행(row)
        arr = new int[n+1][m+1];
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<m+1;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.BFS());
    }
}
