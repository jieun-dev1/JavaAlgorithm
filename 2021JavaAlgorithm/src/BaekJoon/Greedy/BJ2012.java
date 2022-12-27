package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 난이도: 실버 3
 */
public class BJ2012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long answer = 0;
    int n = Integer.parseInt(st.nextToken());//학생 수
    int[] arr = new int[n]; //arr열은 주어진 숫자를 순서대로 받은 뒤에, 이를 오름차순으로 정렬.
    int[] rank = new int[n]; //arr와 동일한 크기의 배열을 1-n 크기로 정렬. .
    long[] complaint = new long[n]; //불만도 배열

    //O(2n)
    for(int i=0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
      rank[i] = i+1;
    }

    //O(N^2) -> N이 최악일 경우 2천 500억. Arrays.sort 를 쓰지 않고 구현할 방법?
    Arrays.sort(arr);//오름차 순으로 정렬.
    for(int i=0;i<n;i++){
      complaint[i] = Math.abs(rank[i]-arr[i]);
      answer+=complaint[i];
    }

    System.out.println(answer);
  }
}
