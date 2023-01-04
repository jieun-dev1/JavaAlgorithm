package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Comparable �� �� ���� ���׸��� �ȿ� �־���� ��.
 *
 * 1. �ð��� ������ ������ �����մϴ�. (TIme Ŭ���� �����, ���� �����մϴ�)
 * 2. type�� ���ĺ������� e�� s ���� ���� �ɴϴ� (���� Ȯ��)
 *
 * �����Ʈ
 * start:5 / end:30�̶��. start - end ���� ���ʷ� ��ȸ�ϵ��� �ߴµ�, �̷��� �ϸ� get(i)�� �ϸ� �ȵȴ�.
 * start - end �� 25�ε�, list�� ������� 10���̱� �����̴�.
 *
 * ����
 * sc.next()�� String�̹Ƿ�, char�� ���ϰ� �ʹٸ� charAt(0)���� ù���� ������.
 * int -> Integer�� AutoBoxing�� �̷����.
 *
 */
class Time implements Comparable<Time> {

  int num;
  char type;

  public Time(int num, char type) {
    this.num = num;
    this.type = type;
  }

  //num�� ���� ��Ȳ���� type�� ���ĺ� ������������ ����
  @Override
  public int compareTo(Time o) {
    if(this.num == o.num) return this.type - o.type;
    else return this.num - o.num;
  }
}

class WeddingV2 {
  public int solution(ArrayList<Time> list, int n){
    int count = 0;
    int listSize = list.size();
    Collections.sort(list);
    int answer = Integer.MIN_VALUE;
    //�� �������� ��ġ�� ��� ���� ����ϴ� Arr. ���� sort�Ͽ� �ִ� ���� ã�´�.
    for(int i=0;i<listSize;i++){
      //���� �������� s�� ���� ���ϸ� ������ �� �� ���� (e�� �ִٸ� ������ �� ������)
      if(list.get(i).type=='e'){
        count--;
        answer = Math.max(answer, count);
        continue;
      }

      if(list.get(i).type=='s'){
        count++;
        answer = Math.max(answer, count);
        continue;
      }

    }
    return answer;
  }

  public static void main(String[] args) {
    WeddingV2 T = new WeddingV2();
    Scanner sc = new Scanner(System.in);
    ArrayList<Time> list = new ArrayList<>();
    int n = sc.nextInt();
    for(int i=0;i<n;i++){
      list.add(new Time(sc.nextInt(), 's'));
      list.add(new Time(sc.nextInt(), 'e'));
    }
    System.out.println(T.solution(list, n));
  }
}
