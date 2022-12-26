package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2891 {

  public int solution(int cnt, int[] damagedArr,int[] spareArr){
    int answer = damagedArr.length;//시작 값: 전체 팀 - 손상된 팀.
    int[] check = new int[cnt+1]; //전체 팀 중 손상된 팀의 번호를 체크하는 배열. 인덱스 처리가 편리하게, +1로 함.
    for(int i=0;i<damagedArr.length;i++){
      check[damagedArr[i]]=1; //1이라면 손상된 것. check배열은 0부터이니, 1을 빼줘야 함.
    }
    for(int i=0;i<spareArr.length;i++){
      //해당 인덱스가 check 되어 있는지 확인.
      if(check[spareArr[i]]==1){ //손상된 팀 == 여분의 보트 가지고 있는 팀.
        check[spareArr[i]]=0; //손상 회복.
        answer--;
      } else {
        //해당 인덱스가 uncheck 라면, 앞뒤 확인.
        if(spareArr[i]-1>=1&&check[spareArr[i]-1]==1){
          check[spareArr[i]-1]=0;
          answer--;
        } else if(spareArr[i]+1<=cnt&&check[spareArr[i]+1]==1){
          check[spareArr[i]+1]=0;
          answer--;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) throws IOException {
    BJ2891 T = new BJ2891();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int team = Integer.parseInt(st.nextToken()); //총 팀의 수
    int damaged = Integer.parseInt(st.nextToken()); //손상된 팀의 수
    int spare = Integer.parseInt(st.nextToken());
    int[] damagedArr = new int[damaged];
    int[] spareArr = new int[spare];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<damaged;i++){
      damagedArr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<spare;i++){
      spareArr[i] = Integer.parseInt(st.nextToken());
    }
    sb.append(T.solution(team, damagedArr, spareArr));
    sb.append("\n");

    bw.write(sb.toString());

    bw.flush(); //남아있는 버퍼를 모두 내보냄.
    br.close(); //스트림 닫아줌
    bw.close(); //스트림닫아줌

  }
}
