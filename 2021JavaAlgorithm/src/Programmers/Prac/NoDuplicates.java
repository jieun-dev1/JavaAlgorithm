package Programmers.Prac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.print.attribute.IntegerSyntax;

//�� ������ Queue �� �ƴ϶� ArrayList�� Ǫ�� ����.
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

        answer = new int[list.size()]; //ArrayIndexOutOfBounds ������ ���� ����. answer �迭�� �����������, ũ�⸦ �������� �ʾƼ�.

        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}
