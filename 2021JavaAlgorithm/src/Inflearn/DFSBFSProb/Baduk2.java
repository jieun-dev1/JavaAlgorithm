package Inflearn.DFSBFSProb;

import java.util.Scanner;
//boolean flag ���� �ʴ°�, 2�� �� ������.
//boolean �� ������ ������� ��� ���� �����̴�. ���� ã����, return �ؼ� �����ϴ� ��찡 �ƴϰ� ��� ����.
public class Baduk2 {

    static int max, L;
    static int answer = Integer.MIN_VALUE;
    public void DFS(int cl, int sum, int arr[]) {
        if(cl == L){
            if(sum < max)
            answer = Math.max(answer, sum);
        }
        else {
            DFS(cl+1, sum+arr[cl], arr);
            DFS(cl+1, sum, arr);
        }
    }

        public static void main(String[] args){
        Baduk2 T = new Baduk2();
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        L = sc.nextInt();
        int [] arr = new int[L];
        for(int i=0;i<L;i++){
            arr[i] = sc.nextInt();
        }
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
