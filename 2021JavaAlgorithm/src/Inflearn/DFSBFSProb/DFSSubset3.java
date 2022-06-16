package Inflearn.DFSBFSProb;

import Inflearn.DFS.DFS;

import java.util.Scanner;

//1. arr�� �� ���� �ұ�?
//2. ����Լ��� �� �� static �� �ǹ� - ANSWER�� �ϳ��� ����Ű�ϱ�, static �̾ ��. arr, cnt, totalSum(�迭 �� ��) � ������ �ʴ� ���̴� static.
//3. answer �� "No"�� �����ϸ�, /2�� 0�� �ƴ� ��� (������ Ȧ������ Ž���ص� ���� ������ ���� ���)
//4. �信���� arr �� ���ڷ� ������, �ȵ��� �����ϰ� �ҿ�ð��� 1ms ����.

public class DFSSubset3 {
    static String answer = "NO";
    static int[] arr;
    static int cnt, totalSum = 0;
    boolean flag = false; // answer �� ������ ã�Ҵٸ�, ���� ��� Ž���� �ʿ䰡 ����. ���θ� ���� �����̱� ����.

    //����, �ش� index, sum
    public void DFS(int L,int sum) {
        if (flag == true) return; //�̹� ���� ã������ �� �������� ����.
        if (sum > totalSum/2) return; //sum �� �� ũ�ٸ�, ���� ���� �̻��� �����̴� return.
//        if(totalSum%2!=0) return; //�� �̻� Ž�� �������� ����. ¦���� ��쿡��, else ���� ����Լ� �ҷ���.
//        if (answer == "YES") return;

        if(L==cnt) {
            if(totalSum%2 ==0 && sum == totalSum/2) {
                answer = "YES";
                flag = true;
            }
        }

        else {
            DFS(L+1,sum+arr[L]);
            DFS(L+1,sum);
        }

        //L�� ������ �� cnt �� ���ٸ�, answer �� ������ֱ�.

    }

    public static void main(String[] args) {
        DFSSubset3 T = new DFSSubset3();
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        arr = new int[cnt];
        for(int i=0;i<cnt;i++) {
            arr[i] = sc.nextInt();
            totalSum+=arr[i];
        }
        //����ؾ� �ϴ� �� (arr �� cnt ���̿� ���� �ٸ� ��)
        //T.DFS �� System.out.println�� ���� (x) -> ��͸� �����鼭 Ž���� ��, �����/Ȥ�� ������� ���� answer�� �μ�.
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
