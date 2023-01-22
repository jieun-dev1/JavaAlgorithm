package BaekJoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 최악을 n몇으로 두어야 할까가 헷갈렸던 문제.
 */
public class Immigration {
  static int[] times;
  public long solution(int n, int[] times) {
    List<Integer> intList = Arrays.stream(times).boxed().collect(Collectors.toList());
    Collections.sort(intList);
    this.times = times;
    long left = 0;
    int maxT = times[times.length - 1];
    long right = maxT * n; //가장 큰 쪽에만 줄을 선다고 가정했을 때. 참가자 수 * 가장 긴 심사관의 심사시간
    long answer = 0;

    while (left<=right) {
      long mid = (left + right) / 2;
      if(cal(mid)>=n){
        answer = mid;
        right = mid-1;
      }
      else {
        left = mid+1;
      }
    }
    return answer;
  }

  public int cal(long mid){
    int coverage = 0;
    for (int i = 0; i < times.length; i++) {
      coverage += mid / times[i];
    }
    return coverage;
  }

  public static void main(String[] args) {
    Immigration T = new Immigration();
    System.out.println(T.solution(6, new int[]{7, 10}));
  }
}

