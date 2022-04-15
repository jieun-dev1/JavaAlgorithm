package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

//��� �Ƴ��׷� ã��.
public class Search {

	public int solution(String s, String t) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        int count = 0;
        int lt = 0;

        //�־��� ���� ���ؼ� HashMap�� �����.
        for(char x : t.toCharArray()){
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }

        //am ��ü�� �� �����̵� Ʋ�� ����� (t�� length ���� -1 ���� ���̷�)
        int L = t.length() - 1;
        //Ű ���� charAt(i) �� ã���ֱ�.
        for(int i=0;i<L;i++){
            am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        }

        //rt�� �ϳ��� �о��ֱ�.
        for(int rt=L;rt<s.length();rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)) count++;
            //�̷��� �ϸ� �ȵ�.
            //            am.put(s.charAt(lt), am.getOrDefault(s.charAt(lt), 0) - 1);
            //�� �� �̻��� ����, Ű�� ���� 1�� ���ֵ��� �ϰ� 0�̸� �ƿ�����.
            am.put(s.charAt(lt), am.get(s.charAt(lt))-1);
            if(am.get(s.charAt(lt)) == 0) am.remove(s.charAt(lt));
            lt++; //lt �� �������� ������ �ؾ��Ѵ�. �� ���� �ϸ� ������ lt ���� ���� �Ǵϱ�.
        }

        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search T = new Search();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		System.out.println(T.solution(s, t));

	}
}
