package Inflearn.DFS;

public class Factorial {

    public int DFS(int n){
        if(n==1) return 1; //1�� �� factorial �� �ƴ϶� �׳� 1�� return ����. void ��� * ������ �� �� ����.
        else return n*DFS(n-1);

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Factorial T = new Factorial();
        System.out.println(T.DFS(3));
    }

}
