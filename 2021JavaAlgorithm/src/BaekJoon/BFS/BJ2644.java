package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2644 {

  public int solution(int n, int x, int y, ArrayList<ArrayList<Integer>> list){
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    int[] ch = new int[n+1];
    queue.add(x);
    ch[x] = 1;
    while(!queue.isEmpty()){
      int len = queue.size();
      //i�� ���� queue�� ũ�� ��ŭ ��ȸ�ϴ� len�̴�.
      for(int i=0;i<len;i++){
        int temp = queue.poll();
        // ��� 1: �켱�� �ְ� queue�� �̾��� �� Ȯ��
        if(temp==y){
              return answer;
            }
        //j: temp �� ����� ����Ʈ�� ������
        ArrayList<Integer> tempList = list.get(temp);
        for(int j=0;j<tempList.size();j++){
          if(ch[tempList.get(j)]==0){
            queue.offer(tempList.get(j));
            ch[tempList.get(j)]=1;
// ��� 2: �� ȿ����
//            if(tempList.get(j)==y){
//              answer++;
//              return answer;
//            }
          }
        }
//        answer++;
      }
      answer++;

    }
    //��ǥ ������ �湮�� �Ǿ� �ִٸ� answer ����.
    if(ch[y]==1){
      return answer;
    } else {
      return -1;
    }
  }
  public static void main(String[] args) throws IOException {
    BJ2644 T = new BJ2644();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    StringTokenizer st2= new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st2.nextToken());
    int y = Integer.parseInt(st2.nextToken());
    StringTokenizer st3= new StringTokenizer(br.readLine());
    int pair = Integer.parseInt(st3.nextToken());
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    //���� ����Ʈ�� �������� ���������, n ��ŭ ������.
    for(int i=0;i<=n;i++){
      list.add(new ArrayList<Integer>()); //Ư�� ��ġ�� ArrayList�� �ʱ�ȭ �Ѵ�.
//      list.add(1, new ArrayList<Integer>()); //Ư�� ��ġ�� ArrayList�� �ʱ�ȭ �Ѵ�.
      //0�� �ǳ� �ٰ� 1���� �����ϱ� �־����� �ʰ� IndexOutOfArray ������ ��. list�� ���������� ���ؼ� �׷�������.
      //�׳� 1�� �� ���������.
    }

    //��������Ʈ ���� �� ��������� Ȯ�� �ʿ�
    for(int i=1;i<=pair;i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      list.get(a).add(b);
      list.get(b).add(a);

    }
    System.out.println(T.solution(n, x, y, list));
  }
}
