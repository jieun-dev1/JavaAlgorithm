package Programmers.Level2;

public class Hopscotch {
  int solution(int[][] land) {
    int answer = 0;
    int[][] table = new int[land.length][land[0].length];
    for(int i=0;i<land.length;i++){
      for(int j=0;j<land[0].length;j++){
        int max = Integer.MIN_VALUE; //table[i]���� max�� ����� �� �ƴ϶�, table[i][j]���� ����� ��. ���� j�ȿ� max�� ��� �����ؾ� ��. �̷��� ���� ������ ������ max ���� ��� �����.
        if(i==0){
          table[i][j] = land[i][j]; //ù ���� land�� �����ϰ� �ʱ�ȭ
          continue;
        }
        //table[i][j]�� �´� ���� ã��.
        //max ���� ã�� �ش� ��ġ�� col ���� ����.
          for(int k=0;k<land[0].length;k++){
            if(k==j) {
              continue;
            }
            max = Math.max(table[i-1][k], max);
          }
          table[i][j] = max+land[i][j];
        }
        }
    for(int i=0;i<land[0].length;i++){
      answer = Math.max(answer, table[land.length-1][i]);
    }
    //���� �ϳ��� �����鼭 ([i][j]�� �ִ밪: i-1, 1 - land[0].length-1 �� j�� ������ ���� �б�)
    // [����] ��ư�� ������ ��� ���� �� �� �ֽ��ϴ�.
    print(table);
    return answer;
  }

  void print(int[][] table){
    //table[i].length �� �ƴ϶� i�� ���ϴ� ���̴� 0�̶�� ���� ��.
    for(int i=0;i<table[0].length;i++){
      System.out.println(table[1][i]);
    }
  }

  public static void main(String[] args) {
    Hopscotch T = new Hopscotch();
    System.out.println(T.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));

  }
}
