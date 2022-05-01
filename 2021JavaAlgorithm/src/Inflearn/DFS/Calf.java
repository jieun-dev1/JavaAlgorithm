package Inflearn.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calf {
    int[] dis = {1,-1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();

    public int BFS(int s, int e){
    ch = new int[10001]; //�ε����� 1���� ����ϱ� ����. 0 - 10000������ ���������.
    ch[s]=1; //���� �� �ִ� ���� �̹� �ִ� ��. Queue���� �������� ����.
    Q.offer(s); //���� ���� 5
    int L = 0;

    while(!Q.isEmpty()){
        int len = Q.size();
        for(int i=0;i<len;i++){
            int a = Q.poll();
            for(int j=0;j<3;j++){
                int b = a+dis[j];
                if(b==e) return L+1;
                if (ch[b]==0 && b>=1 && b<=10000){
                    Q.offer(b);
                }
            }
        }
        L++;
    }
    return 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Calf T = new Calf();
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(T.BFS(s,e));
    }
}
