//package Inflearn.Greedy;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
///*
//https://m.blog.naver.com/ndb796/221230994142
//ũ�罺Į �˰����̶�? ���� ���� ������� ��� ��带 �����ϱ� ���� ����ϴ� �˰���
//���: ����/����
//����: �Ÿ�/���
//�ּ� ���� ����: ��� ���� -1
//
//����
//(1) ����Ŭ ���̺� ���� (�θ� ��� ã��)
//(2) ��� ���� ���� ������ ����
//(3) ��� ������ ��� ���� �������� ���� (�ּ� ����� �������� �����ϱ� ����)
//(4) ����Ŭ ���̺��� ���� �����ϴٸ�, �����Ѵ�.
//�� ������ ���Ե� �׷����� ������� ����
//(5) ����Ŭ�� �߻��ϸ� ��� �׷����� ����. distance �߰�.
//
//*�ּ� ��� ���� Ʈ�������� ����Ŭ�� �߻��ϸ� �ȵ� (��� ��带 ���̴� �Ϳ��� ���� �ƴ�)
//
//3���� ��Ҹ� ��� Ŭ����
//�ּ� ����� ���� ������ ������ ��� �̾�����?
//
//ArrayList �� class�� ��� ���� �����ϱ� - Implements Comparable
//�� ������ ������ ��������?
//
//���� ��.
//���� �ƴ� �־��� Ŭ������ ã�ƾ� �Ѵ�.
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
//    Find �Լ��� ����: 1��, 2�� � ���� ���� ��ȣ�� ���� ����.
//    ���� ��: v�� �״�� �������ְ�,
//    �ٸ� ��: unf[fa] = fb�� �Ǿ�� ��.
//    Union �ϸ鼭 ó�� find�� �� ����, if(v == unf[v]) �� �ش�
//    Union�� �ϸ鼭, Find�� ���� v(������ ��) ������� �Ŀ���
//    ���� v!=unf[v] ��찡 �����,
//    �ε����� ���� ����ġ�ϴ� ���� ã���ְ� ��.
//
//
//    */
//class WonderTree {
//    static int edgeCnt;
//    static ArrayList<Edge> arr;
//    static int[] unf;
//    static int answer = 0;
//
//    //Find �� �θ� ã�� ���� ��͸� ����. (x==unf[x])�� �ƴ϶�� �� == �θ��尡 ���� �ִٴ� �� �Ϲ������� �θ�� �� �� ���� �� ����.
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
//    //�θ� ���ٸ� �Ѿ�� ������, �θ� ���� ���� ���� ��������� �Ѵ�. ���� �� ���̺��� ���������� �θ� ����.
//    //���� ��带 �θ�� �Ѵ�
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
//    //���� �θ� ������ Ȯ���ϴ� ����: �θ� ���ٸ�, ������ص� �� �θ� �ٸ��ٸ�, �������ָ鼭 �θ� ������ (��� ����ġ 0�� 1)
//    public static void FindParents() {
//        if() {
//
//        }
//    }
//
//    //�迭�� ��ȸ�ϸ鼭
////    public int solution(int x, int y) {
////        for(int i=0;i<edgeCnt;i++) {
////            //�θ� ������, skip
////            if()
////        }
////        return answer;
////    }
//
//    public static void main(String[] args) {
//        WonderTree T = new WonderTree();
//        Scanner sc = new Scanner(System.in);
//        edgeCnt = sc.nextInt();
//        int connectCnt = sc.nextInt(); //������ ������ŭ ȸ���Ѵ�.
//        unf = new int[edgeCnt+1];
//        //����Ŭ ���̺��� �ʱ�ȭ
//        for(int i=1;i<=edgeCnt;i++) {
//            unf[i] = i;
//        }
//        arr = new ArrayList<>();
//        for(int i=0;i<connectCnt;i++) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            int cost = sc.nextInt();
//            arr.add(new Edge(x,y,cost)); //1. ��� ��带 �Է��Ѵ�.
//        }
//
//        Collections.sort(arr); //2. ��� ���� �������� �����Ѵ�.
//        T.
//        for(int i=0;i<connectCnt;i++) { // 3. ������ n-1�� ������ ��.
//            if()
//             T.Union(x,y); //object�� ��� ���� ���!
//        }
//    }
//}
