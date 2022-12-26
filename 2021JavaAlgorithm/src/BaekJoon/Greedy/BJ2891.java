package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2891 {

  public int solution(int cnt, int[] dmgArr,int[] moreArr){
    int answer = dmgArr.length;//���� ��: ��ü �� - �ջ�� ��.
    int[] cntArr = new int[cnt];
    for(int i=0;i<dmgArr.length;i++){
      cntArr[dmgArr[i]-1]-=1;
    }
    for(int i=0;i<moreArr.length;i++){
      cntArr[moreArr[i]-1]+=1;
    }
    for(int i=0;i<cntArr.length;i++){
      if(cntArr[i]==1){
        if(i+1<=4&&cntArr[i+1]==-1){
          cntArr[i+1]+=1;
          cntArr[i]-=1;
          answer--;//������ �� ��
        } else if(i-1>=0&&cntArr[i-1]==-1) {
          cntArr[i-1]+=1;
          cntArr[i]-=1;
          answer--;//������ �� ��
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

    int team = Integer.parseInt(st.nextToken()); //�� ���� ��
    int damaged = Integer.parseInt(st.nextToken()); //�ջ�� ���� ��
    int spare = Integer.parseInt(st.nextToken());
    int[] dmgArr = new int[damaged];
    int[] moreArr = new int[spare];
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<damaged;i++){
      dmgArr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0;i<spare;i++){
      moreArr[i] = Integer.parseInt(st.nextToken());
    }
    sb.append(T.solution(team, dmgArr, moreArr));
    sb.append("\n");

    bw.write(sb.toString());

    bw.flush(); //�����ִ� ���۸� ��� ������.
    br.close(); //��Ʈ�� �ݾ���
    bw.close(); //��Ʈ���ݾ���

  }
}
