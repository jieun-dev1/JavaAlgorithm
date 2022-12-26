package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2891 {

  public int solution(int cnt, int[] damagedArr,int[] spareArr){
    int answer = damagedArr.length;//���� ��: ��ü �� - �ջ�� ��.
    int[] check = new int[cnt+1]; //��ü �� �� �ջ�� ���� ��ȣ�� üũ�ϴ� �迭. �ε��� ó���� ���ϰ�, +1�� ��.
    for(int i=0;i<damagedArr.length;i++){
      check[damagedArr[i]]=1; //1�̶�� �ջ�� ��. check�迭�� 0�����̴�, 1�� ����� ��.
    }
    for(int i=0;i<spareArr.length;i++){
      //�ش� �ε����� check �Ǿ� �ִ��� Ȯ��.
      if(check[spareArr[i]]==1){ //�ջ�� �� == ������ ��Ʈ ������ �ִ� ��.
        check[spareArr[i]]=0; //�ջ� ȸ��.
        answer--;
      } else {
        //�ش� �ε����� uncheck ���, �յ� Ȯ��.
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

    int team = Integer.parseInt(st.nextToken()); //�� ���� ��
    int damaged = Integer.parseInt(st.nextToken()); //�ջ�� ���� ��
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

    bw.flush(); //�����ִ� ���۸� ��� ������.
    br.close(); //��Ʈ�� �ݾ���
    bw.close(); //��Ʈ���ݾ���

  }
}
