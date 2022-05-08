package Inflearn.DFS;

import java.util.ArrayList;
import java.util.Scanner;

//13. ���Ž��(��������Ʈ)
//�ѹ��� DFS ����Ŭ�� ���� ���� STACKFRAME �� ����. ����Լ��� ���� ������. return �� �Ǹ� ���� �����ӿ��� pop�ǰ� �� ���� �ּ� ����Ų��.

public class GraphList {

    static int n;
    static int m;
    static int answer;
    static ArrayList<ArrayList<Integer>> graph ;
    static int[] ch;
    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for(int nv:graph.get(v)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }

    }

    public static void main(String[] args) {
        GraphList T = new GraphList();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(); //�� new �� �̷��� ������?
        for(int i=0;i<=n;i++){ //�ε����� �迭�� ������ �ؼ�
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1]; //üũ �迭�� n �ε��� Ȱ�� ���� n_1ũ�� ����.
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); //ArrayList.get(index)�� �ϸ� �ش� ������ ArrayList�� ������ �� ����.
        }
        ch[1] = 1;//1���� �����ϴϱ� ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}
