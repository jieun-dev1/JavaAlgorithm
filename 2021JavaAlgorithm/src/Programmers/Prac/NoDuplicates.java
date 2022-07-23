package Programmers.Prac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.print.attribute.IntegerSyntax;

//이 문제는 Queue 가 아니라 ArrayList로 푸는 문제.
public class NoDuplicates {
    public int[] solution(int []arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++) {
            if(i==0) {
                list.add(arr[0]);
            } else {
                if(arr[i] == list.get(list.size()-1)) {
                    continue;
                }
                else {
                    list.add(arr[i]);
                }
            }
        }

        answer = new int[list.size()]; //ArrayIndexOutOfBounds 에러가 났던 이유. answer 배열을 만들어줬지만, 크기를 정해주지 않아서.

        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}
