package Inflearn.DFSBFSProb;

import java.util.Scanner;

/**
 * 미로 찾기 문제랑 비슷
 * 1을 발견하면 0으로 바꿀 것.
 * 1이 있는 동안은 DFS 재귀를 돌다가, 더이상 1이 없으면 원래 호출위치로.
 *
 * DFS 메서드 하나에 넣었지만, D
 * DFS(8방으로 재귀를 하면서 확인하고 0으로 바꿀)
 * 와 SOLUTION 을 분리해야 함 (처음 호출된 arr[i][j]를 0으로 바꿔줄)
 * DFS 는 DX, DY로 INT 배열을 빼주었기 때문에 FOR문이 1차원인데,
 * 우선 탐색을 하려면 2차원 FOR문이 필요하기 때문.
 *
 * 여기서 arr는 계속 바뀌는 값이니까, static 으로 하기보다 넣어주는 게 더 좋을 것 같다.
 */
class IslandDFS {

    static int answer = 0;
    static int n;
    static int[] dx = {-1,1,0,0,-1,1,-1,1};
    static int[] dy = {0,0,-1,1,-1,-1,1,1};
    //미로와 달리 8개 방향 탐색.

    public void DFS(int x, int y, int[][] arr) {

        for(int i=0;i<8;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;
            if(nx>=1&&nx<=n&&ny>=1&&ny<=n&&arr[nx][ny] == 1) {
                arr[nx][ny]=0;
                DFS(nx,ny,arr); //1이었으니 0으로 바꾼 뒤 다시 8방 탐색을 한다.
            }
        }
        //배열 내의 정보만 읽어야 함.
    }

    public void solution(int[][] arr) {
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<n+1;j++){
                if(arr[i][j] == 1) {
                    answer ++; //1인 인덱스를 발견하면 우선 answer에 더해주고
                    DFS(i,j, arr) ; //8방 탐색을 하면서 재귀한다.
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
