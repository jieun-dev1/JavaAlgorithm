package Inflearn.Greedy;

import java.util.Scanner;

/*
참고: https://www.secmem.org/blog/2021/03/21/Disjoint-Set-Union-find/
https://blog.naver.com/ndb796/221230967614
문제 개요: 서로소 집합 자료 구조 (disjoint-set, union-find 등으로도 불림)
*고급 알고리즘의 기초가 되는 알고리즘이니 꼼꼼히 보자.

1. 서로소 집합이란?
-서로 공통된 원소를 가지고 있지 않은 두 개 이상의 집합.
-여러 개의 노드가 존재하는 상황에서, 두 개의 노드를 선택하고, 현재 이 두 노드가 서로 같은 그래프에 속하는지 판별함.
-같은 집합에 속하는 원소는, 루트가 같다 == 루트가 다르면 다른 트리에 속한다.

2. 문제에 어떻게 적용할까?
연결되어 있는 원소들은 유일하니, 연결된 원소끼리 집합으로 묶는다.
연결되어 있다 == 루트가 같다

3.구현
(1) 모든 값이 자기 자신을 가리키도록 초기 설정 (== 연결되지 않고, 자기 자신만을 집합의 원소로 갖는다)
첫 번째 행(인자)는 노드 번호 & 두 번째 행은 부모 노드
(2) 본 코드에서는 1-2를 연결할 때 1->2라고 생각해서, 2를 부모라고 했다. 하지만 보통 부모를 합칠 때는, 더 작은 값쪽으로 합친다 (1-2 라면, 1이 부모)

 궁금한 것: 그래프를 구분하는 것도 함수로 해보자.

자바에서 static 키워드를 쓴다는 것은? https://mangkyu.tistory.com/47
메모리에 한번 할당되어서, 프로그램이 종료될 때 해제되는 것.
단점: GC 관리영역 밖. STATIC 자주 사용하면, 프로그램이 종료 까지 메모리가 할당된 채로 존재. 자주 사용하면 시스템 퍼포먼스에 악영향.
Static 메서드에서 접근하는 변수 역시 static 이 선언되어야 한다.
: 메모리 할당과 연관 지어서 생각해본다면, static은 객체의 생성과 상관없이 접근. non-static 은 할당되지 않은 메모리 영역. 즉 할당되지 않은 영역에 접근하니까, 문제가 발생하는 것.

 */
public class UnionFind {

    static int[] arr;

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        arr[fa] = fb;
    }


    public static int Find(int v) {
        if(v == arr[v]) return v;
        else {
            return arr[v] = Find(arr[v]);
        }
    }

    //solution: 부모 노드가 같으면 skip한다.

    public static void main(String[] args) {
        UnionFind T = new UnionFind();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        arr = new int[cnt+1];
        //우선 i 입력.
        for(int i=1;i<=cnt;i++) {
            arr[i] = i;
        }
        int pair = sc.nextInt();
        for(int i=0;i<pair;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.Union(a,b);
        }

        int givenX = sc.nextInt();
        int givenY = sc.nextInt();

        //givenX와 givenY의 부모가 같은지 찾자.
        int fx = Find(givenX);
        int fy = Find(givenY);

        if(fx==fy) System.out.println("YES");
        else {
            System.out.println("NO");
        };
    }
}

/*
9 7
1 2
2 3
3 4
1 5
6 7
7 8
8 9
3 8

첫 번째 줄에 “YES"또는 "NO"를 출력한다.
 */