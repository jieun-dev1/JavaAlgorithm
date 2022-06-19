package Inflearn.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//한 코드 내에 여러 클래스를 생성해도 된다.
//Person 객체와 로직을 수행할 별도 메인 객체가 필요한 상황.
//Person을 public 으로 만들면, Person.java 를 별도로 생성해야 한다.
//시도: arrayList를 만들고 .add()로 더한 다음, 나중에 indexOf로 처리하고자 했음. 하지만 이럴 경우, 문제에서 주어진 값을 끝낸 후 exit 하는 것보다 효율적이진 않다.
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
            Person tmp = q.poll(); //첫 원소를 poll()하고, tmp라는 변수에 대입.
            for(Person x: q) {
                if (x.priority > tmp.priority) {
                    q.offer(tmp); //가장 중요도가 큰 원소가 아니라면, 빼서 맨 뒤로 넣어져야 함. 그래서 poll()된 tmp 가 q.offer 됨.
                    tmp = null;
                    break; //원소를 모두 도는 것이 아니라, 하나라도 있으면, offer 하는 것임.
                }
            }

            //tmp가 null이라는 것은 첫번째 원소 값(poll()한 것이 다시 맨 뒤로 offer()되었다는 뜻.
            //tmp!=null 이라면, 가장 큰 값이라는 뜻. 그럴 경우 answer ++ 해줌.
            //q가 차있는 동안 반복되기 때문에, q 가 차있는 동안 계속 위의 for 문이 돌게 됨.

            if(tmp!=null) {
                answer++;
                if(tmp.id == target) {
                    return answer;
                }
            }
        }
        return answer; //얘는 컴파일 에러 방지 위함. 위의 if(tmp.id==target)에서 어차피 걸릴 것.
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
        Main T = new Main();
        System.out.println(T.solution(num, target, list));
    }
}
