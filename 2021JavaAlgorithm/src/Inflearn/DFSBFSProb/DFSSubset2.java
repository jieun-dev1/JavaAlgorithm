package Inflearn.DFSBFSProb;

import java.util.Scanner;

//1번 더 풀었는데도 어렵다.. 다시 풀기.
//DFS 아마존 기출.
public class DFSSubset2 {
    static String answer = "No";
    static int sum, n;
    static boolean flag = false; //return 이 같은 지점이 있는지 체크.
    public void DFS(int L, int value, int[] arr){
        if (flag == true) return; //true 라면 이미 answer = Yes. Return 이라는 건 해당 if 문만 나가는 뜻인거같다. 다음 if 문으로 계속 넘어감.
        if (value>sum/2) return; // value 가 더 크다면, 더 계산할 필요가 없다.
        //L 은 레벨임. 0에서 시작하니 다음은 1이 불러와짐. 1이 있고/없는 경우.
        //값을 찾는다면, 여기서 flag 를 표시해주고. 아닐 경우는 재귀를 타고 내려가면 됨.
        //이 문제는 DFS 이고, 처음부터 끝까지 원소를 탐색해야 한다 (EX. 6개 다. O/X별의 조합이기 때문에 L=n)
        if(L==n){
            if(sum%2==0 && value == sum/2){ //홀수이면 안되기 때문.
                answer = "YES";
                flag = true;
            }
        }

        else {
            DFS(L+1, value+arr[L], arr); //(꼭 arr 전체가 아니라, o/x 유무가 가려지는 해당 원소값만 들어가도 됨. 여기서 중요한 것은 합.
            DFS(L+1, value, arr);
        }
    }

    public static void main(String[] args){
        DFSSubset2 T = new DFSSubset2();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        T.DFS(0, 0,arr);
        System.out.println(answer);
    }
}
