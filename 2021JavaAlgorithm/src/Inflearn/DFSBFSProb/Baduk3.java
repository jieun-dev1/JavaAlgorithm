package Inflearn.DFSBFSProb;
//static 쓰지 않고 재귀함수? answer를 static 쓰지 않게 되면, DFS 마다 다른 answer 가 생긴다. 즉 공유가 안된다는 것. 한 스택이 pop 되면 answer이 다시 integer_minvalue로 초기화.
//테스트 - static 은 answer 만 사용/ if sum>limit 을 앞에서 거름.
//183ms.
import java.util.Scanner;

public class Baduk3 {
    static int answer = Integer.MIN_VALUE;
    public void DFS(int cl,int sum, int[] arr, int limit, int num) {
        if(sum>limit) return; //레벨이 같지 않아도 한도 초과시 높으면 걸러줄 수 있음.
            if(cl == num) {
                answer = Math.max(sum, answer);
                return;
            }
        else {
            DFS(cl+1, sum+arr[cl], arr, limit,  num);
            DFS(cl+1, sum, arr, limit,  num);
        }
    }

    public static void main(String[] args){
        Baduk3 T = new Baduk3();
        Scanner sc = new Scanner(System.in);
        int limit = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }

        T.DFS(0, 0, arr, limit, num);
        System.out.println(answer);
    }
}
