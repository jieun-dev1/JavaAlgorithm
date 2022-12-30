package BaekJoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2606 {
  static List<Integer>[] list;
  static int[] ch;
  static int answer = 0;

  public void DFS(int start){
    List<Integer> adjacent = list[start];
    //adjacent�� �� �迭���� Ȯ�������� ������ NullPointer�� ��
    if(adjacent!=null){ //isEmpty�� �ƴ�. ������ �ȵǾ� ���� ��� list[start]�� ���Ұ� ����. 2) while -> if �� ���� (while �̶�� ���� �ݺ��̶� ����������, if�� �ѹ��� üũ��)
      //o(100)
      for(int i=0;i<adjacent.size();i++){
        int temp = adjacent.get(i); //temp�� ��������Ʈ�� ���ʷ� �о���� ���̴�. �𸣰� ch[adjacent.get(i)]�� �ߴµ�, �̷��� 0 Ȥ�� 1�� ����
        if(ch[temp]==0){
          ch[temp]=1;
          DFS(temp); //static�� �ƴϱ� ������ ��ü �����ؼ� T �� �������� �ʾƵ� ��.
//          ch[temp]=0;
        }
      }
    }

  }

  public static void main(String[] args) throws IOException {
    BJ2606 T = new BJ2606();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //�� ������ ���� ch ���� �ľ�. ���� ����Ʈ�� ���� ��ŭ �������.
    StringTokenizer st = new StringTokenizer(br.readLine());
    int computer = Integer.parseInt(st.nextToken());
    list = new ArrayList[computer+1];
    ch = new int[computer+1];
    //���� ����Ʈ �ʱ�ȭ pair ���� +1 ��ŭ ����, �ε����Ű� �Ⱦ�����.
    st = new StringTokenizer(br.readLine());
    int pair = Integer.parseInt(st.nextToken());
    //O(100)
    for(int i=1;i<computer+1;i++) { //pair+1�� ����� �Ǽ�.
    list[i] = new ArrayList<>();
    }
      //���ҿ� �ϳ��� ArrayList �־����. ���ʿ� ������ش� ����⿬���̴ϱ�.
    //pair�� �ִ� 10000��.
    for(int i=0;i<pair;i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      list[x].add(y);
      list[y].add(x);
    }
    T.DFS(1); //DFS �� NON STATIC �޼����, NON-STATIC���� REFER �Ұ�.

    //answerCh�� �ƴ϶� ch�� üũ��. ch�� DFS ������ 0���� �Ǽ�, DFS �� ��� ������ �� 0���� �ʱ�ȭ ��.
    //o(100)
    for(int i=0;i<ch.length;i++){
      if(ch[i]==1){
        answer++;
      }
    }
    System.out.println(answer-1);
  }
}
