package Programmers.Level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
시행착오
1.IndexOutOfBounds 에러: EX. 배열의 크기가 5인데, 5번째 인덱스에 접근한 것 (4번째가 아니고)
2.failCount[i] = Collections.frequency(Arrays.asList(stages), i+1); // 카운팅 안되는 메서드 - Object 라서 숫자는 인식을 못하는 것 같음.
3.실패율 0인 경우, 처리해주기.
4.문제 stages 개수가 200000임을 감안할 때, n 제곱 시간복잡도가 높다.
5.분모가 0인 경우 제거.
 */


public class FailureRate {

    //최종은 HashMap에 저장하기.

    public int[] solution(int N, int[] stages) {
        ArrayList<Integer> ansArr = new ArrayList<>();
        int[] answer; // 답이 들어갈 곳: 실패율 높은 순서대로 유저 정렬

        double[] failRate = new double[N];
        int[] failCount = new int[N];

        double temp = stages.length; //int 면 계산이 안된다. double 끼리 나눠야 계산이 되서 그런 것 같다.

        //자바 - 2차원 배열 없애기
        for(int i=0;i<N;i++) {
            for(int j=0;j<stages.length;j++) {
                if (stages[j] == i+1) {
                    failCount[i]++; //[3,0,0]
                }
            }
        }

        //temp 가 0일 경우 직접 0.0을 넣어줌.
        for(int i=0;i<N;i++){
          if(i==0) {
                failRate[i] = failCount[i]/temp;
            } else if (i>0&&i< stages.length) {
                temp = temp - failCount[i-1];
                if (temp!=0) {
                    failRate[i] = failCount[i]/temp;
                } else {
                    failRate[i] = 0.0;
                }
            }
        }

        //Value 순으로 정렬해줄 해시맵 생성
        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();

        for(int i=0;i<failRate.length;i++) {
            if(failCount[i] == 0) {
                hm.put(i+1, 0.0);
            }
            else {
                hm.put(i+1, failRate[i]);
            }
        }

        List<Map.Entry<Integer,Double>> entryList = new LinkedList<>(hm.entrySet());
        entryList.sort(Collections.reverseOrder(Map.Entry.comparingByValue())); //역순 정렬
        for(Map.Entry<Integer,Double> entry:entryList) {
            ansArr.add(entry.getKey());
            System.out.println("key: "+entry.getKey() +"value: " +entry.getValue());
        }

        answer = ansArr.stream().mapToInt(i->i.intValue()).toArray();

        return answer;
    }

}
