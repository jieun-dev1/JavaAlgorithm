package Programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PhoneBook {
  public boolean solution(String[] phone_book) {
    boolean answer = true;
//    HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
    List<String> list = new ArrayList<>(Arrays.asList(phone_book));
    //O(
    Collections.sort(list);
    for(int i=0;i<list.size()-1;i++){
      String temp = list.get(i); //���ĵǾ� �����Ƿ�, ���� ���Ұ� �� �� ���̴�. ���� ���� ���ҿ͸� ���ϸ� �ȴ�.
      for(int j=i+1;j<list.size();j++){
        if(list.get(j).startsWith(temp)) {
          answer = false;
          return answer;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    PhoneBook T = new PhoneBook();
    System.out.println(T.solution(new String[]{"119", "97674223", "1195524421"}));
  }
}
