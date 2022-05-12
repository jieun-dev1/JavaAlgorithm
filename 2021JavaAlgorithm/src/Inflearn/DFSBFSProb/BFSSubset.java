package Inflearn.DFSBFSProb;

import java.util.Scanner;
//�׿��ִ� Queue �� ������ ȣ������ �ʰ�, flag �� yes �̸� �ٷ� return �� �� �ֵ���.

//return�� �Ѵٴ� ���� ���� �����Ű�� �ʰ�, �Ѿ�ٴ� ��.

/**
 * ���� total�� 125�̸� 125/2==62�� ���� �˴ϴ�. �̷� ��츦 �����ϱ� ���Ͽ�
 * if(total%2==0 && (total / 2) == sum)
 */

public class BFSSubset {
    static String answer="NO";
    static int n,total=0;
    boolean flag = false;

    public void DFS(int L, int sum, int[] arr){
        if(flag) return;
        if(sum>total/2) return;
        if(L==n){
            if(total/2 == sum) {
                answer = "YES";
                flag = true;
            }

        }
        else {
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }

    }

    public static void main(String[] args) {
        BFSSubset T = new BFSSubset();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //�ش� ���� n�� �ƴ϶� int n�� �ع����� static �� ������ �ٲٴ� �� �ƴϾ. ��Ͱ� ���� �ʴ´�. L=n=0���� ����������. n�� �Ű������� �Ѱ��ִ���, static ���� �����ؾ� ��.
        int[] arr = new int[n];
        for(int i=0; i<n;i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}
