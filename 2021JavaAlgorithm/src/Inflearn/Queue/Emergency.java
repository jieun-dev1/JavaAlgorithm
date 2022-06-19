package Inflearn.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//한 코드 내에 여러 클래스를 생성해도 된다.
//Person 객체와 로직을 수행할 별도 메인 객체가 필요한 상황.
//Person을 public 으로 만들면, Person.java 를 별도로 생성해야 한다.

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class Emergency {
    static int answer;
    public void solution(int num, int target, int[] list) {
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<num;i++){
            q.offer(new Person(i, list[i]));
        }

        while(!q.isEmpty()) {
            Person tmp = q.poll();
            for(Person x: q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp); //빼서 넣어져야 함. 그래서 poll()
                    tmp = null;
                    break; //원소를 모두 도는 것이 아니라, 하나라도 있으면, offer 하는 것임.
//                    answerList.add(x);
                }
//                else if (x.priority < tmp.priority) {
//                    q.offer(x);
//                }
            }

            if(tmp!=null) {
                answer++;
                if(tmp.id == target) {
                    return answer;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int target = sc.nextInt();
        //크기만큼 배열을 만들어준다.
        int[] list = new int[num];
        for(int i=0; i<num;i++){
            list[i] = sc.nextInt();
        }
        Emergency T = new Emergency();
        System.out.println(T.solution(num, target, list));
    }
}
