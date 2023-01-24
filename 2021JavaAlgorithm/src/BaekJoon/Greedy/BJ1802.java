package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * �ڵ� ����: https://velog.io/@ehdcks3421/%EB%B0%B1%EC%A4%80-%EC%A2%85%EC%9D%B4-%EC%A0%91%EA%B8%B0-1802
 */


public class BJ1802 {
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    //������ ���� ����Ʈ.
    ArrayList<String> list=new ArrayList<String>();
    //�־����� ���ڿ� ����
    int t=Integer.parseInt(br.readLine());
    //���ڿ� ���� ��ȸ
    for(int n=0; n<t; n++)
    {
      String s=br.readLine();
      //���̰� 1�����  Yes�� (in/out - �� 0/1 �� ���� ���� �� �ֱ� �����̴�.
      if(s.length()==1)
      {
        list.add("YES");
        continue;
      }

      int len = s.length();
      int idx = len/2; //idx �� �ʱⰪ�� ������ �߾�.
      boolean stop = false; // ���� stop true���, 1-0��Ī�� �ƴϱ� ������ �� �̻� ��ȸ���� �ʰ� break�Ѵ�.
      while(idx!=0){
        //i�� ����, j�� �����ʿ��� ��ȸ ����.
        for(int i=0,j=len-1;i<idx;i++,j--){
          if(s.charAt(i)==s.charAt(j)){
            stop = true;
            break;
          }
        }

        //��� ��������, ��Ī�̴���, ��� �ٸ� �������� ��ȸ�ؾ� �Ѵ�.
        len/=2;
        idx/=2;

      }

      if(stop){
        list.add("NO");
      } else {
        list.add("YES");
      }



    }

    for(int i=0; i<list.size(); i++)
      System.out.println(list.get(i));
  }
}

//}
