package Programmers.Level2;

import java.util.ArrayList;

/**
 * 캐시의 사이즈가 5라면, 5만큼의 크기를 저장함. 입력할 작업이 캐시에 없다면:
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
        cache.add(cities[i]); //cacheSize만큼 List에 넣는 초기설정.
        answer += 5;
      }

      for (int i = cacheSize; i < cities.length; i++) {
        //캐시에 없을 경우 맨뒤의 원소를 제거하고 맨 앞의 원소 추가함.

        if (!cache.contains(cities[i])) {
          cache.remove(cacheSize - 1);
          cache.add(0, cities[i]);
          answer += 5;
        }
        //캐시에 있는데 순서가 첫 번째가 아닐 경우
        else if (cache.contains(cities[i]) && (cache.indexOf(cities[i]) != 0)) {
          cache.remove(cacheSize - 1);
          cache.add(0, cities[i]);
          answer += 1;
        }
        //캐시에 있는데 순서가 첫 번째일 경우
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
