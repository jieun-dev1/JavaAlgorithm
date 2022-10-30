package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ArrayList�� ���� �� ���� ������.
 * Queue�� Size �����ϴ� ����: Queue�� cacheSize���� ª�ٸ� offer�� �ص� ������, cacheSize�� ������ ���� ���� poll, offer() ����.
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

    //�ʹݿ� Queue�� ����ְ�, Queue�ȿ� ���� �д� ���Ұ� ���� �� 5�� ����(cache miss)
    for (int i = 0; i < cities.length; i++) {
      if (!queue.contains(cities[i]) && queue.size() < cacheSize) {
        queue.offer(cities[i]);
        answer += 5;
      }

      else if (queue.contains(cities[i]) && queue.size() <= cacheSize) {
        answer += 1;
      }

      //ĳ�ÿ� ���� ��� �ǵ��� ���Ҹ� �����ϰ� �� ���� ���� �߰���.
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
