package Inflearn.DFS;

import java.util.ArrayList;
import java.util.Scanner;

//13. 경로탐색(인접리스트)
//한번의 DFS 사이클이 도는 동안 STACKFRAME 에 쌓임. 재귀함수와 스택 프레임. return 이 되면 스택 프레임에서 pop되고 그 이전 주소 가리킨다.

public class GraphList {

    static int n;
    static int m;
    static int answer;
    static ArrayList<ArrayList<Integer>> graph ;
    static int[] ch;
    public void DFS(int v) {
        if (v == n) answer++;
        else {
            for(int nv:graph.get(v)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }

    }

    public static void main(String[] args) {
        GraphList T = new GraphList();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<ArrayList<Integer>>(); //왜 new 를 이렇게 해주지?
        for(int i=0;i<=n;i++){ //인덱스별 배열을 만들어야 해서
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1]; //체크 배열은 n 인덱스 활용 위해 n_1크기 생성.
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b); //ArrayList.get(index)를 하면 해당 번쨰의 ArrayList를 가져올 수 있음.
        }
        ch[1] = 1;//1에서 시작하니까 ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}
