package Inflearn.Greedy;

import java.util.Scanner;

/*
참고: https://www.secmem.org/blog/2021/03/21/Disjoint-Set-Union-find/
문제 개요: 서로소 집합 자료 구조 (disjoint-set, union-find 등으로도 불림)
서로소 집합이란? 서로 공통된 원소를 가지고 있지 않은 두 개 이상의 집합.
같은 집합에 속하는 원소는, 루트가 같다 == 루트가 다르면 다른 트리에 속한다.

적용:
연결되어 있는 원소들은 유일하니, 연결된 원소끼리 집합으로 묶는다.
연결되어 있다 == 루트가 같다


 */
public class UnionFind {

    static int[] arr;
    /*
    Find함수의 역할: 1번, 2번 등에 대한 집합 번호를 리턴 해줌.
    같을 때: v를 그대로 리턴해주고,
    다를 때: unf[fa] = fb가 되어야 함.
    Union하면서 처음 find를 쓸 떄는, if(v == unf[v]) 만 해당
    Union을 하면서, Find를 통해 v(집합의 값) 집어넣은 후에는
    이제 v!=unf[v] 경우가 생기고,
    인덱스와 값이 불일치하는 값을 찾아주게 됨.
    */

    //서로 다르기 때문에, 다른 경우만 집합에 넣어주는 것이다.
    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) arr[fa] = fb; // fa 와 fb가 다르다는 것은 둘이 연결되어 있다는 것이다.
    }

    public int Find(int v) {
        if (v == arr[v]) return v; //Union 하기 전.
        else {
            return arr[v]; //Union 한 후.
        }
    }

    //1. 주어진 입력을 Union을 거쳐서 세팅
    //초기화에 i를 넣음/ 임시 값이지만, i를 (v에 인덱스를) 넣은 이유: 4는 연결이 없으니, find함수 거쳐도 4다. 이미 4가 들어가 있어서, Union에서 변경을 안해도 되기 때문이다.
    //unf[v] = Find(unf(V))를 하는 이유: 압축을 위해서
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

        //주어진 값이 연결인지 응답.
        int givenX = sc.nextInt();
        int givenY = sc.nextInt();
        String answer ="";
        if(arr[givenX] == arr[givenY]) answer = "YES";
        if(arr[givenX] != arr[givenY]) answer = "NO";

        System.out.println(answer);
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