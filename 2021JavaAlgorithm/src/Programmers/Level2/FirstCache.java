package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ArrayList는 더할 떄 끝에 더해줌.
 * Queue의 Size 측정하는 이유: Queue가 cacheSize보다 짧다면 offer만 해도 되지만, cacheSize와 같으면 기존 원소 poll, offer() 과정.
 */
public class FirstCache {

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    Queue<String> queue = new LinkedList<>();
    for (int i = 0; i < cities.length; i++) {
      cities[i] = cities[i].toUpperCase();
    }

    if (cacheSize == 0) {
      answer = 5 * cities.length;
      return answer;
    }

    //초반에 Queue가 비어있고, Queue안에 현재 읽는 원소가 없을 때 5씩 넣음(cache miss)
    for (int i = 0; i < cities.length; i++) {
      if (!queue.contains(cities[i]) && queue.size() < cacheSize) {
        queue.offer(cities[i]);
        answer += 5;
      }

      else if (queue.contains(cities[i]) && queue.size() <= cacheSize) {
        answer += 1;
      }

      //캐시에 없을 경우 맨뒤의 원소를 제거하고 맨 앞의 원소 추가함.
      else if (!queue.contains(cities[i]) && queue.size() == cacheSize) {
        queue.poll();
        queue.offer(cities[i]);
        answer += 5;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    FirstCache cache = new FirstCache();
    System.out.println(cache.solution(2, new String[]{"a", "a", "a", "b", "b", "b", "c", "c", "c"}));
//    cache.solution(2, new String[]{"a", "a", "a", "b", "b", "b", "c", "c", "c"});

  }

}
