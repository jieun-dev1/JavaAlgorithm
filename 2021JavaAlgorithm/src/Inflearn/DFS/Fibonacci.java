package Inflearn.DFS;

public class Fibonacci {


//����
//ù°, ��° ���� 1�̸� �� ���� ��� ���� �ٷ� �� �� ���� ���� ����.
//
//FOR ���� ��ͺ��� ������.
//��ʹ� ������������ �����, �ٽ� LIFO�� �б� ������.
//
//�޸������̼�: ����Լ��� �ߺ� ȣ���� ����.
//��� �޸������̼ǵ� FOR �����ٵ� ������ ��������?
//DFS �ַ�ǿ��� int[] fibo �� �޾ƿ��� �ʰ� static ���� ����
//Ŭ���� ������(==static ����)  static ���� ����ȴ�. ��ü�� ������ �����Ǿ static ������ ó���� �� ���� �����ǰ� ������ Ŭ������
//��ü�鿡 ���ؼ� ������ �ȴ�. �ν��Ͻ� ������ Non-static �̰�, ��ü ���� �ø��� �Ź� ���ο� ������ ���� �ȴ�.
//dfs(n) �� n �� fibo �� �ε������� ���̴� n �� ����.
    static int[] fibo; //static ���� �����ϸ� solution ������ ���� ����.

    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n] = 1; //
        else if(n==2) return fibo[n] = 1;
        else return fibo[n] = DFS(n-2)+DFS(n-1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Fibonacci T = new Fibonacci();
        int n=45;
        fibo = new int[n+1]; //���⼭ static �� �ƴ϶� ���� int[] �� ������ ���, NullPointerEXCEPTION
        T.DFS(n);
        for(int i=1;i<=n;i++){
            System.out.println(fibo[i]);
        }
    }

//    public int DFS(int n){
//        if(n==1) return 1; //
//        else if(n==2) return 1;
//        else return DFS(n-2)+DFS(n-1);
//    }
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Fibonacci T = new Fibonacci();
//        int n=10;
//        for(int i=1;i<=n;i++){
//            System.out.println(T.DFS(i));
//        }
//    }

}
