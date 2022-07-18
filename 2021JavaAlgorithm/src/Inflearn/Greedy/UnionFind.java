package Inflearn.Greedy;

import java.util.Scanner;

/*
����: https://www.secmem.org/blog/2021/03/21/Disjoint-Set-Union-find/
���� ����: ���μ� ���� �ڷ� ���� (disjoint-set, union-find �����ε� �Ҹ�)
���μ� �����̶�? ���� ����� ���Ҹ� ������ ���� ���� �� �� �̻��� ����.
���� ���տ� ���ϴ� ���Ҵ�, ��Ʈ�� ���� == ��Ʈ�� �ٸ��� �ٸ� Ʈ���� ���Ѵ�.

����:
����Ǿ� �ִ� ���ҵ��� �����ϴ�, ����� ���ҳ��� �������� ���´�.
����Ǿ� �ִ� == ��Ʈ�� ����


 */
public class UnionFind {

    static int[] arr;
    /*
    Find�Լ��� ����: 1��, 2�� � ���� ���� ��ȣ�� ���� ����.
    ���� ��: v�� �״�� �������ְ�,
    �ٸ� ��: unf[fa] = fb�� �Ǿ�� ��.
    Union�ϸ鼭 ó�� find�� �� ����, if(v == unf[v]) �� �ش�
    Union�� �ϸ鼭, Find�� ���� v(������ ��) ������� �Ŀ���
    ���� v!=unf[v] ��찡 �����,
    �ε����� ���� ����ġ�ϴ� ���� ã���ְ� ��.
    */

    //���� �ٸ��� ������, �ٸ� ��츸 ���տ� �־��ִ� ���̴�.
    public void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if(fa!=fb) arr[fa] = fb; // fa �� fb�� �ٸ��ٴ� ���� ���� ����Ǿ� �ִٴ� ���̴�.
    }

    public int Find(int v) {
        if (v == arr[v]) return v; //Union �ϱ� ��.
        else {
            return arr[v]; //Union �� ��.
        }
    }

    //1. �־��� �Է��� Union�� ���ļ� ����
    //�ʱ�ȭ�� i�� ����/ �ӽ� ��������, i�� (v�� �ε�����) ���� ����: 4�� ������ ������, find�Լ� ���ĵ� 4��. �̹� 4�� �� �־, Union���� ������ ���ص� �Ǳ� �����̴�.
    //unf[v] = Find(unf(V))�� �ϴ� ����: ������ ���ؼ�
    public static void main(String[] args) {
        UnionFind T = new UnionFind();
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        arr = new int[cnt+1];
        //�켱 i �Է�.
        for(int i=1;i<=cnt;i++) {
            arr[i] = i;
        }
        int pair = sc.nextInt();
        for(int i=0;i<pair;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            T.Union(a,b);
        }

        //�־��� ���� �������� ����.
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

ù ��° �ٿ� ��YES"�Ǵ� "NO"�� ����Ѵ�.
 */