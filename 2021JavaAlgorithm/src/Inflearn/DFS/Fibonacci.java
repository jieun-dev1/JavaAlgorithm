package Inflearn.DFS;

public class Fibonacci {


//정의
//첫째, 둘째 항이 1이며 그 뒤의 모든 항은 바로 앞 두 항의 합인 수열.
//
//FOR 문이 재귀보다 빠르다.
//재귀는 스택프레임을 만들고, 다시 LIFO로 읽기 떄문에.
//
//메모이제이션: 재귀함수의 중복 호출을 보완.
//재귀 메모이제이션도 FOR 문보다도 성능이 안좋겠지?
//DFS 솔루션에서 int[] fibo 를 받아오지 않고 static 으로 선언
//클래스 변수는(==static 변수)  static 으로 선언된다. 객체가 여러번 생성되어도 static 변수는 처음에 한 번만 생성되고 동일한 클래스의
//객체들에 의해서 공유가 된다. 인스턴스 변수는 Non-static 이고, 객체 생성 시마다 매번 새로운 변수가 생성 된다.
//dfs(n) 의 n 과 fibo 의 인덱싱으로 쓰이는 n 이 같음.
    static int[] fibo; //static 으로 선언하면 solution 에서도 접근 가능.

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
        fibo = new int[n+1]; //여기서 static 이 아니라 새로 int[] 를 생성할 경우, NullPointerEXCEPTION
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
