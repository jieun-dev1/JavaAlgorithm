package Programmers.Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

//https://school.programmers.co.kr/learn/courses/30/lessons/77484

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {

        //배열을 ArrayList로 변환
        ArrayList<Integer> lottosList = (ArrayList<Integer>) Arrays.stream(lottos).boxed()
                .collect(Collectors.toList());
        ArrayList<Integer> winList = (ArrayList<Integer>) Arrays.stream(win_nums).boxed()
                .collect(Collectors.toList());

        //lottos 배열에서 0의 갯수를 센다. // 최댓값이 될 수 있는 여지
        int zeroCount = Collections.frequency(lottosList, 0);

        //두 배열의 교집합을 구한다. // 최소 갯수
        lottosList.retainAll(winList);

        int min = lottosList.size();
        int max = min + zeroCount;

        //최소로 맞는 갯수, 최대로 맞는 개수를 순서대로 넣어준다.
        int[] result = new int[2];
        result[0] = min;
        result[1] = max;

        //2개 맞음 - 6개 다 맞음 까지는 7개 - 맞은 번호 갯수이다. 0 혹은 1개는 6위다.
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

