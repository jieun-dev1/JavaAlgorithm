package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

/**
 * 코드 참고: https://school.programmers.co.kr/questions/37079
 */
class MaxNum {
  public long solution(String expression){

    List<Long> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();
    String[] priority = new String[]{"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
    StringBuilder num = new StringBuilder("");

    //1.해당 for문에서는 O(100)*0(100*100) = O(100만)
    //O(100)
    for(int i=0;i<expression.length(); i++){
      char temp = expression.charAt(i);
      if(temp>='0'&& temp<='9') {
        num.append(temp);
        continue;
      }

      if(temp=='+'|| temp=='*'|| temp=='-'){
        //Long.parseLong: O(100) * O(100)
        nums.add(Long.parseLong(num.toString()));
        ops.add(temp);
        num = new StringBuilder(""); //다음 숫자를 위해 초기화
      }
    }
    //원래 기호 전에 nums.add를 해줬는데, 기호 다음에 숫자가 하나 더 있으니 여기서 add 해준다.
    // 마지막 숫자가 끝나고 continue에서 다음 for문으로 가면 인덱스가 끝나서 for문을 빠져나온다.
    //2.Long.parseLong: O(100) * O(100)
    nums.add(Long.parseLong(num.toString()));

    Long max = 0L;
    //3.Priority: 6개. expression은 길이가 100이하 이므로 연산자n-1+숫자 3자리 수*(n) = 4n-1 이 최대 100이므로. 최대 들어갈 수 있는 숫자 갯수 n은 26임. 연산자는 25개.
    //참고: Set(INDEX, ELEMENT): 특정 INDEX에 더하기 때문에 최악의 경우 (O(N)임)
    //아래 for 문 : o(1800)
    for (String pri: priority){ //6
      List<Long> numsC = new ArrayList<>(nums);
      List<Character> opsC = new ArrayList<>(ops);
      for(char c: pri.toCharArray()){ //3
        //i가 변화가 없어야, 삭제 뒤 index가 하나 줄었을 때, 다음 원소를 탐색가능.
        //총(o(26+26+25+25) = 약 o(100)
        for(int i=0;i<opsC.size();){ //25
          char op = opsC.get(i); //25
          if(i!=opsC.size()&&op!=c){
            i++;
            continue;
          }
          else if(op=='*'){
            numsC.set(i, numsC.get(i)*numsC.get(i+1)); //O(26)
          }
          else if(op=='+'){
            numsC.set(i, numsC.get(i)+numsC.get(i+1)); //O(26)
          }

          else if(op=='-'){
            numsC.set(i, numsC.get(i)-numsC.get(i+1)); //O(26)
          }
          numsC.remove(i+1); //O(26)
          opsC.remove(i); //O(25)
        }
      }
      max = Math.max(max, Math.abs(numsC.get(0)));
    }
    return max;
  }

  public static void main(String[] args) {
    MaxNum T = new MaxNum();
    System.out.println(T.solution("100-200*300-500+20"));
  }
}
