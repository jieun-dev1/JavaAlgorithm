package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/*
�������� ���� ��ŭ ������ ���� �迭.
 */
public class FailureRate {

  public int[] solution(int N, int[] stages) {
    int[] fail = new int[N];
    int[] pass = new int[N];
    int cnt = stages.length;
    pass[0] = cnt;
    HashMap<Integer, Double> failureMap = new HashMap<>();
    for (int x : stages) {
      if (x <= N) { //N�� ������ ������ ����.
        fail[x - 1] += 1; //�迭�̹Ƿ� index -1.
      }
    }
    for (int i = 1; i < N; i++) { //1-4����. stage ��ȸ �ʿ� ���� �������� �˸� ��.
      pass[i] = pass[i - 1] - fail[i - 1];
    }

    for (int i = 0; i < N; i++) {
      if (fail[i] == 0 || pass[i] == 0) {
        failureMap.put(i + 1, 0.0);
        //0�� �ƴ� ��� �϶��� �����ִ� ���� �ٽ�
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
        //compare(double o1, double o2)�� ������ �޼���.
        //o2 Value�� o1 Value�� ���� ���� return ����. o2 Value <o1 Value �̸� ����, o2 Value > o1 Value �̸� ���
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
