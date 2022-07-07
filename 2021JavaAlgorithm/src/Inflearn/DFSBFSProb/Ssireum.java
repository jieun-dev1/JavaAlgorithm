package Inflearn.DFSBFSProb;

//x와 y모두 비교 시 음수라면, answer arraylist 에서 제외하기.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Greedy: 현재 시간에서 최선의 선택을 하는 것.
 * 키 순으로 정렬할 때 첫 번째 값은 무조건  answer ++;
 * 이후 값은, 적어도 몸무게가 max 값보다 크다면 (자신보다 키가 큰 원소의 몸무게 값) ++;
 *
 */
class Spec implements Comparable<Spec> {
    int x;
    int y;

    Spec(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //내림차순 정렬이 필요함.
    @Override
    public int compareTo(Spec o) {
            if(this.x == o.x)  return o.y-this.y;
            else return o.x - this.x;
        }
    }

class Ssireum {

    public int solution(ArrayList<Spec> arr) {
        int max = Integer.MIN_VALUE; //Min Value 에서 시작하면 첫번째 값은 무조건 ++ 다.
        int answer = 0;
        //정렬이 내림차 순으로 되어 있을 때 첫 번쨰 값은 무조건 위의 max 보다 크다.
        //if 문 쓸 때는 꼭 {} 블록을 주는 것 명심하자. 그렇지 않으면 if 여부와 상관없이 실행.
        for(Spec ob:arr) {
            if(ob.y>max) {
                max = ob.y;
                answer ++;
            }
            }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ssireum T = new Ssireum();
        int cnt = sc.nextInt();
        ArrayList<Spec> arr = new ArrayList<>();

        for(int i=0;i<cnt;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Spec(x,y));
        }

        Collections.sort(arr);
//        for(Spec o:arr) {
//            System.out.println(o.x+" "+o.y);
//        }
        System.out.println(T.solution(arr));

    }
}
