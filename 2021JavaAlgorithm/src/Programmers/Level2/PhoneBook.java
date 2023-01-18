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
    HashMap<String, Integer> hm = new HashMap<>(); // ���ξ�� �����ϴ� key�� ���� ��, value�� �߰����ش�.
    List<String> list = new ArrayList<>(Arrays.asList(phone_book));
    Collections.sort(list);
    //put�� �ð� ���⵵ o(1) �־� o(n)
    for(int i=0;i< list.size()-1;i++){
      String temp = list.get(i);
      if(hm.isEmpty()){
        hm.put(temp, 1);
      }
      //���� ���� �̸� Ȯ���ϸ�, ��ȸ�ϴ� Ƚ���� �ش�.
      if(list.get(i+1).startsWith(list.get(i))){
        answer = false;
        return answer;
      }
    }

    //value�� 1�� �ƴ� ��찡 �ִٸ�, ���ξ �ִ°�.
    return answer;
  }

  public static void main(String[] args) {
    PhoneBook T = new PhoneBook();
    System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
    System.out.println(T.solution(new String[]{"123", "3123"}));
  }
}
