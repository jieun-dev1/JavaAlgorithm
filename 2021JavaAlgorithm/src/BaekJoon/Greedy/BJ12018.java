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
 * 소요시간: 1시간
 */
public class BJ12018 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    //첫 줄
    int subject = Integer.parseInt(st.nextToken()); //과목 수
    int miles = Integer.parseInt(st.nextToken()); //마일리지 수
    //각 과목 별로 최소 점수가 들어갈 배열.
    int[] score = new int[subject]; //마일리지 배열

    //과목에 등록한 참가자 수, 정렬, 마지노선에서 성준이의 최소 마일리지를 찾아 배열에 넣기.
    //정렬 시, 내림차 순인지 오름차순인지 꼼꼼하게!
    //subject 수 만큼, readLine이 2개씩 들어가야 함.
    for(int i=0;i<subject;i++){
      st = new StringTokenizer(br.readLine());
      int student = Integer.parseInt(st.nextToken());
      int limit = Integer.parseInt(st.nextToken());

      //얘를 먼저해주는 게 더 효율적이다. (limit이 더 많다면,
      // 굳이 마일리지 리스트를 받아서 정렬해서 limit 번째의 수를 score에 넣을 필요가 없다.
      if(limit>student){
        score[i] = 1; //최소 마일리지 값.
        continue; //if를 할 때, if/else로 나누기보다 continue 활용이 깔끔함.
      }

      //limit이 더 적어서, limit-1번째 학생까지만 들어갈 수 있을 떄.
      st = new StringTokenizer(br.readLine());
      Integer[] arr = new Integer[student];
      for(int j=0;j<student;j++){
        arr[j] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(arr, Collections.reverseOrder()); //과목은 내림차순으로 해야, 마지막 한계점에서 최소값을 찾는다
      score[i] = arr[limit-1];

    }

    //score 를 오름차 순 정렬.
    Arrays.sort(score); //score는 오름차순이지만.
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
