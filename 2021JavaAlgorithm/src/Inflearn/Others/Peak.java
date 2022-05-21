package Inflearn.Others;

import java.util.Scanner;

//처음에는 각 if 문에 break를 걸었었음. break 아닌 continue 써야. break 는 조건문을 탈출하는데 for문 자체를 탈출하기 때문에, r+1이 아니라 c+1이 되어버림.
//2차원 배열 10. 봉우리. 인프런
//시간 복잡도 207ms (continue 로 풀면 답은 나오는데 오답으로나옴)
public class Peak {
    int answer = 0;

    public int solution(int[][] arr, int n) {

        for(int c=1;c<n+1;c++){
            for(int r=1;r<n+1;r++){
                if((arr[c][r] > arr[c-1][r]) && (arr[c][r] > arr[c+1][r]) && (arr[c][r] > arr[c][r-1]) && (arr[c][r] > arr[c][r+1])) //우
                    answer ++;
//            if(arr[c][r] < arr[c-1][r]) continue;
//            if (arr[c][r] < arr[c+1][r]) continue;
//            if (arr[c][r] < arr[c][r-1]) continue;
//            if (arr[c][r] < arr[c][r+1]) continue;
            else answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Peak T = new Peak();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for(int c=1;c<n+1;c++){
            for(int r=1;r<n+1;r++){
                arr[c][r] = sc.nextInt();
            }
        }
        System.out.println(T.solution(arr,n));
    }
}
