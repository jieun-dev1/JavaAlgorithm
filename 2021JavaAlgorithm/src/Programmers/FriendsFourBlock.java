package Programmers;

import java.util.ArrayList;

/**
 * �� ������ Ǯ�鼭 ������� �� - ���� ���̵� �� �´�.
 *
 * �ٽ������� ���� ��.
 *
 * 1. 2X2¦�� �߰��ϸ�, �����ϴ� �� ��� ���� ���̵� ���� �� - STACK���θ� �����غôµ� �迭�δ� ��� ����? -> Ư�� ��ġ�� 0�� �������൵ �ȴ�. ���� LIST�� ���� ��.
 * 2. ���� �迭�� �ͼ����� �ʴ�. ��ȸ�� ��, M-1/N-1��ŭ�� ���� �ǰ�, 4�� ���� ��� ��ȸ�ؼ� ��� ������ TRUE �̴�. �̶�, ���ĵ� ��� ����.
 * 3. update - 2���� �迭 �ٷ� ��, ����� [m][n] ��, [��][��]�̴�.
 * 4. ������ �迭�� ã�� ���ּ� �ٽ� ������Ʈ ���� ��, n(��)�� �������� m(��)�� �ٲ㰡�� �˻��Ѵ�.
 *
 * ��������
 * 1. ���� Ʋ�ȴ� ���� - ch�迭�� static���� ���, ���� ����� ���������� �ʾұ� ����.
 * -> mark�� �ϳ��� ���������� ����, ������������ ch �迭�� ������ִ� ������ ��.
 * 2. 0�� ���̾��� ���� - ó���� flag �� false �� �༭, while ���� �ѹ��� �õ����� ����.
 * ó���� true ���� ��. (mark �ȿ��� �ٽ� false �� ���ְ�, true �� �߰ߵǸ� true �� �ٲ��ֱ�)
 *
 * ��
 * ���� �޼���� ���� �� ����, static ���� Ȱ���ϴ� �� ����. �׸��� solution���� �Ҵ��ϴ� ������ ����.
 */

//�ð����⵵ �� 94000
public class FriendsFourBlock {
  static char[][] matrix;
  static int m;
  static int n;
  static int answer;
  static boolean flag = true; //�������� false �� while���� �� �� ����.

  public int solution(int m, int n, String[] board) {
    this.m = m;
    this.n = n;
    matrix = new char[m][n];
    answer = 0;

    //1. �迭 �ʱ�ȭ: O(900)
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        char temp = board[i].charAt(j);
        matrix[i][j] = temp;
      }
    }
    //2. �� �� MARK �� �Ͼ ������, UPDATE �ʿ�.
    while(flag==true){
      //O(900)
      boolean[][] ch = mark(m, n);
      //O(92700)
      answer+=update(m,n, ch);
    }
    return answer;
  }

  //3. mark�� ����: ������ ��� �ľ��ϱ�: ch �迭�� true false�� ����� ���� ����.
  //������ flag�� false ����, answer+=update 0���� ���� ��.
  public boolean[][] mark(int m, int n){
    flag = false;
    boolean[][] ch = new boolean[m][n];
    for(int i=0;i<m-1;i++){
      for(int j=0;j<n-1;j++){
        char point = matrix[i][j];
        if(point!='0'&&point==matrix[i][j+1]&&point==matrix[i+1][j]&&point==matrix[i+1][j+1]){
          ch[i][j]=true;
          ch[i][j+1]=true;
          ch[i+1][j]=true;
          ch[i+1][j+1]=true;
          flag = true;
        }
      }
    }
//    System.out.println(matrix[3][4]); // matrix �� ������ Ȯ�� - F ���� ��.
    System.out.println(ch[1][1]); //true ���� ��.
    return ch;
  }

  //4. update �� ������� ���� ������ cnt�� ��ȯ�ؼ� �Ź� ������������ �����ش� + true�� ���ְ� '0'�� �����ش�.
  //�ุ �ٲ�� ������ i�� �ƴ�, j�� �ٲ�� j�� ����(��)��ġ�� ���ִ� ���� ����Ʈ.
  public int update(int m, int n, boolean[][] ch){
    int cnt = 0;
    //o(30*((30*30)+30)) = 30*930 = 92700
    for(int i=0;i<n;i++){
      ArrayList<Character> list = new ArrayList<>();
      for(int j=0;j<m;j++){
        if(ch[j][i]==true) {
          //O(30) �ִ� ���� ����. �ε����� �����ؼ� ���ϸ� O(N)�̴�.
          list.add(0, '0');
          cnt++;
        } else {
          list.add(matrix[j][i]);
        }
      }
      //O(30)
      for(int j=0;j<m;j++){
        matrix[j][i] = list.get(j); //list�� ��� ���ҵ�� matrix �迭 �������ֱ�. //�������.
      }
    }
    System.out.println(cnt);
    return cnt;
  }

  public static void main(String[] args) {
    FriendsFourBlock T = new FriendsFourBlock();
    System.out.println(T.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
  }
}