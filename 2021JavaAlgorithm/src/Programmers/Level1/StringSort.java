package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;

/*
Arrays.sort는 기본적으로 사전 순으로 나열된다.
풀이 어려워서 답 봄.

특정 n 번째 인덱스를 앞으로 가져와서 정렬하기.
Collections.sort = Natural Ordering (alphabet 순,

 */
public class StringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<strings.length;i++) {
            arr.add(strings[i].charAt(n)+strings[i]);
        }

        Collections.sort(arr);
        //추가한 정렬 인덱스 빼서 리턴하기.
        answer = new String[arr.size()];

        for(int i=0;i<arr.size();i++) {
            answer[i] = arr.get(i).substring(1);
        }

        return answer;
    }
}

