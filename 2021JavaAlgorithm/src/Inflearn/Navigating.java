package Inflearn;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * ������  - ���Ž�� ���� ����Ʈ ����. ��� ������ Ž���ϴ� �Ŷ� DFS ��� �ϴ� �� ����.
 *
 * IndexOutOfBoundsException: Index: 1, Size: 0
 * ->0��°�� null�� �� ��쿡�� 1���� �����͸� ���� �� ���� �����̴�.
 *
 */
public class Navigating {

  static int n; //�־��� Number�� ����
  static int m; //�־��� ����� ��
  static ArrayList<ArrayList<Integer>> graphList = new ArrayList<>();
  static int answer;
  static int[] ch; //n�� �������� �ʾұ� ������, n�� �������� ���� �Ҵ������ ��.

  public void DFS(int point){
    //��ǥ ������ �����ߴٸ�, answer�� �߰��ϰ�
    if(point==n){
      answer++;
    } else {
//      ch[point] = 1; //�湮�� point�� check �迭�� ǥ��. �̰� �ʿ� ���� �ʳ�?
      for(int i=0;i<graphList.get(point).size();i++){
        int temp = graphList.get(point).get(i);
        if(ch[temp]==0){
          ch[temp] = 1;
          DFS(temp);
          ch[temp] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Navigating T = new Navigating();
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    ch = new int[n+1];
    //n���� �����ϴϱ�, n�� ���� �̾����� ���� ArrayList�� ǥ���� �ʿ�x
    for(int i=0;i<n;i++){
      graphList.add(i, new ArrayList<Integer>());
    }
    for(int i=0;i<m;i++){
      int a = sc.nextInt();
      int b = sc.nextInt();
      graphList.get(a).add(b);
    }
    ch[1] = 1; //DFS�� �����ϱ� ����, 1�� CH �迭���� üũ�ϴ� �� �ٽ���.
    T.DFS(1);
    System.out.println(answer);
  }


/**
 * input
 *
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */

}

