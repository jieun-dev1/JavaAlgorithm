package Inflearn.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
PriorityQueue ��?
Queue�� ����ü��. Queue: �θ� PriorityQueue: �ڽ�
PriorityQueue�� ���̶�� �ڷ� ������ ����ȴ�.
Queue�� fifo������, PriorityQueue�� ������ ������ ���� ���� �켱������ ���� �ͺ��� �����ٴ� Ư¡�� �ִ�.
ex. 3,1,2,5.4 ������ �־�����, ����غ��� 1,2,3,4,5 ��. 1���� (���ڰ� ���� ���� ���� ���̶�) ���� ���̴�.

����
1. Comparable implements �ϰ�, compareTo�� M (����) ���� ������ �����Ѵ�.
2. D �� ������ �ʿ䰡 ����. �׷��� ��ȥ�� ����ó�� Ŭ������ ������� �ʿ� ����.
3. ���� ū d�� �� max��.
4. M �� �����ϸ�, m�� ���� ������� �켱������ ���� �� ���̴�. ���� �ͺ��� ���� �ִ� ������ ������ reverse Order�� ����.
���� ��: Collections.sort()�� �����ϰ� ������, List �� ������. Queue�� ��� ��������?
Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
��: Queue�� ���� ��, �ȿ� Collection.reverseOrder()
 */
//
//class Slot implements Comparable<Slot> {
//    int M;
//    int D;
//
//    Slot(int M, int D) {
//        this.M = M;
//        this.D = D;
//    }
//
//    @Override
//    public int compareTo(Slot o) {
//        return o.M - this.M;
//    }
//}

class PriorityQueueEx {

    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int max = 0;
        int answer = 0;
        for(int i=0; i<cnt;i++) {
            int M = sc.nextInt();
            int D = sc.nextInt();
            q.offer((M));
            if(D>max) {
                max = Math.max(D, max);
            }
        }
        for(int i=0;i<max;i++) {
//            System.out.println(q.poll());
                    answer += q.poll();
        }
        System.out.println(answer);
    }
}
