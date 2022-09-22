package Inflearn.Greedy;

import java.util.Scanner;

/*
����: https://www.secmem.org/blog/2021/03/21/Disjoint-Set-Union-find/
https://blog.naver.com/ndb796/221230967614
���� ����: ���μ� ���� �ڷ� ���� (disjoint-set, union-find �����ε� �Ҹ�)
*��� �˰����� ���ʰ� �Ǵ� �˰����̴� �Ĳ��� ����.

1. ���μ� �����̶�?
-���� ����� ���Ҹ� ������ ���� ���� �� �� �̻��� ����.
-���� ���� ��尡 �����ϴ� ��Ȳ����, �� ���� ��带 �����ϰ�, ���� �� �� ��尡 ���� ���� �׷����� ���ϴ��� �Ǻ���.
-���� ���տ� ���ϴ� ���Ҵ�, ��Ʈ�� ���� == ��Ʈ�� �ٸ��� �ٸ� Ʈ���� ���Ѵ�.

2. ������ ��� �����ұ�?
����Ǿ� �ִ� ���ҵ��� �����ϴ�, ����� ���ҳ��� �������� ���´�.
����Ǿ� �ִ� == ��Ʈ�� ����

3.����
(1) ��� ���� �ڱ� �ڽ��� ����Ű���� �ʱ� ���� (== ������� �ʰ�, �ڱ� �ڽŸ��� ������ ���ҷ� ���´�)
ù ��° ��(����)�� ��� ��ȣ & �� ��° ���� �θ� ���
(2) �� �ڵ忡���� 1-2�� ������ �� 1->2��� �����ؼ�, 2�� �θ��� �ߴ�. ������ ���� �θ� ��ĥ ����, �� ���� �������� ��ģ�� (1-2 ���, 1�� �θ�)

 �ñ��� ��: �׷����� �����ϴ� �͵� �Լ��� �غ���.

�ڹٿ��� static Ű���带 ���ٴ� ����? https://mangkyu.tistory.com/47
�޸𸮿� �ѹ� �Ҵ�Ǿ, ���α׷��� ����� �� �����Ǵ� ��.
����: GC �������� ��. STATIC ���� ����ϸ�, ���α׷��� ���� ���� �޸𸮰� �Ҵ�� ä�� ����. ���� ����ϸ� �ý��� �����ս��� �ǿ���.
Static �޼��忡�� �����ϴ� ���� ���� static �� ����Ǿ�� �Ѵ�.
: �޸� �Ҵ�� ���� ��� �����غ��ٸ�, static�� ��ü�� ������ ������� ����. non-static �� �Ҵ���� ���� �޸� ����. �� �Ҵ���� ���� ������ �����ϴϱ�, ������ �߻��ϴ� ��.

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

    //solution: �θ� ��尡 ������ skip�Ѵ�.

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

        int givenX = sc.nextInt();
        int givenY = sc.nextInt();

        //givenX�� givenY�� �θ� ������ ã��.
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

ù ��° �ٿ� ��YES"�Ǵ� "NO"�� ����Ѵ�.
 */