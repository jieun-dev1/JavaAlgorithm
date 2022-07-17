package Inflearn.Greedy;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/*
PriorityQueue 란?
Queue의 구현체다. Queue: 부모 PriorityQueue: 자식
PriorityQueue는 힙이라는 자료 구조에 저장된다.
Queue는 fifo이지만, PriorityQueue는 저장한 순서에 관계 없이 우선순위가 높은 것부터 꺼낸다는 특징이 있다.
ex. 3,1,2,5.4 순으로 넣었지만, 출력해보면 1,2,3,4,5 다. 1부터 (숫자가 작을 수록 높은 것이라서) 꺼낸 것이다.

구현
1. Comparable implements 하고, compareTo를 M (수입) 높은 순으로 정렬한다.
2. D 는 저장할 필요가 없다. 그러니 결혼식 문제처럼 클래스를 만들어줄 필요 없음.
3. 가장 큰 d가 곧 max다.
4. M 을 저장하면, m이 낮은 순서대로 우선순위가 정렬 될 것이다. 높은 것부터 빼야 최대 수입이 나오니 reverse Order를 하자.
막힌 것: Collections.sort()로 정렬하고 싶은데, List 만 가능함. Queue는 어떻게 정렬하지?
Queue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
답: Queue를 만들 떄, 안에 Collection.reverseOrder()
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
