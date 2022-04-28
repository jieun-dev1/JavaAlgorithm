package Inflearn.DFS;

public class Binary {

    public void DFS(int n){
        if (n==0) return;
        else {
            DFS(n/2); //dfs 가 먼저 쌓이면, system.out.print 는 나중에 stack 으로 실행됨.
            System.out.print(n%2+" ");
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Binary T = new Binary();
        T.DFS(11);
    }
}
