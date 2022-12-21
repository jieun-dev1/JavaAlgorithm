package Programmers.Level2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 소요: 1시간 반. Comparator 문제
 */

public class Tangerline {
  public int solution(int k, int[] tangerine) {
    int answer = 0;
    //해시맵 생성
    HashMap<Integer, Integer> hm = new HashMap<>();
    for(int i=0;i< tangerine.length;i++){
      hm.put(tangerine[i], hm.getOrDefault(tangerine[i], 0)+1);
    }

    // ArrayList<Integer> values = (ArrayList<Integer>) hm.values(); 잘못된 예시
    ArrayList<Integer> valueList = new ArrayList<>(hm.values()); //O
    Collections.sort(valueList, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
      }
    });

    //내림차 순 정렬 테스트
    print(valueList);
    int base = 0;
    for(int i=0;i<valueList.size();i++){
      if(base+valueList.get(i)>=k){
        answer++;
        return answer;
      }
      base += valueList.get(i);
      answer++; //answer를 먼저 ++ 하고, return 해야 함.
    }
      return answer;
  }

  public void print(ArrayList<Integer> values){
    for(int i=0;i<values.size();i++){
      System.out.println(values.get(i));
    }
  }

  public static void main(String[] args) {
    Tangerline T = new Tangerline();
    System.out.println(T.solution(6, new int[]{1,3,2,5,4,5,2,3}));
  }
}
