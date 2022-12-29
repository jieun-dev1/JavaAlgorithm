package Programmers.Level2.Kakao;

import java.util.ArrayList;
import java.util.List;

/**
 * �ڵ� ����: https://school.programmers.co.kr/questions/37079
 */
class MaxNum {
  public long solution(String expression){

    List<Long> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();
    String[] priority = new String[]{"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
    StringBuilder num = new StringBuilder("");

    //1.�ش� for�������� O(100)*0(100*100) = O(100��)
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
        num = new StringBuilder(""); //���� ���ڸ� ���� �ʱ�ȭ
      }
    }
    //���� ��ȣ ���� nums.add�� ����µ�, ��ȣ ������ ���ڰ� �ϳ� �� ������ ���⼭ add ���ش�.
    // ������ ���ڰ� ������ continue���� ���� for������ ���� �ε����� ������ for���� �������´�.
    //2.Long.parseLong: O(100) * O(100)
    nums.add(Long.parseLong(num.toString()));

    Long max = 0L;
    //3.Priority: 6��. expression�� ���̰� 100���� �̹Ƿ� ������n-1+���� 3�ڸ� ��*(n) = 4n-1 �� �ִ� 100�̹Ƿ�. �ִ� �� �� �ִ� ���� ���� n�� 26��. �����ڴ� 25��.
    //����: Set(INDEX, ELEMENT): Ư�� INDEX�� ���ϱ� ������ �־��� ��� (O(N)��)
    //�Ʒ� for �� : o(1800)
    for (String pri: priority){ //6
      List<Long> numsC = new ArrayList<>(nums);
      List<Character> opsC = new ArrayList<>(ops);
      for(char c: pri.toCharArray()){ //3
        //i�� ��ȭ�� �����, ���� �� index�� �ϳ� �پ��� ��, ���� ���Ҹ� Ž������.
        //��(o(26+26+25+25) = �� o(100)
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
