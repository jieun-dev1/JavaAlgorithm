package Programmers.Level2;

import java.util.LinkedList;

/**
 * ArrayList는 더할 떄 끝에 더해줌. Queue의 Size 측정하는 이유: Queue가 cacheSize보다 짧다면 offer만 해도 되지만, cacheSize와 같으면
 * 기존 원소 poll, offer() 과정. 삽입된 데이터를 사용하면, HEAD 로 옮겨서 우선순위를 높이게 되고 삭제될 우선순위에서 멀어짐. Queue가 아닌
 * LinkedList로 구현해야, indexOf를 할 수 있음. 처음에 부모를 Queue로 선언했는데, 이렇게 하면 사용 가능한 메서드가 제한됨.
 *
 */
public class FirstCache {

  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    LinkedList<String> queue = new LinkedList<>();
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
        int temp = queue.indexOf(cities[i]);
        queue.remove(temp);
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
