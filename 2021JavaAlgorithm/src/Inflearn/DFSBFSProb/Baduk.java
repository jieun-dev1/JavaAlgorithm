package Inflearn.DFSBFSProb;

import java.util.Scanner;

/**
 * StackOverFlow ����.
 * flag �� static �̸� �ȵ�. ���� ���������� answer �� ������ flag �� true �� return ���� �Լ� ����������,
 * ���⼭�� ��� ��θ� ���� ���� ���� �����Ѵ�. flag �� �������� �����Ǹ� �ȵ�.
 */
public class Baduk {
    static int max;
    static int answer = Integer.MIN_VALUE; // ���� ���������� �ʱ�ȭ ����.
    static int L;
    boolean flag = false;
    public void DFS(int cl, int sum, int arr[], Boolean flag){
        if (flag == true) return;
        if(cl == L){
//            if (sum<max && sum>answer)
//                answer = sum;
            if(sum<max)
                answer = Math.max(answer, sum);//�ڵ尡 ���� ª��.
            flag = true;
        } else {
            DFS(cl+1, sum+arr[cl],  arr, false);
            DFS(cl+1, sum, arr, false);
        }

    }
    public static void main(String[] args){
        Baduk T = new Baduk();
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        L = sc.nextInt();
        int [] arr = new int[L];
        for(int i=0;i<L;i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0, arr, false);
        System.out.println(answer);
    }
}
