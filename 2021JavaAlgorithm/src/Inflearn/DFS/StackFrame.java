package Inflearn.DFS;


public class StackFrame {

    public void DFS (int n) {
        if(n==0) return;
        else {
            DFS(n-1);
            System.out.println(n+" ");
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StackFrame T = new StackFrame();
        T.DFS(3);
    }

}
