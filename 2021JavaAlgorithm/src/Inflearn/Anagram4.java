package Inflearn;

import java.util.*;

//인프런 HashMap 4번 다시 풀기
//hashmap을 하나만 만들고, a 는 char Array 순회하면서 값에서 -1을 하고, 값이 모두 0이면 answer ++; 구현 -> 어떻게 하는지 모르겠다.. :)
//HashMap을 두개써야함. am을 슬라이딩 윈도우로, lt 값을 빼고 remove 한 뒤 새로 들어온 rt 값 더하기.

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

        //초기 세팅
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
