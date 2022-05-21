package Inflearn.Others;

import java.util.Scanner;

//ó������ �� if ���� break�� �ɾ�����. break �ƴ� continue ���. break �� ���ǹ��� Ż���ϴµ� for�� ��ü�� Ż���ϱ� ������, r+1�� �ƴ϶� c+1�� �Ǿ����.
//2���� �迭 10. ���츮. ������
//�ð� ���⵵ 207ms (continue �� Ǯ�� ���� �����µ� �������γ���)
public class Peak {
    int answer = 0;

    public int solution(int[][] arr, int n) {

        for(int c=1;c<n+1;c++){
            for(int r=1;r<n+1;r++){
                if((arr[c][r] > arr[c-1][r]) && (arr[c][r] > arr[c+1][r]) && (arr[c][r] > arr[c][r-1]) && (arr[c][r] > arr[c][r+1])) //��
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
