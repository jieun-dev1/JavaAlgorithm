package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 코드 참고: https://velog.io/@ehdcks3421/%EB%B0%B1%EC%A4%80-%EC%A2%85%EC%9D%B4-%EC%A0%91%EA%B8%B0-1802
 */


public class BJ1802 {
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    //정답을 넣을 리스트.
    ArrayList<String> list=new ArrayList<String>();
    //주어지는 문자열 개수
    int t=Integer.parseInt(br.readLine());
    //문자열 마다 순회
    for(int n=0; n<t; n++)
    {
      String s=br.readLine();
      //길이가 1개라면  Yes다 (in/out - 즉 0/1 의 경우로 접힐 수 있기 때문이다.
      if(s.length()==1)
      {
        list.add("YES");
        continue;
      }

      int len = s.length();
      int idx = len/2; //idx 의 초기값은 길이의 중앙.
      boolean stop = false; // 만약 stop true라면, 1-0대칭이 아니기 때문에 더 이상 순회하지 않고 break한다.
      while(idx!=0){
        //i는 왼쪽, j는 오른쪽에서 순회 시작.
        for(int i=0,j=len-1;i<idx;i++,j--){
          if(s.charAt(i)==s.charAt(j)){
            stop = true;
            break;
          }
        }

        //가운데 정점에서, 대칭이더라도, 계속 다른 정점으로 순회해야 한다.
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
