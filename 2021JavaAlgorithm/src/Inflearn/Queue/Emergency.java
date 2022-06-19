package Inflearn.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//�� �ڵ� ���� ���� Ŭ������ �����ص� �ȴ�.
//Person ��ü�� ������ ������ ���� ���� ��ü�� �ʿ��� ��Ȳ.
//Person�� public ���� �����, Person.java �� ������ �����ؾ� �Ѵ�.
//�õ�: arrayList�� ����� .add()�� ���� ����, ���߿� indexOf�� ó���ϰ��� ����. ������ �̷� ���, �������� �־��� ���� ���� �� exit �ϴ� �ͺ��� ȿ�������� �ʴ�.
class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

class Main {
    int answer = 0;
    public int solution(int num, int target, int[] list) {
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<num;i++){
            q.offer(new Person(i, list[i]));
        }

        while(!q.isEmpty()) {
            Person tmp = q.poll(); //ù ���Ҹ� poll()�ϰ�, tmp��� ������ ����.
            for(Person x: q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp); //���� �߿䵵�� ū ���Ұ� �ƴ϶��, ���� �� �ڷ� �־����� ��. �׷��� poll()�� tmp �� q.offer ��.
                    tmp = null;
                    break; //���Ҹ� ��� ���� ���� �ƴ϶�, �ϳ��� ������, offer �ϴ� ����.
                }
            }

            //tmp�� null�̶�� ���� ù��° ���� ��(poll()�� ���� �ٽ� �� �ڷ� offer()�Ǿ��ٴ� ��.
            //tmp!=null �̶��, ���� ū ���̶�� ��. �׷� ��� answer ++ ����.
            //q�� ���ִ� ���� �ݺ��Ǳ� ������, q �� ���ִ� ���� ��� ���� for ���� ���� ��.

            if(tmp!=null) {
                answer++;
                if(tmp.id == target) {
                    return answer;
                }
            }
        }
        return answer; //��� ������ ���� ���� ����. ���� if(tmp.id==target)���� ������ �ɸ� ��.
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
        Main T = new Main();
        System.out.println(T.solution(num, target, list));
    }
}
