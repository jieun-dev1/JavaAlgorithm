package Inflearn.Others;

import java.util.Scanner;
//225ms
//�׵θ� �迭�� �߰��ϰ�, 4���� �迭 �߰�.
//��, ��.//225ms
//������ class �� ���� ��, 5ms �� ª��.
public class Peak2 {

    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, 1, 0, -1};
//    int [] dx = {-1, 1, 0, 0};
//    int [] dy = {0, 0, -1, 1};
    int answer = 0;
    public int solution(int[][] arr, int n) {
        //i,j�� 1�̸� �ȵǰ� 0�̾�� �ϴ� �� ����.
        //�迭�� ���δ� �ͺ��� �״�� 5x5�迭�� �����, �𼭸��� ���� �ƿ� Ž������ �ʴ� ��.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    //�𼭸��� �ƴ� ��� ��, [i][j]�迭�� �۰ų� ���ٸ� ���츮�� �ƴϴ� false ó��.
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
