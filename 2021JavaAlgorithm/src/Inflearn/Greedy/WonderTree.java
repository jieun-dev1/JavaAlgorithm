//package Inflearn.Greedy;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
///*
//https://m.blog.naver.com/ndb796/221230994142
//크루스칼 알고리즘이란? 가장 적은 비용으로 모든 노드를 연결하기 위해 사용하는 알고리즘
//노드: 정점/도시
//간선: 거리/비용
//최소 간선 갯수: 노드 갯수 -1
//
//구현
//(1) 사이클 테이블 세팅 (부모 노드 찾기)
//(2) 노드 별로 간선 정보를 저장
//(3) 모든 간선을 비용 기준 오름차순 정렬 (최소 비용인 간선부터 연결하기 위함)
//(4) 사이클 테이블의 값이 동일하다면, 무시한다.
//각 정점이 포함된 그래프가 어디인지 저장
//(5) 싸이클이 발생하면 결과 그래프에 포함. distance 추가.
//
//*최소 비용 신장 트리에서는 사이클이 발생하면 안됨 (모든 노드를 붙이는 것에서 끝이 아님)
//
//3가지 요소를 담는 클래스
//최소 비용을 내는 간선의 조합을 어떻게 이어주지?
//
//ArrayList 를 class의 비용 별로 정렬하기 - Implements Comparable
//왜 오름차 순으로 정렬하지?
//
//막힌 곳.
//값이 아닌 주어진 클래스로 찾아야 한다.
// */
//
//
//class Edge implements Comparable<Edge> {
//    int x;
//    int y;
//    int cost;
//
//    public Edge(int x, int y, int cost) {
//        this.x = x;
//        this.y = y;
//        this.cost = cost;
//    }
//
//    @Override
//    public int compareTo(Edge o) {
//        return this.cost - o.cost ;
//    }
//}
//
///*
//    Find 함수의 역할: 1번, 2번 등에 대한 집합 번호를 리턴 해줌.
//    같을 때: v를 그대로 리턴해주고,
//    다를 때: unf[fa] = fb가 되어야 함.
//    Union 하면서 처음 find를 쓸 떄는, if(v == unf[v]) 만 해당
//    Union을 하면서, Find를 통해 v(집합의 값) 집어넣은 후에는
//    이제 v!=unf[v] 경우가 생기고,
//    인덱스와 값이 불일치하는 값을 찾아주게 됨.
//
//
//    */
//class WonderTree {
//    static int edgeCnt;
//    static ArrayList<Edge> arr;
//    static int[] unf;
//    static int answer = 0;
//
//    //Find 는 부모를 찾기 위해 재귀를 돈다. (x==unf[x])가 아니라는 것 == 부모노드가 따로 있다는 것 일반적으로 부모는 둘 중 작은 값 리턴.
//    public static int Find(int x) {
//        if(x < unf[x]) {
//            return unf[x] = Find(unf[x]);
//        }
//        else if (x>unf[x]) {
//            return unf[x] = Find(unf[x]);
//        }
//        else return x;
//    }
//
//    //부모가 같다면 넘어가도 되지만, 부모가 같지 않을 경우는 연결해줘야 한다. 이제 두 테이블을 연결했으니 부모가 같다.
//    //작은 노드를 부모로 한다
//    public static void Union(int x, int y) {
//        int fx = Find(x);
//        int fy = Find(y);
//
//        if(fx>fy) unf[x] = fy;
//        else {
//            unf[y] = fx;
//            answer+= arr.get(y).cost;
//        }
//    }
//    //같은 부모를 갖는지 확인하는 이유: 부모가 같다면, 연결안해도 됨 부모가 다르다면, 연결해주면서 부모를 리턴함 (비용 가중치 0과 1)
//    public static void FindParents() {
//        if() {
//
//        }
//    }
//
//    //배열을 순회하면서
////    public int solution(int x, int y) {
////        for(int i=0;i<edgeCnt;i++) {
////            //부모가 같으면, skip
////            if()
////        }
////        return answer;
////    }
//
//    public static void main(String[] args) {
//        WonderTree T = new WonderTree();
//        Scanner sc = new Scanner(System.in);
//        edgeCnt = sc.nextInt();
//        int connectCnt = sc.nextInt(); //간선의 갯수만큼 회전한다.
//        unf = new int[edgeCnt+1];
//        //사이클 테이블의 초기화
//        for(int i=1;i<=edgeCnt;i++) {
//            unf[i] = i;
//        }
//        arr = new ArrayList<>();
//        for(int i=0;i<connectCnt;i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            int cost = sc.nextInt();
//            arr.add(new Edge(x,y,cost)); //1. 모든 노드를 입력한다.
//        }
//
//        Collections.sort(arr); //2. 비용 기준 오름차순 정렬한다.
//        T.
//        for(int i=0;i<connectCnt;i++) { // 3. 간선은 n-1만 있으면 됨.
//            if()
//             T.Union(x,y); //object를 어떻게 쓸지 고민!
//        }
//    }
//}
