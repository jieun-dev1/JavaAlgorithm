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

        //계속 돈다. q가 비어있지 않은 동안에는.
        while(!q.isEmpty()){
            Person tmp = q.poll();
            for(Person x:q){
                if (tmp.priority < x.priority) {
                    q.offer(tmp);
                    tmp = null;
                    break; //하나라도 있으면 굳이 for문 끝낼 필요 없기 때문에.
                }
            }

            //아래 tmp!=null 안붙이면 nullPointerException 이 남.
            //tmp 가 null 이 된다는 건, queue 에서 빠져나가서 뒤로 들어간다는 것. 따라서 answer이 될 수가 없다.
            //answer이 더해지는 경우는 tmp !=null일 때만.

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
