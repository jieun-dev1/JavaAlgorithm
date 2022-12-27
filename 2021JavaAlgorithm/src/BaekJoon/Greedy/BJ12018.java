package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * �ҿ�ð�: 1�ð�
 */
public class BJ12018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    //ù ��
    int subject = Integer.parseInt(st.nextToken()); //���� ��
    int miles = Integer.parseInt(st.nextToken()); //���ϸ��� ��
    //�� ���� ���� �ּ� ������ �� �迭.
    int[] score = new int[subject]; //���ϸ��� �迭

    //���� ����� ������ ��, ����, �����뼱���� �������� �ּ� ���ϸ����� ã�� �迭�� �ֱ�.
    //���� ��, ������ ������ ������������ �Ĳ��ϰ�!
    //subject �� ��ŭ, readLine�� 2���� ���� ��.
    for(int i=0;i<subject;i++){
      st = new StringTokenizer(br.readLine());
      int student = Integer.parseInt(st.nextToken());
      int limit = Integer.parseInt(st.nextToken());

      //�긦 �������ִ� �� �� ȿ�����̴�. (limit�� �� ���ٸ�,
      // ���� ���ϸ��� ����Ʈ�� �޾Ƽ� �����ؼ� limit ��°�� ���� score�� ���� �ʿ䰡 ����.
      if(limit>student){
        score[i] = 1; //�ּ� ���ϸ��� ��.
        continue; //if�� �� ��, if/else�� �����⺸�� continue Ȱ���� �����.
      }

      //limit�� �� ���, limit-1��° �л������� �� �� ���� ��.
      st = new StringTokenizer(br.readLine());
      Integer[] arr = new Integer[student];
      for(int j=0;j<student;j++){
        arr[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr, Collections.reverseOrder()); //������ ������������ �ؾ�, ������ �Ѱ������� �ּҰ��� ã�´�
      score[i] = arr[limit-1];

    }

    //score �� ������ �� ����.
    Arrays.sort(score); //score�� ��������������.
    int answer = 0;

    int currentSum = 0;
    for(int i=0;i< score.length;i++){
      currentSum+=score[i];
      if(currentSum>miles){
        break;
      }
      answer++;
    }

//    for(int i=0;i<score.length;i++){
//      if(miles>=score[i]){
//        miles-=score[i];
//        answer++;
//      }
//    }
    sb.append(answer);
    bw.write(sb.toString());

    bw.flush();
    br.close();
    bw.close();

  }
}
