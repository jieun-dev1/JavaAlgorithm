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
    int[] answer = {};
    int userCnt = stages.length;
    int participant = N;

    int[] fail = new int[N+1]; //1-N��° �������� ���� (INDEX 0-(N-1)) ������ ���� ���� �迭.
    for(int i=0;i<userCnt;i++){
      int temp = stages[i];
      if(temp==N+1){
        continue;
      } else {
        fail[temp-1]+=1;
      }
    }

    //1��° stage ���� N+1 ��° Stage���� ��ȯ. (index�� -1 ��)
    //score[0][0] = 1��° ���������� ������. score[0][1] �� 1��° ���������� �� ������
    //PARTICIPANT �� 8���� �����ؼ�, n-1��° ���������� �����ڸ� �������ִ� ������ �����Ѵ�.
    //score[i][1] ������ ������ Map�� �־. value�� ���� ���� �� ��� sort �Ѵ�.


    double[] score = new double[N];
    int currentUser = userCnt;

    for(int i=0;i<N;i++) {
      //1�ܰ���, N�� ���� ó�� X.
      if (i == 0) {
        score[i] = (double) fail[i] / currentUser;
        continue;

      } else {
        currentUser -= fail[i - 1]; //i�� 1�� ����, n���� I�� 0�϶� ������ ���� ����.
        score[i] = (double) fail[i] / currentUser;
      }
    }

    //������ �� ����.

    HashMap<Integer, Double> hm = new HashMap<>();
    for(int j=0;j<score.length;j++){
      hm.put(j+1, score[j]);
    }
    List<Integer> keys = new ArrayList<>(hm.keySet()); //[1,2,3,4,5]
    //VALUE ������ �������� ����. �������� ���ٸ�, KEY�� ������ ��.
//    Collections.sort(keys, (v1, v2) -> (hm.get(v2).compareTo(hm.get(v1)))); //������ ��.
    //Ű ����Ʈ�� �����ϵ�, ���� ���ذ��鼭 ������.
    Collections.sort(keys, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return hm.get(o2).compareTo(hm.get(o1));
      }
    });
    int[] arr = keys.stream().mapToInt(Integer::intValue).toArray();
    return arr;
  }


  public static void main(String[] args) {
    FailureRate T = new FailureRate();
    T.solution(5, new int[]{2,1,2,6,2,4,3,3});
  }

}
