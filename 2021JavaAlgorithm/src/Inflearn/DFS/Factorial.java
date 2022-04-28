package Inflearn.DFS;

public class Factorial {

    public int DFS(int n){
        if(n==1) return 1; //1일 땐 factorial 이 아니라 그냥 1을 return 해줌. void 라면 * 연산을 할 수 없다.
        else return n*DFS(n-1);

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Factorial T = new Factorial();
        System.out.println(T.DFS(3));
    }

}
