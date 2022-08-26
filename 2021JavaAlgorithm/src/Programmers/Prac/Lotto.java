package Programmers.Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/77484

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {

        //�迭�� ArrayList�� ��ȯ
        ArrayList<Integer> lottosList = (ArrayList<Integer>) Arrays.stream(lottos).boxed()
                .collect(Collectors.toList());
        ArrayList<Integer> winList = (ArrayList<Integer>) Arrays.stream(win_nums).boxed()
                .collect(Collectors.toList());

        //lottos �迭���� 0�� ������ ����. // �ִ��� �� �� �ִ� ����
        int zeroCount = Collections.frequency(lottosList, 0);

        //�� �迭�� �������� ���Ѵ�. // �ּ� ����
        lottosList.retainAll(winList);

        int min = lottosList.size();
        int max = min + zeroCount;

        //�ּҷ� �´� ����, �ִ�� �´� ������ ������� �־��ش�.
        int[] result = new int[2];
        result[0] = min;
        result[1] = max;

        //2�� ���� - 6�� �� ���� ������ 7�� - ���� ��ȣ �����̴�. 0 Ȥ�� 1���� 6����.
        for (int i = 0; i < 2; i++) {
            if (result[i] >= 2) {
                result[i] = 7 - result[i];
            } else {
                result[i] = 6;
            }
        }
        return result;

    }


}

