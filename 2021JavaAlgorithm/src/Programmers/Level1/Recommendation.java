package Programmers.Level1;

public class Recommendation {

  public String solution(String new_id) {
    String answer = "";
    //1�ܰ�:��� �빮�ڸ� �����Ǵ� �ҹ��ڷ� ġȯ
    answer = new_id.toLowerCase();
    //2�ܰ�:���ĺ� �ҹ���, ����, ����(-), ����(_), ��ħǥ(.)�� ������ ��� ���ڸ� ���� - ���Խ�
    //^�� not�� �ǹ��Ѵ�.
    //replaceAll �޼���� String ���� ��ȯ�� ���ֱ� ������, ���� ����(answer=����) �Ҵ������ ��.
    answer = answer.replaceAll("[^a-z0-9-_.]", "");

    //3�ܰ�: ��ħǥ(.)�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ(.)�� ġȯ {n,} �ּ��� n��

    answer = answer.replaceAll("[.]{2,}", ".");

    //4�ܰ�: ��ħǥ�� ó���̳� ���� ��ġ�Ѵٸ� ����. .�� []�ȿ� �־�� ��.
    answer = answer.replaceAll("^[.]", "");
    answer = answer.replaceAll("[.]$", "");

    //5�ܰ�:�� ���ڿ��̶��, new_id�� "a"�� ����
    if (answer.equals("")) {
      answer += "a";
    }

    //6�ܰ� new_id�� ���̰� 16�� �̻��̸�, new_id�� ù 15���� ���ڸ� ������ ������ ���ڵ��� ��� ����
    if (answer.length() >= 16) {
      answer = answer.substring(0, 15);
      answer = answer.replaceAll("[.]$", "");
    }
    //���� ���� �� ��ħǥ(.)�� new_id�� ���� ��ġ�Ѵٸ� ���� ��ġ�� ��ħǥ(.) ���ڸ� ����

    //7�ܰ�: ���̰� 2�� ���϶��, new_id�� ������ ���ڸ� new_id�� ���̰� 3�� �� ������ �ݺ�
    //�Լ� �ۿ� �Ҵ��� ���, temp�� ������ �ʴ´�. �������� ���ϴ� answer�� �������� ��� ��.
    //    int temp = answer.length();
    //    char last = answer.charAt(temp-1);
    //
    //    if (temp <= 2) {
    //      while (temp <= 3) {
    //        answer += last;
    //      }
    //    }
    if(answer.length()<=2) {
      while(answer.length()<3) {
        answer+=answer.charAt(answer.length()-1);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Recommendation T = new Recommendation();
    System.out.println(T.solution(	"...!@BaT#*..y.abcdefghijklm"));

  }
}
