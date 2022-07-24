package Programmers.Prac;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Exam {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> answerArray = new ArrayList<>();
        int[] arrOne  = {1,2,3,4,5};
        int[] arrTwo = {2,1,2,3,2,4,2,5};
        int[] arrThree = {3,3,1,1,2,2,4,4,5,5};

        //수포자별 맞춘 문제 개수 초기화
        int player1 = 0;
        int player2 = 0;
        int player3 = 0;

        //주어진 문제의 답을 비교하기.
        for(int i=0;i<answers.length;i++){
            if(answers[i]==arrOne[i%5]) {
                player1++;
            }
            if (answers[i]==arrTwo[i%8]) {
                player2++;
            }
            if (answers[i]==arrThree[i%10]) {
                player3++;
            }
        }

        //list에 각 수포자들의 맞춘 갯수 넣기.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);

        //가장 많이 맞춘 개수가 앞으로 오게 역순 정렬
//        Collections.reverse(list);
        Collections.sort(list, Collections.reverseOrder());
        //가장 큰 수가 = 수포자 1,2,3 중에 있다면, answerArray 최종에 더하기.
        if(list.get(0) == player1) answerArray.add(1);
        if(list.get(0) == player2) answerArray.add(2);
        if(list.get(0) == player3) answerArray.add(3);

        //배열로 반환하기.
        answer = new int[answerArray.size()];

        for(int i=0;i<answerArray.size();i++) {
            answer[i] = answerArray.get(i);
        }

        return answer;
    }
}
