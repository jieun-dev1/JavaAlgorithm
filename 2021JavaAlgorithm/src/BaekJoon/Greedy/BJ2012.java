package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * ���̵�: �ǹ� 3
 */
public class BJ2012 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long answer = 0;
    int n = Integer.parseInt(st.nextToken());//�л� ��
    int[] arr = new int[n]; //arr���� �־��� ���ڸ� ������� ���� �ڿ�, �̸� ������������ ����.
    int[] rank = new int[n]; //arr�� ������ ũ���� �迭�� 1-n ũ��� ����. .
    long[] complaint = new long[n]; //�Ҹ��� �迭

    //O(2n)
    for(int i=0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
      rank[i] = i+1;
    }

    //O(N^2) -> N�� �־��� ��� 2õ 500��. Arrays.sort �� ���� �ʰ� ������ ���?
    Arrays.sort(arr);//������ ������ ����.
    for(int i=0;i<n;i++){
      complaint[i] = Math.abs(rank[i]-arr[i]);
      answer+=complaint[i];
    }

    System.out.println(answer);
  }
}
