package Programmers.Prac;

import java.util.ArrayList;
import java.util.List;

/*
 */
public class Flip {

    public int solution(int n) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        //리스트에 차례로 넣기: 3진법으로 바꾸기 전에 바로 넣기.
        while(n!=0) {
            arr.add(n%3);//나머지를 바로 list 에 넣고,
            n= n/3; //나눠진 몫으로 갱신.
        }

        //리스트의 숫자를 바로 10진법 변환
        for(int i=0;i<arr.size();i++) {
            if(arr.get(i)==0) continue;
            answer += Math.pow(3,arr.size()-i-1)*arr.get(i);
        }

        return answer;
    }
}
