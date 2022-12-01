package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
스테이지 개수 만큼 실패율 길이 배열.
 */
public class FailureRate {

  public int[] solution(int N, int[] stages) {
    int[] fail = new int[N];
    int[] pass = new int[N];
    int cnt = stages.length;
    pass[0] = cnt;
    HashMap<Integer, Double> failureMap = new HashMap<>();
    for (int x : stages) {
      if (x <= N) { //N의 범위를 넘으면 무시.
        fail[x - 1] += 1; //배열이므로 index -1.
      }
    }
    for (int i = 1; i < N; i++) { //1-4까지. stage 순회 필요 없이 실패율만 알면 됨.
      pass[i] = pass[i - 1] - fail[i - 1];
    }

    for (int i = 0; i < N; i++) {
      if (fail[i] == 0 || pass[i] == 0) {
        failureMap.put(i + 1, 0.0);
        //0이 아닌 경우 일때만 나눠주는 것이 핵심
      } else {
        double failRate = (double) fail[i] / (double) pass[i];
        failureMap.put(i + 1, failRate);
      }
    }

    List<Integer> keyList = new ArrayList<>(failureMap.keySet());
    Collections.sort(keyList, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return failureMap.get(o2).compareTo(failureMap.get(o1));
        //compare(double o1, double o2)와 동일한 메서드.
        //o2 Value와 o1 Value를 비교한 값을 return 해줌. o2 Value <o1 Value 이면 음수, o2 Value > o1 Value 이면 양수
      }
    });

    return keyList.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    FailureRate T = new FailureRate();
//    T.solution(5, new int[]{2,1,2,6,2,4,3,3});
    T.solution(3, new int[]{1, 1, 1});
//    System.out.println(T.solution(4, new int[]{4,4,4,4,4}));
  }
}
