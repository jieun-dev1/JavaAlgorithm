package Inflearn.DFSBFSProb;

import java.util.Scanner;
//174ms - if (sum>max)�� 10ms �� ���������. an
//boolean flag �ʿ� x ������ ������� ��� ���� ����. ���� ã����, return �ؼ� �����ϴ� ��찡 �ƴϰ� ��� ����.
public class Baduk4 {

    static int answer = Integer.MIN_VALUE, max, L;
    public void DFS(int cl, int sum, int arr[]) {
        if(sum > max) return;
        if(cl == L){
            answer = Math.max(answer, sum);
        }
        else {
            DFS(cl+1, sum+arr[cl], arr);
            DFS(cl+1, sum, arr);
        }
    }

    public static void main(String[] args){
        Baduk4 T = new Baduk4();
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

//
//�׽�Ʈ int max (�ѵ�), L(������ ����) �� �Ű������� �ٲ��� ��.
//176ms  - static ������ ���� �� �� 2ms ����.
