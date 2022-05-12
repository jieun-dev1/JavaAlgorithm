package Inflearn.DFSBFSProb;

import java.util.Scanner;

//1�� �� Ǯ���µ��� ��ƴ�.. �ٽ� Ǯ��.
//DFS �Ƹ��� ����.
public class DFSSubset2 {
    static String answer = "No";
    static int sum, n;
    static boolean flag = false; //return �� ���� ������ �ִ��� üũ.
    public void DFS(int L, int value, int[] arr){
        if (flag == true) return; //true ��� �̹� answer = Yes. Return �̶�� �� �ش� if ���� ������ ���ΰŰ���. ���� if ������ ��� �Ѿ.
        if (value>sum/2) return; // value �� �� ũ�ٸ�, �� ����� �ʿ䰡 ����.
        //L �� ������. 0���� �����ϴ� ������ 1�� �ҷ�����. 1�� �ְ�/���� ���.
        //���� ã�´ٸ�, ���⼭ flag �� ǥ�����ְ�. �ƴ� ���� ��͸� Ÿ�� �������� ��.
        //�� ������ DFS �̰�, ó������ ������ ���Ҹ� Ž���ؾ� �Ѵ� (EX. 6�� ��. O/X���� �����̱� ������ L=n)
        if(L==n){
            if(sum%2==0 && value == sum/2){ //Ȧ���̸� �ȵǱ� ����.
                answer = "YES";
                flag = true;
            }
        }

        else {
            DFS(L+1, value+arr[L], arr); //(�� arr ��ü�� �ƴ϶�, o/x ������ �������� �ش� ���Ұ��� ���� ��. ���⼭ �߿��� ���� ��.
            DFS(L+1, value, arr);
        }
    }

    public static void main(String[] args){
        DFSSubset2 T = new DFSSubset2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        T.DFS(0, 0,arr);
        System.out.println(answer);
    }
}
