package Inflearn.Greedy;

import java.util.ArrayList;
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

1�� ���� ����
(1) ���� �߸� ������.
����(M)���� �ƴ϶� �ð�(d)������ ���� �ʿ�.
�ð�: 3,2,1 ������ ���� ����.
�ð� ������ �����ϴ� ����:
�ð�:
(2) �ڷ� ������ ���� ��,
������ ArrayList����
��¥ ���� PQ�� ��� ���� ���� ������ POLL().
3�� ��¥�� ���� ���Ұ� �ִٸ�, �̸� ���� ������ 2�� ��¥�� ���� ���ҿ� ���Ѵ�.
(3) queue�� �ְ� ����.

2�� ����
(4) ��Ÿ�� ���� ����: q�� empty�� ���� �ֱ� ������, empty�� �ƴ� ��� �б� �ʿ�.
   if ((result = (E) ((es = queue)[0])) != null) {
   ����ü�� ���� null�� �ƴ�, ��� ���Ұ� �ϳ� �ִ� ���� �����ϰ� �ֱ� ������. ���⼭ empty�� �ƴ��� ���ǿ� �־�� ��.
   �ҿ�ð�: 2�ð�.

 */

class Slot implements Comparable<Slot> {
    int M;
    int D;

    Slot(int M, int D) {
        this.M = M;
        this.D = D;
    }

    @Override
    public int compareTo(Slot o) {
        return o.D - this.D; //D ���� ������ ���� Ȯ��.
    }
}

class PriorityQueueEx {
    static int cnt;
    static int answer = 0;
    static int max = Integer.MIN_VALUE; //max ��� �� Integer.MIN_VALUE

    public int solution(ArrayList<Slot> arr) {
//d�� ���� ¦���� priority queue�� �ְ�, �� �� ���� ū �� poll. pq���� ���� ū �͸� ������ �۾���, max Ƚ�� ��ŭ�� �ϸ� �ȴ�. (max ��¥ �̻� ���� �� ���)

        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());; //q�� ���� �� �߿� ���� ū ���� poll�ϵ���.
        for(int i=max;i>0;i--) { //EX.3,2,1
            for(int j=0;j<cnt;j++) {
                if(arr.get(j).D == i) { // ARRAYLIST�� Ư�� ������ D�� �� i�ΰ� �ִٸ�,
                    q.offer(arr.get(j).M);
                }
            }
            if(!q.isEmpty()) answer+= q.poll();
//            answer += q.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        ArrayList<Slot> arr = new ArrayList<>();
        PriorityQueueEx T = new PriorityQueueEx();
        Scanner sc = new Scanner(System.in);
        cnt = sc.nextInt();
        for(int i=0; i<cnt;i++) {
            int M = sc.nextInt();
            int D = sc.nextInt();
            arr.add(new Slot(M, D));
            if(D>max) {
                max = Math.max(D, max);
            }
        }

        Collections.sort(arr);

        System.out.println(T.solution(arr));
    }
}
