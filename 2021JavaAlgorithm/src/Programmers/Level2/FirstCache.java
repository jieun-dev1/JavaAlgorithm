package Programmers.Level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
ArrayList�� ���� �� ���� ������.
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
        queue.offer(cities[i]); //cacheSize��ŭ List�� �ִ� �ʱ⼳��.
        answer += 5;
      }

      for (int i = cacheSize; i < cities.length; i++) {
        //ĳ�ÿ� ���� ��� �ǵ��� ���Ҹ� �����ϰ� �� ���� ���� �߰���.

        if (!queue.contains(cities[i])) {
          queue.poll();
          queue.offer(cities[i]);
          answer += 5;
        }
        //ĳ�ÿ� �ִµ� ������ ù ��°�� �ƴ� ��� ���� ���� poll() �� offer()�� ������, answer�� hit�̹Ƿ� 1�߰�.
        else if (queue.contains(cities[i]) && (queue.peek() != cities[i])) {
          queue.poll();
          queue.offer(cities[i]);
          answer += 1;
        }

        //ĳ�ÿ� �ִµ� ������ ù ��°�� ���
        else if (queue.contains(cities[i]) && (queue.peek() == cities[i])) {
          answer += 1; //�ƹ��͵� �� �� ����.
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
