package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;

/*
Arrays.sort�� �⺻������ ���� ������ �����ȴ�.
Ǯ�� ������� �� ��.

Ư�� n ��° �ε����� ������ �����ͼ� �����ϱ�.
Collections.sort = Natural Ordering (alphabet ��,

 */
public class StringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0;i<strings.length;i++) {
            arr.add(strings[i].charAt(n)+strings[i]);
        }

        Collections.sort(arr);
        //�߰��� ���� �ε��� ���� �����ϱ�.
        answer = new String[arr.size()];

        for(int i=0;i<arr.size();i++) {
            answer[i] = arr.get(i).substring(1);
        }

        return answer;
    }
}

