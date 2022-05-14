package Inflearn.DFSBFSProb;
//static ���� �ʰ� ����Լ�? answer�� static ���� �ʰ� �Ǹ�, DFS ���� �ٸ� answer �� �����. �� ������ �ȵȴٴ� ��. �� ������ pop �Ǹ� answer�� �ٽ� integer_minvalue�� �ʱ�ȭ.
//�׽�Ʈ - static �� answer �� ���/ if sum>limit �� �տ��� �Ÿ�.
//183ms.
import java.util.Scanner;

public class Baduk3 {
    static int answer = Integer.MIN_VALUE;
    public void DFS(int cl,int sum, int[] arr, int limit, int num) {
        if(sum>limit) return; //������ ���� �ʾƵ� �ѵ� �ʰ��� ������ �ɷ��� �� ����.
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
