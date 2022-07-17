package Inflearn.Greedy;

import java.util.ArrayList;
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

1차 구현 오답
(1) 문제 잘못 이해함.
수입(M)순이 아니라 시간(d)순으로 정렬 필요.
시간: 3,2,1 순으로 역순 정렬.
시간 순으로 정렬하는 이유:
시간:
(2) 자료 구조를 만들 때,
정렬은 ArrayList에서
날짜 별로 PQ에 담고 가장 높은 점수를 POLL().
3일 날짜에 남은 원소가 있다면, 이를 다음 순서인 2일 날짜에 남은 원소에 더한다.
(3) queue에 넣고 빼기.

2차 구현
(4) 런타임 에러 이유: q가 empty일 수도 있기 때문에, empty가 아닌 경우 분기 필요.
   if ((result = (E) ((es = queue)[0])) != null) {
   구현체를 보면 null이 아닌, 적어도 원소가 하나 있는 것을 가정하고 있기 때문에. 여기서 empty가 아님을 조건에 넣어야 함.
   소요시간: 2시간.

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
        return o.D - this.D; //D 높은 순으로 정렬 확인.
    }
}

class PriorityQueueEx {
    static int cnt;
    static int answer = 0;
    static int max = Integer.MIN_VALUE; //max 계산 시 Integer.MIN_VALUE

    public int solution(ArrayList<Slot> arr) {
//d가 같은 짝끼리 priority queue에 넣고, 그 중 가장 큰 걸 poll. pq에서 가장 큰 것만 빼내는 작업은, max 횟수 만큼만 하면 된다. (max 날짜 이상 일할 수 없어서)

        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());; //q에 넣은 값 중에 가장 큰 값을 poll하도록.
        for(int i=max;i>0;i--) { //EX.3,2,1
            for(int j=0;j<cnt;j++) {
                if(arr.get(j).D == i) { // ARRAYLIST의 특정 원소의 D값 중 i인게 있다면,
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
