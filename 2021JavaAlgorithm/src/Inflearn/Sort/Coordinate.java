package Inflearn.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 다시 풀 것
 *
 * Comparable 인터페이스란?
 * 해당 인터페이스를 구현한 객체들은
 * Collection.sort 혹은 Arrays.sort 로 자동 정렬.
 *
 * (1) Comparable 을 구현하는 Unit 클래스 생성.
 * (2) 인자와 현재 this 값을 비교해서 정렬한다.
 * (3) ArrayList 에 담고 인쇄해준다.
 * Override한 메서드에서 정렬 기준을 잡아준다.
 */

class Unit implements Comparable<Unit>
        {
    int x;
    int y;

    Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Unit o) {
        if(this.x == o.x) return this.y-o.y; //리턴 값이 음수라면, this가 o 보다 앞에 온다. 양수라면, o가 this 보다 앞에 옴.
        else return this.x-o.x; // 같지 않다면, y까지 갈 필요 없이 x 끼리만 비교해주면 됨.
    }
}

class Coordinate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        ArrayList<Unit> arr = new ArrayList<>();

        for(int i=0;i<cnt;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Unit(a,b));
        }
        Collections.sort(arr); //sort 를 호출하면,, compareTo를 호출해서 비교함.
        for(Unit o:arr) {
            System.out.println(o.x+" "+o.y);
        }
    }
}
