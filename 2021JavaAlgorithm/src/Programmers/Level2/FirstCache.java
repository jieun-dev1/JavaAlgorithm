package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ArrayList는 더할 떄 끝에 더해줌. Queue의 Size 측정하는 이유: Queue가 cacheSize보다 짧다면 offer만 해도 되지만, cacheSize와 같으면
 * 기존 원소 poll, offer() 과정. 삽입된 데이터를 사용하면, HEAD 로 옮겨서 우선순위를 높이게 되고 삭제될 우선순위에서 멀어짐. Queue가 아닌
 * Queue는 Collection 을 상속 받음. Queue에 정의 되어 있지 않아도 Collection 의 메서드 사용 가능함.
 *
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
      //cache hit
      else if (queue.contains(cities[i]) && queue.peek() != cities[i]
          && queue.size() <= cacheSize) {
        queue.remove(cities[i]);
        queue.offer(cities[i]);
        answer += 1;
      }
      //cache miss  - 캐시에 없을 경우 맨뒤의 원소를 제거하고 맨 앞의 원소 추가함.
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
    System.out.println(
        cache.solution(2, new String[]{"a", "a", "a", "b", "b", "b", "c", "c", "c"}));

  }

}
