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
    int[] answer = {};
    int userCnt = stages.length;
    int participant = N;

    int[] fail = new int[N+1]; //1-N번째 스테이지 까지 (INDEX 0-(N-1)) 실패자 수를 담은 배열.
    for(int i=0;i<userCnt;i++){
      int temp = stages[i];
      if(temp==N+1){
        continue;
      } else {
        fail[temp-1]+=1;
      }
    }

    //1번째 stage 부터 N+1 번째 Stage까지 순환. (index니 -1 함)
    //score[0][0] = 1번째 스테이지의 실패자. score[0][1] 은 1번째 스테이지에 총 참가자
    //PARTICIPANT 는 8부터 시작해서, n-1번째 스테이지의 실패자를 가감해주는 식으로 갱신한다.
    //score[i][1] 실패율 순으로 Map에 넣어서. value가 가장 높은 수 대로 sort 한다.


    double[] score = new double[N];
    int currentUser = userCnt;

    for(int i=0;i<N;i++) {
      //1단계라면, N에 별도 처리 X.
      if (i == 0) {
        score[i] = (double) fail[i] / currentUser;
        continue;

      } else {
        currentUser -= fail[i - 1]; //i가 1일 때는, n에서 I가 0일때 실패자 수를 뺴줌.
        score[i] = (double) fail[i] / currentUser;
      }
    }

    //실패율 별 정렬.

    HashMap<Integer, Double> hm = new HashMap<>();
    for(int j=0;j<score.length;j++){
      hm.put(j+1, score[j]);
    }
    List<Integer> keys = new ArrayList<>(hm.keySet()); //[1,2,3,4,5]
    //VALUE 순으로 내림차순 정리. 실패율이 같다면, KEY는 오름차 순.
//    Collections.sort(keys, (v1, v2) -> (hm.get(v2).compareTo(hm.get(v1)))); //내림차 순.
    //키 리스트를 정렬하되, 값을 비교해가면서 정렬함.
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
