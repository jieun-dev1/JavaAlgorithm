package Programmers.Level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 중복이 주어지지 않기 때문에, Set으로 만들 필요가 없어 보인다.
 */
public class Outfit {

  public int solution(String[][] clothes) {
    HashMap<String, Set<String>> hm = new HashMap<>();
    int answer = 0;
    for(int i=0;i<clothes.length;i++){
      //키에 값이 이미 존재할 경우는, 이미 존재하는 Set에 넣어준다.
      if(hm.get(clothes[i][1])!=null) {
        hm.get(clothes[i][1]).add(clothes[i][0]);
      } else {
      //새로 만들어지는 key-value 쌍은 HashSet으로 초기화해준다.
        hm.put(clothes[i][1], new HashSet<>());
        hm.get(clothes[i][1]).add(clothes[i][0]);
      }
    }

    //HashMap의 키 갯수, 각 키에 든 원소의 갯수 (총 원소 갯수). 키 갯수 == size (키가 고유하기 때문)
    //key들을 Array로 만듦.
    Set<String> keys = hm.keySet();
    Object[] keyArray =  keys.toArray();

    //temp 배열의 길이는 곧 key의 개수이다.
    int temp[] = new int[keyArray.length];
    //한 가지만 걸치는 경우 키 (타입) 에 대한 값을 더 해주기.
    for(int i=0;i< keyArray.length;i++) {
      temp[i] = hm.get(keyArray[i].toString()).size();
    }

    int temp2 = 1;
    if(keyArray.length>1) {
      for(int i=0;i<keyArray.length;i++) {
        answer+=temp[i];
        temp2= temp2*temp[i];
      }
      answer+=temp2;
    } else {
      for(int i=0;i<keyArray.length;i++) {
        answer+=temp[i];
      }
    }

    return answer;

  }

  public static void main(String[] args) {
    Outfit T = new Outfit();
    System.out.println(T.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
  }
}
