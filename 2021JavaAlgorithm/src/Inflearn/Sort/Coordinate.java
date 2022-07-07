package Inflearn.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

//인자가 없는 list 는 정렬 불가해서 컴파일 에러
class Unit {
    int x;
    int y;

    Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Coordinate {
    public int solution(HashMap map) {
//        Object[] mapKey = map.keySet().toArray();
//        Arrays.sort(mapKey);
//        Collections.sort(map, new Comparator<>)

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Coordinate T = new Coordinate();
        int cnt = sc.nextInt();
        Unit[] array = new Unit[0];
//        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<cnt;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            array[i] = new Unit(a,b);

//            map.put(a, b);
        }
        List<Unit> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(list);
    }
}
