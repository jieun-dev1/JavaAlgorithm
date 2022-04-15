package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

//모든 아나그램 찾기.
public class Search {

	public int solution(String s, String t) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();
        int count = 0;
        int lt = 0;

        //주어진 값에 대해서 HashMap을 만들고.
        for(char x : t.toCharArray()){
            bm.put(x, bm.getOrDefault(x, 0)+1);
        }

        //am 전체열 중 슬라이딩 틀을 만들기 (t의 length 보다 -1 작은 길이로)
        int L = t.length() - 1;
        //키 값은 charAt(i) 로 찾아주기.
        for(int i=0;i<L;i++){
            am.put(s.charAt(i), am.getOrDefault(s.charAt(i), 0) + 1);
        }

        //rt를 하나씩 밀어주기.
        for(int rt=L;rt<s.length();rt++) {
            am.put(s.charAt(rt), am.getOrDefault(s.charAt(rt), 0) + 1);
            if(am.equals(bm)) count++;
            //이렇게 하면 안됨.
            //            am.put(s.charAt(lt), am.getOrDefault(s.charAt(lt), 0) - 1);
            //두 개 이상일 떄는, 키의 값의 1을 빼주도록 하고 0이면 아예빼자.
            am.put(s.charAt(lt), am.get(s.charAt(lt))-1);
            if(am.get(s.charAt(lt)) == 0) am.remove(s.charAt(lt));
            lt++; //lt 는 기존값을 뺴고나서 해야한다. 그 전에 하면 증가된 lt 값을 뺴게 되니까.
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
