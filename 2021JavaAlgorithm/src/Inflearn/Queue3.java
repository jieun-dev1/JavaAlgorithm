package Inflearn;

import java.util.*;

class Person {
    int id;
    int priority;

    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}
public class Queue3 {

    public int solution(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> q = new LinkedList();
        for(int i=0;i<n;i++){
            q.offer(new Person(i,arr[i]));
            }

        //��� ����. q�� ������� ���� ���ȿ���.
        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x:q){
                if (tmp.priority < x.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break; //�ϳ��� ������ ���� for�� ���� �ʿ� ���� ������.
                }
            }

            //�Ʒ� tmp!=null �Ⱥ��̸� nullPointerException �� ��.
            //tmp �� null �� �ȴٴ� ��, queue ���� ���������� �ڷ� ���ٴ� ��. ���� answer�� �� ���� ����.
            //answer�� �������� ���� tmp !=null�� ����.

            if(tmp!=null){
                answer ++;

                if (tmp.id == m ){
                    return answer;
                }
            }

//            if(tmp!=null) {
//                answer ++;
//                if (tmp.id == m) {
//                    return answer;
//                }
//            }

            }

        return answer;

        }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue3 T = new Queue3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(n,m,arr));

    }
}
