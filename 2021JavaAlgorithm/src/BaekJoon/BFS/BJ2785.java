package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * ���� : https://dheldh77.tistory.com/entry/%EB%B0%B1%EC%A4%80-2785%EB%B2%88-%EC%B2%B4%EC%9D%B8 https://velog.io/@ehdcks3421/%EB%B0%B1%EC%A4%80-%EC%B2%B4%EC%9D%B8-2785
 */
public class BJ2785 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0;i<n;i++){
      list.add(Integer.parseInt(st.nextToken()));
    }
    int answer = 0;
    //ü���� ���� ������ �����Ѵ�.
    Collections.sort(list);
    //�� ó�� ü�κ��� Ǯ� �ϳ��� ���ش�.

    //�� ó�� ���� �ϳ��� ������ ��, break�� �� ���� (�ϳ��� �������ٴ� ��)
    while(true) {
      int size = list.size();
//      if(size==1){
        if(size<=1){
        break;
      }
      list.set(0, list.get(0)-1); //ü���� �ϳ��� ����.
      list.remove(size-1); //�� ���� ���ڸ� ����� (ü���� �����ؼ� �ϳ��� �������ٴ� ��)
      if(list.get(0)==0){
        list.remove(0);
      }
      answer++;
    }
    System.out.println(answer);
  }
  }
