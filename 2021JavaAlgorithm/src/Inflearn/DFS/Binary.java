package Inflearn.DFS;

public class Binary {

    public void DFS(int n){
        if (n==0) return;
        else {
            DFS(n/2); //dfs �� ���� ���̸�, system.out.print �� ���߿� stack ���� �����.
            System.out.print(n%2+" ");
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Binary T = new Binary();
        T.DFS(11);
    }
}
