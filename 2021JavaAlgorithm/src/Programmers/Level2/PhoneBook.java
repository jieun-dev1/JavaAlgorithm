package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {
  public boolean solution(String[] phone_book) {
    if(phone_book.length==1){
      return false;
    }
    boolean answer = true;
    HashMap<String, Integer> hm = new HashMap<>(); // 접두어로 시작하는 key를 가질 때, value에 추가해준다.
    List<String> list = new ArrayList<>(Arrays.asList(phone_book));
    Collections.sort(list);
    //put의 시간 복잡도 o(1) 최악 o(n)
    for(int i=0;i< list.size()-1;i++){
      String temp = list.get(i);
      if(hm.isEmpty()){
        hm.put(temp, 1);
      }
      //뒤의 것을 미리 확인하면, 순회하는 횟수가 준다.
      if(list.get(i+1).startsWith(list.get(i))){
        answer = false;
        return answer;
      }
    }

    //value가 1이 아닌 경우가 있다면, 접두어가 있는것.
    return answer;
  }

  public static void main(String[] args) {
    PhoneBook T = new PhoneBook();
    System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
    System.out.println(T.solution(new String[]{"123", "3123"}));
  }
}
