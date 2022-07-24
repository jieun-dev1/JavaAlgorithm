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

        //�����ں� ���� ���� ���� �ʱ�ȭ
        int player1 = 0;
        int player2 = 0;
        int player3 = 0;

        //�־��� ������ ���� ���ϱ�.
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

        //list�� �� �����ڵ��� ���� ���� �ֱ�.
        ArrayList<Integer> list = new ArrayList<>();
        list.add(player1);
        list.add(player2);
        list.add(player3);

        //���� ���� ���� ������ ������ ���� ���� ����
//        Collections.reverse(list);
        Collections.sort(list, Collections.reverseOrder());
        //���� ū ���� = ������ 1,2,3 �߿� �ִٸ�, answerArray ������ ���ϱ�.
        if(list.get(0) == player1) answerArray.add(1);
        if(list.get(0) == player2) answerArray.add(2);
        if(list.get(0) == player3) answerArray.add(3);

        //�迭�� ��ȯ�ϱ�.
        answer = new int[answerArray.size()];

        for(int i=0;i<answerArray.size();i++) {
            answer[i] = answerArray.get(i);
        }

        return answer;
    }
}
