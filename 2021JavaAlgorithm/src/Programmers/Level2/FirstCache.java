package Programmers.Level2;

import java.util.ArrayList;

/**
 * ĳ���� ����� 5���, 5��ŭ�� ũ�⸦ ������. �Է��� �۾��� ĳ�ÿ� ���ٸ�:
 */
public class FirstCache {

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    ArrayList<String> cache = new ArrayList<>();
    for(int i=0;i<cities.length;i++) {
      cities[i] = cities[i].toUpperCase();
    }

    if (cacheSize == 0) {
      answer = 5 * cities.length;
      return answer;
    } else {
      for (int i = 0; i < cacheSize; i++) {
        cache.add(cities[i]); //cacheSize��ŭ List�� �ִ� �ʱ⼳��.
        answer += 5;
      }

      for (int i = cacheSize; i < cities.length; i++) {
        //ĳ�ÿ� ���� ��� �ǵ��� ���Ҹ� �����ϰ� �� ���� ���� �߰���.

        if (!cache.contains(cities[i])) {
          cache.remove(cacheSize - 1);
          cache.add(0, cities[i]);
          answer += 5;
        }
        //ĳ�ÿ� �ִµ� ������ ù ��°�� �ƴ� ���
        else if (cache.contains(cities[i]) && (cache.indexOf(cities[i]) != 0)) {
          cache.remove(cacheSize - 1);
          cache.add(0, cities[i]);
          answer += 1;
        }
        //ĳ�ÿ� �ִµ� ������ ù ��°�� ���
        else if (cache.contains(cities[i]) && (cache.indexOf(cities[i]) == 0)) {
          answer += 1;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    FirstCache cache = new FirstCache();
    cache.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"});
  }

}
