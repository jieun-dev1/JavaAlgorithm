package Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SumOfTwo {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length-1;i++) {
            for(int j=i+1;j<numbers.length;j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }

    //Iterator 를 이용해서 값을 꺼내준다.
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            int temp = (int)iterator.next();
            arr.add(temp);
        }
        answer = arr.stream().mapToInt(i->i.intValue()).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
