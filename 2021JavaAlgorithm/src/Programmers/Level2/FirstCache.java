package Programmers.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
ArrayList는 더할 떄 끝에 더해줌.
 */
public class FirstCache {

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    Queue<String> queue = new LinkedList<>();
    for(int i=0;i<cities.length;i++) {
      cities[i] = cities[i].toUpperCase();
    }

    if (cacheSize == 0) {
      answer = 5 * cities.length;
      return answer;
    } else {
      for (int i = 0; i < cacheSize; i++) {
        queue.offer(cities[i]); //cacheSize만큼 List에 넣는 초기설정.
        answer += 5;
      }

      for (int i = cacheSize; i < cities.length; i++) {
        //캐시에 없을 경우 맨뒤의 원소를 제거하고 맨 앞의 원소 추가함.

        if (!queue.contains(cities[i])) {
          queue.poll();
          queue.offer(cities[i]);
          answer += 5;
        }
        //캐시에 있는데 순서가 첫 번째가 아닐 경우 위와 같이 poll() 후 offer()를 하지만, answer는 hit이므로 1추가.
        else if (queue.contains(cities[i]) && (queue.peek() != cities[i])) {
          queue.poll();
          queue.offer(cities[i]);
          answer += 1;
        }

        //캐시에 있는데 순서가 첫 번째일 경우
        else if (queue.contains(cities[i]) && (queue.peek() == cities[i])) {
          answer += 1; //아무것도 할 게 없음.
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
