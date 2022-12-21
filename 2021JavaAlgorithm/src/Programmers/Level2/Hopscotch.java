package Programmers.Level2;

public class Hopscotch {
  int solution(int[][] land) {
    int answer = 0;
    int[][] table = new int[land.length][land[0].length];
    for(int i=0;i<land.length;i++){
      for(int j=0;j<land[0].length;j++){
        int max = Integer.MIN_VALUE; //table[i]마다 max가 생기는 게 아니라, table[i][j]마다 생기는 것. 따라서 j안에 max를 계속 갱신해야 함. 이렇게 하지 않으면 이전의 max 값이 계속 따라옴.
        if(i==0){
          table[i][j] = land[i][j]; //첫 줄은 land와 동일하게 초기화
          continue;
        }
        //table[i][j]에 맞는 값을 찾기.
        //max 값을 찾고 해당 위치를 col 값에 저장.
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
    //원소 하나씩 읽으면서 ([i][j]의 최대값: i-1, 1 - land[0].length-1 중 j를 제외한 값을 읽기)
    // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    print(table);
    return answer;
  }

  void print(int[][] table){
    //table[i].length 가 아니라 i는 변하는 값이니 0이라고 해줄 것.
    for(int i=0;i<table[0].length;i++){
      System.out.println(table[1][i]);
    }
  }

  public static void main(String[] args) {
    Hopscotch T = new Hopscotch();
    System.out.println(T.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));

  }
}
