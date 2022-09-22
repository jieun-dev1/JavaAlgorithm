package Programmers.Level1;

import java.util.*;

/*
player 1,2,3을 int 로 주지 말고 풀어보자.
 */
public class Exam {
    public int[] solution(int[] answers) {
        int[] arrOne  = {1,2,3,4,5};
        int[] arrTwo = {2,1,2,3,2,4,2,5};
        int[] arrThree = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        //주어진 문제의 답을 비교하기.
        for(int i=0;i<answers.length;i++){
            if(answers[i]==arrOne[i%5]) {
                score[0]++;
            }
            if (answers[i]==arrTwo[i%8]) {
                score[1]++;
            }
            if (answers[i]==arrThree[i%10]) {
                score[2]++;
            }
        }

        //가장 많이 맞춘 수

        int max = Math.max(score[0],  Math.max(score[1],score[2])); //score 0,1,2 중에 max 와 같은 값이 있다면, + 해주기.
        ArrayList<Integer> list = new ArrayList<>();
        if(max == score[0]) {
            list.add(1);
        }
        if(max == score[1]) {
            list.add(2);
        }
        if(max == score[2]) {
            list.add(3);
        }
        //list.stream().toArray(); 이렇게만 하면 Object[] 형이다.
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
