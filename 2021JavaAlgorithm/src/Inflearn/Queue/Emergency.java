package Inflearn.Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�� �ڵ� ���� ���� Ŭ������ �����ص� �ȴ�.
//Person ��ü�� ������ ������ ���� ���� ��ü�� �ʿ��� ��Ȳ.
//Person�� public ���� �����, Person.java �� ������ �����ؾ� �Ѵ�.

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
                    q.offer(tmp); //���� �־����� ��. �׷��� poll()
                    tmp = null;
                    break; //���Ҹ� ��� ���� ���� �ƴ϶�, �ϳ��� ������, offer �ϴ� ����.
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
        //ũ�⸸ŭ �迭�� ������ش�.
        int[] list = new int[num];
        for(int i=0; i<num;i++){
            list[i] = sc.nextInt();
        }
        Emergency T = new Emergency();
        System.out.println(T.solution(num, target, list));
    }
}
