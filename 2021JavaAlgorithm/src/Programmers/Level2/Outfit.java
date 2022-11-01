package Programmers.Level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * �ߺ��� �־����� �ʱ� ������, Set���� ���� �ʿ䰡 ���� ���δ�.
 */
public class Outfit {

  public int solution(String[][] clothes) {
    HashMap<String, Set<String>> hm = new HashMap<>();
    int answer = 0;
    for(int i=0;i<clothes.length;i++){
      //Ű�� ���� �̹� ������ ����, �̹� �����ϴ� Set�� �־��ش�.
      if(hm.get(clothes[i][1])!=null) {
        hm.get(clothes[i][1]).add(clothes[i][0]);
      } else {
      //���� ��������� key-value ���� HashSet���� �ʱ�ȭ���ش�.
        hm.put(clothes[i][1], new HashSet<>());
        hm.get(clothes[i][1]).add(clothes[i][0]);
      }
    }

    //HashMap�� Ű ����, �� Ű�� �� ������ ���� (�� ���� ����). Ű ���� == size (Ű�� �����ϱ� ����)
    //key���� Array�� ����.
    Set<String> keys = hm.keySet();
    Object[] keyArray =  keys.toArray();

    //temp �迭�� ���̴� �� key�� �����̴�.
    int temp[] = new int[keyArray.length];
    //�� ������ ��ġ�� ��� Ű (Ÿ��) �� ���� ���� �� ���ֱ�.
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
