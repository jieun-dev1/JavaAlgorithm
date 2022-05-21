package Inflearn.Others;

import java.util.Scanner;
//225ms
//테두리 배열을 추가하고, 4방향 배열 추가.
//시, 복.//225ms
//변수가 class 에 있을 때, 5ms 더 짧다.
public class Peak2 {

    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, 1, 0, -1};
//    int [] dx = {-1, 1, 0, 0};
//    int [] dy = {0, 0, -1, 1};
    int answer = 0;
    public int solution(int[][] arr, int n) {
        //i,j가 1이면 안되고 0이어야 하는 것 같다.
        //배열을 감싸는 것보다 그대로 5x5배열로 만들되, 모서리의 경우는 아예 탐색하지 않는 것.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    //모서리가 아닌 경우 중, [i][j]배열이 작거나 같다면 봉우리가 아니니 false 처리.
                    if(nx>=0&&nx<n&&ny>=0&&ny<n&&arr[i][j]<=arr[nx][ny]) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Peak2 T = new Peak2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int c=0;c<n;c++){
            for(int r=0;r<n;r++){
                arr[c][r] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr,n));
    }
}
