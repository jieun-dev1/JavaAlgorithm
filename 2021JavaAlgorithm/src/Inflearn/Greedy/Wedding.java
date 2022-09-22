package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
Comparable 을 구현할 때는 클래스로 제네릭 타입을 감싸줘야 한다.
제네릭을 왜 쓸까?
(1) 형변환의 번거로움을 줄이려고 - 원하지 않는 타입이 저장되는 것 등
(2) 객체의 타입을 컴파일 시 체크해서 타입 안정성이 높아진다.
(3) 타입 체크, 형변환이 해결되니 코드가 간결해진다.

Comparable
문자도 ascending order 로 지정된다. 시간이 같을 경우, 끝나는 시간이(end) 먼저 와야 한다. 그러니 끝나는 시간에는(end) 상대적으로 앞에 있는 알파벳 주기.
arrive, leave 로 했을 때는 arrive 가 앞에 leave 가 뒤에 정렬된다.
 */

class Visit implements Comparable<Visit> {
    int time;
    Character type;

    Visit(int time, Character type) {
        this.time = time;
        this.type = type;
    }

    @Override
    public int compareTo(Visit o) {
        if(this.time == o.time) {
            return this.type - o.type;
        }
        else {
            return this.time - o.time;
        }
    }
}

class Wedding {

    int count;
    int answer = 0;

    public int solution(ArrayList<Visit> arr) {
        //하나씩 arrayList를 돌면서, s면 +, e라면 -를 한다.
        for(Visit o:arr) {
            if (o.type == 's')
                count++;
            else count --;
            answer = Math.max(count, answer);
        }
        return answer;
    }
//for each문을 쓰면 n을 넘겨줄 필요가 없다. for문ㅇ로 돌리면 arr.get(i).type 이런 식으로 해야하는데, for each가 반복문도 훨씬 간단하다.

    public static void main(String[] args) {
        Wedding T = new Wedding();
        Scanner sc = new Scanner(System.in);
        int guest = sc.nextInt();
        ArrayList<Visit> arr = new ArrayList<>();
        for (int i = 0; i < guest; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Visit(x, 's')); //도착했음을 표시
            arr.add(new Visit(y, 'e')); //떠남을 표시
        }

            Collections.sort(arr);
            //정렬이 제대로 되었는지 확인
//            for (int i = 0; i < arr.size(); i++) {
//                System.out.println(arr.get(i).time + " " + arr.get(i).type);
//            }

            System.out.println(T.solution(arr));

        }
    }
