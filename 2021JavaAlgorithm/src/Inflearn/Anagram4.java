package Inflearn;

import java.util.*;

//������ HashMap 4�� �ٽ� Ǯ��
//hashmap�� �ϳ��� �����, a �� char Array ��ȸ�ϸ鼭 ������ -1�� �ϰ�, ���� ��� 0�̸� answer ++; ���� -> ��� �ϴ��� �𸣰ڴ�.. :)
//HashMap�� �ΰ������. am�� �����̵� �������, lt ���� ���� remove �� �� ���� ���� rt �� ���ϱ�.

public class Anagram4 {
    public int solution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x: b.toCharArray()){
            bm.put(x, bm.getOrDefault(x,0)+1);
        }

        int lt = 0;
        int L = b.length()-1;

        //�ʱ� ����
        for(int i=0;i<b.length()-1;i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        for(int rt=L;rt<a.length();rt++){
            am.put(a.charAt(rt),am.getOrDefault(a.charAt(rt), 0) + 1);
            if (am.equals(bm)) {
                answer ++;
            }
            am.put(a.charAt(lt),am.get(a.charAt(lt))-1);
            if (am.get(a.charAt(lt))==0) {
                am.remove(a.charAt(lt));
            }

            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Anagram4 T = new Anagram4();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(T.solution(a, b));
    }
}
